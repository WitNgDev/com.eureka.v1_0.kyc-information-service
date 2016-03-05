/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eureka.v1_0.kyc.information.exchange.impl;

import com.eureka.v1_0.account.information.exchange.GetAccountRequest;
import com.eureka.v1_0.account.information.exchange.GetAccountResponse;
import com.eureka.v1_0.account.information.exchange.api.AccountInformationApiService;
import com.eureka.v1_0.kyc.information.entities.EmailInformation;
import com.eureka.v1_0.kyc.information.entities.MsisdnInformation;
import com.eureka.v1_0.kyc.information.entities.PersonalInformation;
import com.eureka.v1_0.kyc.information.exchange.api.KycInformationApiService;
import com.eureka.v1_0.kyc.information.exchange.emailinformation.CreateEmailInformationRequest;
import com.eureka.v1_0.kyc.information.exchange.emailinformation.CreateEmailInformationResponse;
import com.eureka.v1_0.kyc.information.exchange.emailinformation.FindAccountEmailInformationRequest;
import com.eureka.v1_0.kyc.information.exchange.emailinformation.FindAccountEmailInformationResponse;
import com.eureka.v1_0.kyc.information.exchange.emailinformation.RemoveEmailInformationRequest;
import com.eureka.v1_0.kyc.information.exchange.emailinformation.RemoveEmailInformationResponse;
import com.eureka.v1_0.kyc.information.exchange.emailinformation.UpdateEmailInformationRequest;
import com.eureka.v1_0.kyc.information.exchange.emailinformation.UpdateEmailInformationResponse;
import com.eureka.v1_0.kyc.information.exchange.emailinformation.ValidateEmailInformationRequest;
import com.eureka.v1_0.kyc.information.exchange.emailinformation.ValidateEmailInformationResponse;
import com.eureka.v1_0.kyc.information.exchange.exceptions.KycInformationApiException;
import com.eureka.v1_0.kyc.information.exchange.msisdninformation.CreateMsisdnInformationRequest;
import com.eureka.v1_0.kyc.information.exchange.msisdninformation.CreateMsisdnInformationResponse;
import com.eureka.v1_0.kyc.information.exchange.msisdninformation.FindAccountMsisdnInformationRequest;
import com.eureka.v1_0.kyc.information.exchange.msisdninformation.FindAccountMsisdnInformationResponse;
import com.eureka.v1_0.kyc.information.exchange.msisdninformation.FindMsisdnInformationByUidRequest;
import com.eureka.v1_0.kyc.information.exchange.msisdninformation.FindMsisdnInformationByUidResponse;
import com.eureka.v1_0.kyc.information.exchange.msisdninformation.RemoveMsisdnInformationRequest;
import com.eureka.v1_0.kyc.information.exchange.msisdninformation.RemoveMsisdnInformationResponse;
import com.eureka.v1_0.kyc.information.exchange.msisdninformation.UpdateMsisdnInformationRequest;
import com.eureka.v1_0.kyc.information.exchange.msisdninformation.UpdateMsisdnInformationResponse;
import com.eureka.v1_0.kyc.information.exchange.msisdninformation.ValidateMsisdnInformationRequest;
import com.eureka.v1_0.kyc.information.exchange.msisdninformation.ValidateMsisdnInformationResponse;
import com.eureka.v1_0.kyc.information.exchange.personalinformation.CreatePersonalInformationRequest;
import com.eureka.v1_0.kyc.information.exchange.personalinformation.CreatePersonalInformationResponse;
import com.eureka.v1_0.kyc.information.exchange.personalinformation.FindPersonalInformationByAccountNameRequest;
import com.eureka.v1_0.kyc.information.exchange.personalinformation.FindPersonalInformationByAccountNameResponse;
import com.eureka.v1_0.kyc.information.exchange.personalinformation.FindPersonalInformationByEmailRequest;
import com.eureka.v1_0.kyc.information.exchange.personalinformation.FindPersonalInformationByEmailResponse;
import com.eureka.v1_0.kyc.information.exchange.personalinformation.FindPersonalInformationByUidRequest;
import com.eureka.v1_0.kyc.information.exchange.personalinformation.FindPersonalInformationByUidResponse;
import com.eureka.v1_0.kyc.information.exchange.personalinformation.UpdatePersonalInformationRequest;
import com.eureka.v1_0.kyc.information.exchange.personalinformation.UpdatePersonalInformationResponse;
import com.eureka.v1_0.kyc.information.service.EmailInformationService;
import com.eureka.v1_0.kyc.information.service.MsisdnInformationService;
import com.eureka.v1_0.kyc.information.service.PersonalInformationService;
import com.wit.ng.aurora.commons.jaxb.marshalling.io.JaxbHandler;
import com.wit.ng.christians.ng.ilogger.api.WitLoggerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author ceowit
 */
