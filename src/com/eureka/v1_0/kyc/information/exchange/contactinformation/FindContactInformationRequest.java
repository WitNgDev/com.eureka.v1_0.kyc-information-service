/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eureka.v1_0.kyc.information.exchange.contactinformation;

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
public class FindContactInformationRequest {
    
    @XmlElement(required = true)
    private String accountName;
    
    private Integer contactInformationType;

    /**
     * @return the accountName
     */
    public String getAccountName() {
        return accountName;
    }

    /**
     * @param accountName the accountName to set
     */
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    /**
     * @return the contactInformationType
     */
    public Integer getContactInformationType() {
        return contactInformationType;
    }

    /**
     * @param contactInformationType the contactInformationType to set
     */
    public void setContactInformationType(Integer contactInformationType) {
        this.contactInformationType = contactInformationType;
    }
    
}
