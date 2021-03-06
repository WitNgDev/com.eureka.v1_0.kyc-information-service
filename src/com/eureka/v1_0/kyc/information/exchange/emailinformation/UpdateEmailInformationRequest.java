/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eureka.v1_0.kyc.information.exchange.emailinformation;

import com.eureka.v1_0.kyc.information.entities.EmailInformation;
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
public class UpdateEmailInformationRequest {
    
    @XmlElement(required = true)
    private EmailInformation persistedEmailInformation;

    /**
     * @return the persistedEmailInformation
     */
    public EmailInformation getPersistedEmailInformation() {
        return persistedEmailInformation;
    }

    /**
     * @param persistedEmailInformation the persistedEmailInformation to set
     */
    public void setPersistedEmailInformation(EmailInformation persistedEmailInformation) {
        this.persistedEmailInformation = persistedEmailInformation;
    }
    
}