@Service(value = "kycInformationServiceImpl")
public class KycInformationServiceImpl implements KycInformationApiService {
    
    @Autowired
    @Qualifier(value = "personalInformationServiceImpl")
    PersonalInformationService personalInformationService;
    
    @Autowired
    @Qualifier(value = "msisdnInformationServiceImpl")
    MsisdnInformationService msisdnInformationService;
    
    @Autowired
    @Qualifier(value = "emailInformationServiceImpl")
    EmailInformationService emailInformationService;
    
    @Autowired
    @Qualifier(value = "witLoggerServiceImpl")
    WitLoggerService witLoggerService;
    
    @Autowired
    @Qualifier(value = "accountInformationApiServiceImpl")
    AccountInformationApiService accountInformationApiService;
    
    @Override
    public CreatePersonalInformationResponse createPersonalInformation(CreatePersonalInformationRequest createPersonalInformationRequest) throws Exception {
        if (createPersonalInformationRequest != null) {
            witLoggerService.debug(JaxbHandler.toXml(createPersonalInformationRequest));
            
            PersonalInformation personalInformation = new PersonalInformation();

            //find account details
            GetAccountRequest getAccountRequest = new GetAccountRequest();
            getAccountRequest.setAccountName(createPersonalInformationRequest.getAccountName());
            
            GetAccountResponse getAccountResponse = this.accountInformationApiService.getAccountDetails(getAccountRequest);
            personalInformation.setAccount(getAccountResponse.getAccount());
            
            personalInformation.setBelief(createPersonalInformationRequest.getBelief());
            personalInformation.setBio(createPersonalInformationRequest.getBio());
            personalInformation.setBirthName(createPersonalInformationRequest.getBirthName());
            personalInformation.setDateOfBirth(createPersonalInformationRequest.getDateOfBirth());
            personalInformation.setFavoriteQuote(createPersonalInformationRequest.getFavoriteQuote());
            personalInformation.setFirstName(createPersonalInformationRequest.getFirstName());
            personalInformation.setGender(createPersonalInformationRequest.getGender());
            personalInformation.setLanguageCode(createPersonalInformationRequest.getLanguageCode());
            personalInformation.setLastName(createPersonalInformationRequest.getLastName());
            personalInformation.setMiddleName(createPersonalInformationRequest.getMiddleName());
            personalInformation.setNickName(createPersonalInformationRequest.getNickName());
            personalInformation.setOccupation(createPersonalInformationRequest.getOccupation());
            personalInformation.setPrimaryEmailAddress(createPersonalInformationRequest.getPrimaryEmailAddress());
            personalInformation.setSummary(createPersonalInformationRequest.getSummary());
            
            witLoggerService.debug(JaxbHandler.toXml(personalInformation));
            witLoggerService.debug("Sending to Personal Information Service ... ");
            PersonalInformation persistedPersonalInformation = this.personalInformationService.createPersonalInformation(personalInformation);
            if (persistedPersonalInformation != null && persistedPersonalInformation.getId() > 0) {
                CreatePersonalInformationResponse createPersonalInformationResponse = new CreatePersonalInformationResponse();
                createPersonalInformationResponse.setPersonalInformation(persistedPersonalInformation);
                witLoggerService.debug(JaxbHandler.toXml(createPersonalInformationResponse));
                return createPersonalInformationResponse;
            } else {
                throw new KycInformationApiException("KYC Personal information cannot be persisted. Please try again later");
            }
        }
        throw new KycInformationApiException("KYC Personal information cannot be NULL. Please send a valid information");
    }
    
