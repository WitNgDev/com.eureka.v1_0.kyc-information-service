/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eureka.v1_0.kyc.information.exchange.msisdninformation;

import com.eureka.v1_0.kyc.information.entities.MsisdnInformation;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ceowit
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class CreateMsisdnInformationResponse {
    
    @XmlElement(required = true)
    private MsisdnInformation msisdnInformation;

    /**
     * @return the msisdnInformation
     */
    public MsisdnInformation getMsisdnInformation() {
        return msisdnInformation;
    }

    /**
     * @param msisdnInformation the msisdnInformation to set
     */
    public void setMsisdnInformation(MsisdnInformation msisdnInformation) {
        this.msisdnInformation = msisdnInformation;
    }
    
}
