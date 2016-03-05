/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eureka.v1_0.kyc.information.exchange.msisdninformation;

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
public class RemoveMsisdnInformationRequest {
    
    @XmlElement(required = true)
    private String msisdnInformationUid;

    /**
     * @return the msisdnInformationUid
     */
    public String getMsisdnInformationUid() {
        return msisdnInformationUid;
    }

    /**
     * @param msisdnInformationUid the msisdnInformationUid to set
     */
    public void setMsisdnInformationUid(String msisdnInformationUid) {
        this.msisdnInformationUid = msisdnInformationUid;
    }
    
}