    @Override
    public FindPersonalInformationByAccountNameResponse findPersonalInformationByAccountName(FindPersonalInformationByAccountNameRequest findPersonalInformationByAccountNameRequest) throws Exception {
        if (findPersonalInformationByAccountNameRequest != null && findPersonalInformationByAccountNameRequest.getAccountName() != null) {
            PersonalInformation persistedPersonalInformation = this.personalInformationService.findPersonalInformationByAccountName(findPersonalInformationByAccountNameRequest.getAccountName());
            if (persistedPersonalInformation != null) {
                FindPersonalInformationByAccountNameResponse findPersonalInformationByAccountNameResponse = new FindPersonalInformationByAccountNameResponse();
                findPersonalInformationByAccountNameResponse.setPersonalInformation(persistedPersonalInformation);
                witLoggerService.debug(JaxbHandler.toXml(findPersonalInformationByAccountNameResponse));
                return findPersonalInformationByAccountNameResponse;
            }
            throw new KycInformationApiException("Unable to find personal information requested for. Please try again with another valid account name");
        }
        throw new KycInformationApiException("KYC Find personal information parameters cannot be NULL. Please send a valid information");
    }
    
    @Override
    public FindPersonalInformationByEmailResponse findPersonalInformationByEmail(FindPersonalInformationByEmailRequest findPersonalInformationByEmailRequest) throws Exception {
        if (findPersonalInformationByEmailRequest != null && findPersonalInformationByEmailRequest.getEmailAddress() != null) {
            PersonalInformation persistedPersonalInformation = this.personalInformationService.findPersonalInformationByEmailAddress(findPersonalInformationByEmailRequest.getEmailAddress());
            if (persistedPersonalInformation != null) {
                FindPersonalInformationByEmailResponse findPersonalInformationByEmailResponse = new FindPersonalInformationByEmailResponse();
                findPersonalInformationByEmailResponse.setPersonalInformation(persistedPersonalInformation);
                return findPersonalInformationByEmailResponse;
            }
            throw new KycInformationApiException("Unable to find personal information requested for. Please try again with another valid email address");
        }
        throw new KycInformationApiException("KYC Find personal information parameters cannot be NULL. Please send a valid object");
    }
    
    @Override
    public FindPersonalInformationByUidResponse findPersonalInformationByUid(FindPersonalInformationByUidRequest findPersonalInformationByUidRequest) throws Exception {
        if (findPersonalInformationByUidRequest != null && findPersonalInformationByUidRequest.getPersonalInformationUid() != null) {
            PersonalInformation persistedPersonalInformation = this.personalInformationService.findPersonalInformationByUid(findPersonalInformationByUidRequest.getPersonalInformationUid());
            if (persistedPersonalInformation != null) {
                FindPersonalInformationByUidResponse findPersonalInformationByUidResponse = new FindPersonalInformationByUidResponse();
                findPersonalInformationByUidResponse.setPersonalInformation(persistedPersonalInformation);
                return findPersonalInformationByUidResponse;
            } else {
                throw new KycInformationApiException("Unable to find personal information requested for. Please try again with another valid personal information uid");
            }
        }
        throw new KycInformationApiException("KYC Find personal information parameters cannot be NULL. Please send a valid object");
    }
    
