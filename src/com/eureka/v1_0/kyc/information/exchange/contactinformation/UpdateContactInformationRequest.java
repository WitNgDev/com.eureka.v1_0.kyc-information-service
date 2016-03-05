/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eureka.v1_0.kyc.information.exchange.contactinformation;

import com.eureka.v1_0.kyc.information.entities.ContactInformation;
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
public class UpdateContactInformationRequest {
    
    @XmlElement(required = true)
    private ContactInformation updatedContactInformation;

    /**
     * @return the updatedContactInformation
     */
    public ContactInformation getUpdatedContactInformation() {
        return updatedContactInformation;
    }

    /**
     * @param updatedContactInformation the updatedContactInformation to set
     */
    public void setUpdatedContactInformation(ContactInformation updatedContactInformation) {
        this.updatedContactInformation = updatedContactInformation;
    }
    
}
