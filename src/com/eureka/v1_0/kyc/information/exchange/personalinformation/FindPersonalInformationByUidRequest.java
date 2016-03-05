/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eureka.v1_0.kyc.information.exchange.personalinformation;

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
public class FindPersonalInformationByUidRequest {
    
    @XmlElement(required = true)
    private String personalInformationUid;

    /**
     * @return the personalInformationUid
     */
    public String getPersonalInformationUid() {
        return personalInformationUid;
    }

    /**
     * @param personalInformationUid the personalInformationUid to set
     */
    public void setPersonalInformationUid(String personalInformationUid) {
        this.personalInformationUid = personalInformationUid;
    }
    
}
