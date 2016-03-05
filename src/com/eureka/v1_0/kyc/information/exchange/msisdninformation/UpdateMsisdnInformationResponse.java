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
public class UpdateMsisdnInformationResponse {
    
    @XmlElement(required = true)
    private MsisdnInformation updatedMsisdnInformation;

    /**
     * @return the updatedMsisdnInformation
     */
    public MsisdnInformation getUpdatedMsisdnInformation() {
        return updatedMsisdnInformation;
    }

    /**
     * @param updatedMsisdnInformation the updatedMsisdnInformation to set
     */
    public void setUpdatedMsisdnInformation(MsisdnInformation updatedMsisdnInformation) {
        this.updatedMsisdnInformation = updatedMsisdnInformation;
    }
    
}
