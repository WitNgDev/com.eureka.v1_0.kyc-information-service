/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eureka.v1_0.kyc.information.impl;

import com.eureka.v1_0.kyc.information.entities.PersonalInformation;
import com.eureka.v1_0.kyc.information.service.PersonalInformationService;
import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ceowit
 */
@Service(value = "personalInformationServiceImpl")
public class PersonalInformationServiceImpl implements PersonalInformationService {

    @PersistenceContext(name = "com.eureka.v1_0.kyc-information-service-persistence-unit")
    EntityManager em;

//    @Autowired
//    @Qualifier(value = "accountServiceImpl")
//    AccountService accountService;

    @Override
    @Transactional
    public PersonalInformation createPersonalInformation(PersonalInformation personalInformation) throws Exception {
        if (personalInformation != null) {
            try {
                //personalInformation.setAccount(this.accountService.getByName(personalInformation.getAccount().getAccountName()));
                personalInformation.setCreationDate(Calendar.getInstance().getTime());
                personalInformation.setExternalUid(RandomStringUtils.randomAlphanumeric(128));
                this.em.persist(personalInformation);
                return personalInformation;
            } finally {
                if (em != null) {
                    em.close();
                }
            }
        }
        throw new NullPointerException("PersonInformation cannot be NULL to be persisted. Please send a valid object");
    }

    @Override
    public PersonalInformation findPersonalInformationByAccountName(String accountName) throws Exception {
        List<PersonalInformation> personalInformations = this.em.createQuery("select p from PersonalInformation p where p.account.accountName = :accountName")
                .setParameter("accountName", accountName).getResultList();
        return personalInformations != null && !personalInformations.isEmpty() ? personalInformations.get(0) : null;
    }

    @Override
    public PersonalInformation findPersonalInformationByEmailAddress(String emailAddress) throws Exception {
        List<PersonalInformation> personalInformations = this.em.createQuery("select p from PersonalInformation p where p.primaryEmailAddress = :email")
                .setParameter("email", emailAddress).getResultList();
        return personalInformations != null && !personalInformations.isEmpty() ? personalInformations.get(0) : null;
    }

    @Override
    public PersonalInformation findPersonalInformationByUid(String personalInformationUid) throws Exception {
        List<PersonalInformation> personalInformations = this.em.createQuery("select p from PersonalInformation p where p.externalUid = :uid")
                .setParameter("uid", personalInformationUid).getResultList();
        return personalInformations != null && !personalInformations.isEmpty() ? personalInformations.get(0) : null;
    }

    @Override
    @Transactional
    public PersonalInformation updatePersonalInformation(PersonalInformation persistedPersonalInformation) throws Exception {
        if (persistedPersonalInformation != null) {
            try {
                this.em.merge(persistedPersonalInformation);
                return persistedPersonalInformation;
            } finally {
                if (em != null) {
                    em.close();
                }
            }
        }
        throw new NullPointerException("PersonInformation cannot be NULL to be merged. Please send a valid object");
    }

}