    @Override
    public UpdatePersonalInformationResponse updatePersonalInformation(UpdatePersonalInformationRequest updatePersonalInformationRequest) throws Exception {
        if (updatePersonalInformationRequest != null) {
            witLoggerService.debug(JaxbHandler.toXml(updatePersonalInformationRequest));
            PersonalInformation personalInformation = new PersonalInformation();

            //find account details
            GetAccountRequest getAccountRequest = new GetAccountRequest();
            getAccountRequest.setAccountName(updatePersonalInformationRequest.getAccountName());
            
            GetAccountResponse getAccountResponse = this.accountInformationApiService.getAccountDetails(getAccountRequest);
            personalInformation.setAccount(getAccountResponse.getAccount());
            
            personalInformation.setBelief(updatePersonalInformationRequest.getBelief());
            personalInformation.setBio(updatePersonalInformationRequest.getBio());
            personalInformation.setBirthName(updatePersonalInformationRequest.getBirthName());
            personalInformation.setDateOfBirth(updatePersonalInformationRequest.getDateOfBirth());
            personalInformation.setFavoriteQuote(updatePersonalInformationRequest.getFavoriteQuote());
            personalInformation.setFirstName(updatePersonalInformationRequest.getFirstName());
            personalInformation.setGender(updatePersonalInformationRequest.getGender());
            personalInformation.setLanguageCode(updatePersonalInformationRequest.getLanguageCode());
            personalInformation.setLastName(updatePersonalInformationRequest.getLastName());
            personalInformation.setMiddleName(updatePersonalInformationRequest.getMiddleName());
            personalInformation.setNickName(updatePersonalInformationRequest.getNickName());
            personalInformation.setOccupation(updatePersonalInformationRequest.getOccupation());
            personalInformation.setPrimaryEmailAddress(updatePersonalInformationRequest.getPrimaryEmailAddress());
            personalInformation.setSummary(updatePersonalInformationRequest.getSummary());
            
            personalInformation.setId(updatePersonalInformationRequest.getId());
            personalInformation.setExternalUid(updatePersonalInformationRequest.getPersonalInformationUid());
            
            witLoggerService.debug(JaxbHandler.toXml(personalInformation));
            witLoggerService.debug("Sending to Personal Information Service ... ");
            PersonalInformation persistedPersonalInformation = this.personalInformationService.updatePersonalInformation(personalInformation);
            if (persistedPersonalInformation != null) {
                UpdatePersonalInformationResponse updatePersonalInformationResponse = new UpdatePersonalInformationResponse();
                updatePersonalInformationResponse.setUpdatedInformation(persistedPersonalInformation);
                witLoggerService.debug(JaxbHandler.toXml(updatePersonalInformationResponse));
                return updatePersonalInformationResponse;
            } else {
                throw new KycInformationApiException("Unable to update personal information requested for. Please try again later");
            }
        }
        throw new KycInformationApiException("KYC Update personal information parameters cannot be NULL. Please send a valid object");
    }
    
    @Override
    public CreateMsisdnInformationResponse createMsisdnInformation(CreateMsisdnInformationRequest createMsisdnInformationRequest) throws Exception {
        if (createMsisdnInformationRequest != null) {
            witLoggerService.debug(JaxbHandler.toXml(createMsisdnInformationRequest));
            
            MsisdnInformation msisdnInformation = new MsisdnInformation();

            //find account details
            GetAccountRequest getAccountRequest = new GetAccountRequest();
            getAccountRequest.setAccountName(createMsisdnInformationRequest.getAccountName());
            
            GetAccountResponse getAccountResponse = this.accountInformationApiService.getAccountDetails(getAccountRequest);
            msisdnInformation.setAccount(getAccountResponse.getAccount());
            
            MsisdnInformation persistedMsisdnInformation = this.msisdnInformationService.createMsisdnInformation(msisdnInformation);
            if (persistedMsisdnInformation != null) {
                CreateMsisdnInformationResponse createMsisdnInformationResponse = new CreateMsisdnInformationResponse();
                createMsisdnInformationResponse.setMsisdnInformation(persistedMsisdnInformation);
                witLoggerService.debug(JaxbHandler.toXml(createMsisdnInformationResponse));
                return createMsisdnInformationResponse;
            } else {
                throw new KycInformationApiException("KYC create msisdn information failed . Please send a valid object");
            }
        }
        throw new KycInformationApiException("KYC Update msisdn information parameters cannot be NULL. Please send a valid object");
    }
    
