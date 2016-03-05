/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eureka.v1_0.kyc.information.exchange.emailinformation;

import com.eureka.v1_0.kyc.information.entities.EmailInformation;
import java.util.List;
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
public class FindAccountEmailInformationResponse {
    
    @XmlElement(required = true)
    private List<EmailInformation> emailInformations;

    /**
     * @return the emailInformations
     */
    public List<EmailInformation> getEmailInformations() {
        return emailInformations;
    }

    /**
     * @param emailInformations the emailInformations to set
     */
    public void setEmailInformations(List<EmailInformation> emailInformations) {
        this.emailInformations = emailInformations;
    }
    
}
