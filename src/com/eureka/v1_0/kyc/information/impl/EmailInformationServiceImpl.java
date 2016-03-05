/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eureka.v1_0.kyc.information.impl;

import com.eureka.v1_0.account.information.service.AccountService;
import com.eureka.v1_0.kyc.information.entities.EmailInformation;
import com.eureka.v1_0.kyc.information.service.EmailInformationService;
import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ceowit
 */
@Service(value = "emailInformationServiceImpl")
public class EmailInformationServiceImpl implements EmailInformationService {

    @PersistenceContext(name = "com.eureka.v1_0.kyc-information-service-persistence-unit")
    EntityManager em;

    @Autowired
    @Qualifier(value = "accountServiceImpl")
    AccountService accountService;

    @Override
    @Transactional
    public EmailInformation createEmailInformation(EmailInformation emailInformation) throws Exception {
        if (emailInformation != null) {
            try {
                emailInformation.setAccount(this.accountService.getByName(emailInformation.getAccount().getAccountName()));
                emailInformation.setCreationDate(Calendar.getInstance().getTime());
                emailInformation.setExternalUid(RandomStringUtils.randomAlphanumeric(128));
                this.em.persist(emailInformation);
                return emailInformation;
            } finally {
                if (em != null) {
                    em.close();
                }
            }
        }
        throw new NullPointerException("Email Information cannot be NULL. Please send a valid object");
    }

    @Override
    public List<EmailInformation> listAccountEmailInformation(String accountName) throws Exception {
        return this.em.createQuery("select e from EmailInformation e where e.account.accountName = :accountName")
                .setParameter("accountName", accountName).getResultList();
    }

    @Override
    public EmailInformation validateEmailInformation(String accountName, String emailAddress) throws Exception {
        List<EmailInformation> emailInformations = this.em.createQuery("select e from EmailInformation e where e.account.accountName = :accountName and e.emailAddress = :email")
                .setParameter("accountName", accountName)
                .setParameter("email", emailAddress)
                .getResultList();
        return emailInformations != null && !emailInformations.isEmpty() ? emailInformations.get(0) : null;
    }

    @Override
    @Transactional
    public Boolean deleteEmailInformation(String accountName, String emailAddress) throws Exception {
        try {
            EmailInformation persistedEmailInformation = this.validateEmailInformation(accountName, emailAddress);
            if (persistedEmailInformation != null) {
                this.em.remove(persistedEmailInformation);
                return Boolean.TRUE;
            }
            throw new NullPointerException("Cannot find the email information request. Please send a valid object");
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    @Transactional
    public EmailInformation updateEmailInformation(EmailInformation persistedEmailInformation) throws Exception {
        try {
            this.em.merge(persistedEmailInformation);
            return persistedEmailInformation;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

}