    @Override
    public FindAccountMsisdnInformationResponse findAccountMsisdnInformation(FindAccountMsisdnInformationRequest findAccountMsisdnInformationRequest) throws Exception {
        if (findAccountMsisdnInformationRequest != null) {
            witLoggerService.debug(JaxbHandler.toXml(findAccountMsisdnInformationRequest));
            List<MsisdnInformation> msisdnInformations = this.msisdnInformationService.findMsisdnInformations(findAccountMsisdnInformationRequest.getAccountName());
            if (msisdnInformations != null && !msisdnInformations.isEmpty()) {
                FindAccountMsisdnInformationResponse findAccountMsisdnInformationResponse = new FindAccountMsisdnInformationResponse();
                findAccountMsisdnInformationResponse.setMsisdnInformation(msisdnInformations);
                witLoggerService.debug(JaxbHandler.toXml(findAccountMsisdnInformationResponse));
                return findAccountMsisdnInformationResponse;
            } else {
                throw new KycInformationApiException("KYC find account msisdn information failed. Please try again later.");
            }
        }
        throw new KycInformationApiException("KYC Find account msisdn information cannot be NULL. Please send another valid object. ");
    }
    
    @Override
    public FindMsisdnInformationByUidResponse findMsisdnInformationByUid(FindMsisdnInformationByUidRequest findMsisdnInformationByUidRequest) throws Exception {
        if (findMsisdnInformationByUidRequest != null && findMsisdnInformationByUidRequest.getMsisdnInformationUid() != null) {
            witLoggerService.debug(JaxbHandler.toXml(findMsisdnInformationByUidRequest));
            MsisdnInformation persistedMsisdnInformation = this.msisdnInformationService.findMsisdnInformation(findMsisdnInformationByUidRequest.getMsisdnInformationUid());
            if (persistedMsisdnInformation != null) {
                FindMsisdnInformationByUidResponse findMsisdnInformationByUidResponse = new FindMsisdnInformationByUidResponse();
                findMsisdnInformationByUidResponse.setMsisdnInformation(persistedMsisdnInformation);
                witLoggerService.debug(JaxbHandler.toXml(findMsisdnInformationByUidResponse));
                return findMsisdnInformationByUidResponse;
            } else {
                throw new KycInformationApiException("KYC find msisdn information failed. Please try again later.");
            }
        }
        throw new KycInformationApiException("KYC Find account msisdn information cannot be NULL. Please send another valid object.");
    }
    
    @Override
    public RemoveMsisdnInformationResponse removeMsisdnInformation(RemoveMsisdnInformationRequest removeMsisdnInformationRequest) throws Exception {
        if (removeMsisdnInformationRequest != null && removeMsisdnInformationRequest.getMsisdnInformationUid() != null) {
            witLoggerService.debug(JaxbHandler.toXml(removeMsisdnInformationRequest));
            if (this.msisdnInformationService.removeMsisdnInformation(removeMsisdnInformationRequest.getMsisdnInformationUid())) {
                RemoveMsisdnInformationResponse removeMsisdnInformationResponse = new RemoveMsisdnInformationResponse();
                removeMsisdnInformationResponse.setStatus(Boolean.TRUE);
                witLoggerService.debug(JaxbHandler.toXml(removeMsisdnInformationResponse));
                return removeMsisdnInformationResponse;
            } else {
                throw new KycInformationApiException("KYC remove msisdn information failed. Please try again later.");
            }
        }
        throw new KycInformationApiException("KYC Remove msisdn information cannot be NULL. Please send another valid object.");
    }
    
