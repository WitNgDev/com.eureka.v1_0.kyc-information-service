/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eureka.v1_0.kyc.information.service;

import com.eureka.v1_0.kyc.information.entities.PersonalInformation;

/**
 *
 * @author ceowit
 */
public interface PersonalInformationService {

    public PersonalInformation createPersonalInformation(PersonalInformation personalInformation) throws Exception;

    public PersonalInformation findPersonalInformationByAccountName(String accountName) throws Exception;

    public PersonalInformation findPersonalInformationByEmailAddress(String emailAddress) throws Exception;

    public PersonalInformation findPersonalInformationByUid(String personalInformationUid) throws Exception;
    
    public PersonalInformation updatePersonalInformation(PersonalInformation persistedPersonalInformation) throws Exception;
}
