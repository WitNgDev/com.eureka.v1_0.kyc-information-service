/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eureka.v1_0.kyc.information.impl;

import com.eureka.v1_0.account.information.service.AccountService;
import com.eureka.v1_0.kyc.information.entities.MsisdnInformation;
import com.eureka.v1_0.kyc.information.service.MsisdnInformationService;
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
@Service(value = "msisdnInformationServiceImpl")
public class MsisdnInformationServiceImpl implements MsisdnInformationService {

    @PersistenceContext(name = "com.eureka.v1_0.kyc-information-service-persistence-unit")
    EntityManager em;

    @Autowired
    @Qualifier(value = "accountServiceImpl")
    AccountService accountService;

    @Override
    @Transactional
    public MsisdnInformation createMsisdnInformation(MsisdnInformation msisdnInformation) throws Exception {
        if (msisdnInformation != null) {
            try {
                msisdnInformation.setAccount(this.accountService.getByName(msisdnInformation.getAccount().getAccountName()));
                msisdnInformation.setCreationDate(Calendar.getInstance().getTime());
                msisdnInformation.setExternalUid(RandomStringUtils.randomAlphanumeric(128));
                this.em.persist(msisdnInformation);
            } finally {
                if (em != null) {
                    em.close();
                }
            }
        }
        throw new NullPointerException("Msisdn Information cannot be NULL. Please send a valid object");
    }

    @Override
    public List<MsisdnInformation> findMsisdnInformations(String accountName) throws Exception {
        return this.em.createQuery("select m from MsisdnInformation m where m.account.accountName = :accountName")
                .setParameter("accountName", accountName).getResultList();
    }

    @Override
    @Transactional
    public MsisdnInformation updateMsisdnInformation(MsisdnInformation msisdnInformation) throws Exception {
        if (msisdnInformation != null) {
            try {
                this.em.persist(msisdnInformation);
                return msisdnInformation;
            } finally {
                if (em != null) {
                    em.close();
                }
            }
        }
        throw new NullPointerException("Msisdn Information cannot be NULL. Please send a valid object");
    }

    @Override
    public MsisdnInformation findMsisdnInformation(String msisdnInformationUid) throws Exception {
        List<MsisdnInformation> msisdnInformations = this.em.createQuery("select m from MsisdnInformation m where m.externalUid = :uid")
                .setParameter("uid", msisdnInformationUid).getResultList();
        return msisdnInformations != null && !msisdnInformations.isEmpty() ? msisdnInformations.get(0) : null;
    }

    @Override
    @Transactional
    public Boolean removeMsisdnInformation(String msisdnInformationUid) throws Exception {
        try {
            MsisdnInformation persistedMsisdnInformation = this.findMsisdnInformation(msisdnInformationUid);
            MsisdnInformation msisdnInformation = this.em.merge(persistedMsisdnInformation);
            this.em.remove(msisdnInformation);
            return Boolean.TRUE;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public MsisdnInformation validateMsisdnInformation(String accountName, String msisdn) throws Exception {
        List<MsisdnInformation> msisdnInformations = this.em.createQuery("select m from MsisdnInformation m where m.account.accountName = :name and m.msisdn = :msisdn")
                .setParameter("name", accountName)
                .setParameter("msisdn",msisdn)
                .getResultList();
        return msisdnInformations != null && !msisdnInformations.isEmpty() ? msisdnInformations.get(0) : null;
    }

}
