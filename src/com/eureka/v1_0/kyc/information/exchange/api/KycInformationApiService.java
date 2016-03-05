/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eureka.v1_0.kyc.information.exchange.api;

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

/**
 *
 * @author ceowit
 */
public interface KycInformationApiService {

    public CreatePersonalInformationResponse createPersonalInformation(CreatePersonalInformationRequest createPersonalInformationRequest) throws Exception;
    
    public FindPersonalInformationByAccountNameResponse findPersonalInformationByAccountName(FindPersonalInformationByAccountNameRequest findPersonalInformationByAccountNameRequest) throws Exception;
    
    public FindPersonalInformationByEmailResponse findPersonalInformationByEmail(FindPersonalInformationByEmailRequest findPersonalInformationByEmailRequest) throws Exception;
    
    public FindPersonalInformationByUidResponse findPersonalInformationByUid(FindPersonalInformationByUidRequest findPersonalInformationByUidRequest) throws Exception;
    
    public UpdatePersonalInformationResponse updatePersonalInformation(UpdatePersonalInformationRequest updatePersonalInformationRequest) throws Exception;
    
    public CreateMsisdnInformationResponse createMsisdnInformation(CreateMsisdnInformationRequest createMsisdnInformationRequest) throws Exception;
    
    public FindAccountMsisdnInformationResponse findAccountMsisdnInformation(FindAccountMsisdnInformationRequest findAccountMsisdnInformationRequest) throws Exception;
    
    public FindMsisdnInformationByUidResponse findMsisdnInformationByUid(FindMsisdnInformationByUidRequest findMsisdnInformationByUidRequest) throws Exception;
    
    public RemoveMsisdnInformationResponse removeMsisdnInformation(RemoveMsisdnInformationRequest removeMsisdnInformationRequest) throws Exception;
    
    public UpdateMsisdnInformationResponse updateMsisdnInformation(UpdateMsisdnInformationRequest updateMsisdnInformationRequest) throws Exception;
    
    public ValidateMsisdnInformationResponse validateMsisdnInformation(ValidateMsisdnInformationRequest validateMsisdnInformationRequest) throws Exception;
    
    public CreateEmailInformationResponse createEmailInformation(CreateEmailInformationRequest createEmailInformationRequest) throws Exception;

    public FindAccountEmailInformationResponse findAccountEmailInformation(FindAccountEmailInformationRequest findAccountEmailInformationRequest) throws Exception;
    
    public RemoveEmailInformationResponse removeEmailInformation(RemoveEmailInformationRequest removeEmailInformationRequest) throws Exception;
    
    public UpdateEmailInformationResponse updateEmailInformation(UpdateEmailInformationRequest updateEmailInformationRequest) throws Exception;
    
    public ValidateEmailInformationResponse validateEmailInformation(ValidateEmailInformationRequest validateEmailInformationRequest) throws Exception;
}
