/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eureka.v1_0.kyc.information.service;

import com.eureka.v1_0.kyc.information.entities.MsisdnInformation;
import java.util.List;

/**
 *
 * @author ceowit
 */
public interface MsisdnInformationService {

    public MsisdnInformation createMsisdnInformation(MsisdnInformation msisdnInformation) throws Exception;

    public List<MsisdnInformation> findMsisdnInformations(String accountName) throws Exception;
    
    public MsisdnInformation validateMsisdnInformation(String accountName,String msisdn) throws Exception;

    public MsisdnInformation updateMsisdnInformation(MsisdnInformation msisdnInformation) throws Exception;

    public MsisdnInformation findMsisdnInformation(String msisdnInformationUid) throws Exception;

    public Boolean removeMsisdnInformation(String msisdnInformationUid) throws Exception;
}
