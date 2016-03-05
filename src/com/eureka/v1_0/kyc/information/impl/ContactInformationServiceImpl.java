/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eureka.v1_0.kyc.information.impl;

import com.eureka.v1_0.account.information.service.AccountService;
import com.eureka.v1_0.kyc.information.entities.ContactInformation;
import com.eureka.v1_0.kyc.information.service.ContactInformationService;
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
@Service(value = "contactInformationServiceImpl")
public class ContactInformationServiceImpl implements ContactInformationService {

    @PersistenceContext(name = "com.eureka.v1_0.kyc-information-service-persistence-unit")
    EntityManager em;

    @Autowired
    @Qualifier(value = "accountServiceImpl")
    AccountService accountService;

    @Override
    @Transactional
    public ContactInformation createContactInformation(ContactInformation contactInformation) throws Exception {
        try {
            contactInformation.setExternalUid(RandomStringUtils.randomAlphanumeric(128));
            contactInformation.setCreationDate(Calendar.getInstance().getTime());
            this.em.persist(contactInformation);
            return contactInformation;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public List<ContactInformation> listContactInformations(String accountName) throws Exception {
        return this.em.createQuery("select c from ContactInformation c where c.account.accountName = :accountName")
                .setParameter("accountName", accountName).getResultList();
    }

    @Override
    public ContactInformation getContactInformationByUid(String contactInformationUid) throws Exception {
        List<ContactInformation> contactInformations = this.em.createQuery("select c from ContactInformation c where c.externalUid = :contactInformationUid")
                .setParameter("contactInformationUid", contactInformationUid).getResultList();
        return contactInformations != null && !contactInformations.isEmpty() ? contactInformations.get(0) : null;
    }

    @Override
    @Transactional
    public ContactInformation updateContactInformation(ContactInformation updatedContactInformation) throws Exception {
        try {
            this.em.merge(updatedContactInformation);
            return updatedContactInformation;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    @Transactional
    public Boolean deleteContactInformation(String contactInformationUid) throws Exception {
        try {
            this.em.remove(this.getContactInformationByUid(contactInformationUid));
            return Boolean.TRUE;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public List<ContactInformation> listContactInformationsByType(String accountName, Integer contactInformationType) throws Exception {
        return this.em.createQuery("select c from ContactInformation c where c.account.accountName = :accountName and c.contactInformationType = :type")
                .setParameter("accountName", accountName)
                .setParameter("type",contactInformationType)
                .getResultList();
    }

}