    @Override
    public UpdateMsisdnInformationResponse updateMsisdnInformation(UpdateMsisdnInformationRequest updateMsisdnInformationRequest) throws Exception {
        if (updateMsisdnInformationRequest != null) {
            witLoggerService.debug(JaxbHandler.toXml(updateMsisdnInformationRequest));
            MsisdnInformation persistedMsisdnInformation = this.msisdnInformationService.updateMsisdnInformation(updateMsisdnInformationRequest.getMsisdnInformation());
            if (persistedMsisdnInformation != null) {
                UpdateMsisdnInformationResponse updateMsisdnInformationResponse = new UpdateMsisdnInformationResponse();
                updateMsisdnInformationResponse.setUpdatedMsisdnInformation(persistedMsisdnInformation);
                witLoggerService.debug(JaxbHandler.toXml(updateMsisdnInformationResponse));
                return updateMsisdnInformationResponse;
            } else {
                throw new KycInformationApiException("KYC update msisdn information failed. Please try again later.");
            }
        }
        throw new KycInformationApiException("KYC update msisdn information cannot be NULL. Please send another valid object.");
    }
    
    @Override
    public ValidateMsisdnInformationResponse validateMsisdnInformation(ValidateMsisdnInformationRequest validateMsisdnInformationRequest) throws Exception {
        if (validateMsisdnInformationRequest != null && validateMsisdnInformationRequest.getAccountName() != null && validateMsisdnInformationRequest.getMsisdn() != null) {
            witLoggerService.debug(JaxbHandler.toXml(validateMsisdnInformationRequest));
            MsisdnInformation msisdnInformation = this.msisdnInformationService.validateMsisdnInformation(validateMsisdnInformationRequest.getAccountName(), validateMsisdnInformationRequest.getMsisdn());
            if (msisdnInformation != null) {
                ValidateMsisdnInformationResponse validateMsisdnInformationResponse = new ValidateMsisdnInformationResponse();
                validateMsisdnInformationResponse.setMsisdnInformation(msisdnInformation);
                witLoggerService.debug(JaxbHandler.toXml(validateMsisdnInformationResponse));
                return validateMsisdnInformationResponse;
            } else {
                throw new KycInformationApiException("KYC validate msisdn information failed. Please try again later.");
            }
        }
        throw new KycInformationApiException("KYC validate msisdn information cannot be NULL. Please send another valid object.");
    }
    
    @Override
    public CreateEmailInformationResponse createEmailInformation(CreateEmailInformationRequest createEmailInformationRequest) throws Exception {
        if (createEmailInformationRequest != null) {
            witLoggerService.debug(JaxbHandler.toXml(createEmailInformationRequest));
            EmailInformation emailInformation = new EmailInformation();

            //find account details
            GetAccountRequest getAccountRequest = new GetAccountRequest();
            getAccountRequest.setAccountName(createEmailInformationRequest.getAccountName());
            
            GetAccountResponse getAccountResponse = this.accountInformationApiService.getAccountDetails(getAccountRequest);
            emailInformation.setAccount(getAccountResponse.getAccount());
            
            EmailInformation persistedEmailInformation = this.emailInformationService.createEmailInformation(emailInformation);
            if (persistedEmailInformation != null) {
                CreateEmailInformationResponse createEmailInformationResponse = new CreateEmailInformationResponse();
                createEmailInformationResponse.setEmailInformation(persistedEmailInformation);
                witLoggerService.debug(JaxbHandler.toXml(createEmailInformationResponse));
                return createEmailInformationResponse;
            } else {
                throw new KycInformationApiException("KYC create email information failed. Please try again later.");
            }
        }
        throw new KycInformationApiException("KYC create email information cannot be NULL. Please send another valid object.");
    }
    
