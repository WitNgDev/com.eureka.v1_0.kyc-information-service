/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eureka.v1_0.kyc.information.service;

import com.eureka.v1_0.kyc.information.entities.EmailInformation;
import java.util.List;

/**
 *
 * @author ceowit
 */
public interface EmailInformationService {

    public EmailInformation createEmailInformation(EmailInformation emailInformation) throws Exception;

    public List<EmailInformation> listAccountEmailInformation(String accountName) throws Exception;

    public EmailInformation validateEmailInformation(String accountName, String emailAddress) throws Exception;

    public Boolean deleteEmailInformation(String accountName, String emailAddress) throws Exception;

    public EmailInformation updateEmailInformation(EmailInformation persistedEmailInformation) throws Exception;
}
