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
public class RemoveContactInformationRequest {
    
    @XmlElement(required = true)
    private String contactInformationUid;

    /**
     * @return the contactInformationUid
     */
    public String getContactInformationUid() {
        return contactInformationUid;
    }

    /**
     * @param contactInformationUid the contactInformationUid to set
     */
    public void setContactInformationUid(String contactInformationUid) {
        this.contactInformationUid = contactInformationUid;
    }
    
}