    @Override
    public FindAccountEmailInformationResponse findAccountEmailInformation(FindAccountEmailInformationRequest findAccountEmailInformationRequest) throws Exception {
        if (findAccountEmailInformationRequest != null && findAccountEmailInformationRequest.getAccountName() != null) {
            witLoggerService.debug(JaxbHandler.toXml(findAccountEmailInformationRequest));
            List<EmailInformation> emailInformations = this.emailInformationService.listAccountEmailInformation(findAccountEmailInformationRequest.getAccountName());
            if (emailInformations != null && !emailInformations.isEmpty()) {
                FindAccountEmailInformationResponse findAccountEmailInformationResponse = new FindAccountEmailInformationResponse();
                findAccountEmailInformationResponse.setEmailInformations(emailInformations);
                witLoggerService.debug(JaxbHandler.toXml(findAccountEmailInformationResponse));
                return findAccountEmailInformationResponse;
            } else {
                throw new KycInformationApiException("KYC find email information failed. Please try again later.");
            }
        }
        throw new KycInformationApiException("KYC find email information cannot be NULL. Please send another valid object.");
    }
    
    @Override
    public RemoveEmailInformationResponse removeEmailInformation(RemoveEmailInformationRequest removeEmailInformationRequest) throws Exception {
        if (removeEmailInformationRequest != null && removeEmailInformationRequest.getAccountName() != null && removeEmailInformationRequest.getEmailAddress() != null) {
            witLoggerService.debug(JaxbHandler.toXml(removeEmailInformationRequest));
            if (this.emailInformationService.deleteEmailInformation(removeEmailInformationRequest.getAccountName(), removeEmailInformationRequest.getEmailAddress())) {
                RemoveEmailInformationResponse removeEmailInformationResponse = new RemoveEmailInformationResponse();
                removeEmailInformationResponse.setStatus(Boolean.TRUE);
                witLoggerService.debug(JaxbHandler.toXml(removeEmailInformationResponse));
                return removeEmailInformationResponse;
            } else {
                throw new KycInformationApiException("KYC remove email information failed. Please try again later.");
            }
        }
        throw new KycInformationApiException("KYC remove email information cannot be NULL. Please send another valid object.");
    }
    
    @Override
    public UpdateEmailInformationResponse updateEmailInformation(UpdateEmailInformationRequest updateEmailInformationRequest) throws Exception {
        if (updateEmailInformationRequest != null) {
            witLoggerService.debug(JaxbHandler.toXml(updateEmailInformationRequest));
            EmailInformation persistedEmailInformation = this.emailInformationService.updateEmailInformation(updateEmailInformationRequest.getPersistedEmailInformation());
            if (persistedEmailInformation != null) {
                UpdateEmailInformationResponse updateEmailInformationResponse = new UpdateEmailInformationResponse();
                updateEmailInformationResponse.setStatus(Boolean.TRUE);
                witLoggerService.debug(JaxbHandler.toXml(updateEmailInformationResponse));
                return updateEmailInformationResponse;
            } else {
                throw new KycInformationApiException("KYC update email information failed. Please try again later.");
            }
        }
        throw new KycInformationApiException("KYC update email information cannot be NULL. Please send another valid object.");
    }
    
    @Override
    public ValidateEmailInformationResponse validateEmailInformation(ValidateEmailInformationRequest validateEmailInformationRequest) throws Exception {
        if (validateEmailInformationRequest != null) {
            witLoggerService.debug(JaxbHandler.toXml(validateEmailInformationRequest));
            EmailInformation persistedEmailInformation = this.emailInformationService.validateEmailInformation(validateEmailInformationRequest.getAccountName(), validateEmailInformationRequest.getEmailAddress());
            if (persistedEmailInformation != null) {
                ValidateEmailInformationResponse validateEmailInformationResponse = new ValidateEmailInformationResponse();
                validateEmailInformationResponse.setEmailInformation(persistedEmailInformation);
                witLoggerService.debug(JaxbHandler.toXml(validateEmailInformationResponse));
                return validateEmailInformationResponse;
            }else{
                throw new KycInformationApiException("KYC validate email information failed. Please try again later.");
            }
        }
        throw new KycInformationApiException("KYC validate email information cannot be NULL. Please send another valid object.");
    }
    
}
