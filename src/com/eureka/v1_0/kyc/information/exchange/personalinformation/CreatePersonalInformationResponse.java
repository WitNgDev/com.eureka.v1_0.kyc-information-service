/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eureka.v1_0.kyc.information.exchange.personalinformation;

import com.eureka.v1_0.kyc.information.entities.PersonalInformation;
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
public class CreatePersonalInformationResponse {
    
    @XmlElement(required = true)
    private PersonalInformation personalInformation;

    /**
     * @return the personalInformation
     */
    public PersonalInformation getPersonalInformation() {
        return personalInformation;
    }

    /**
     * @param personalInformation the personalInformation to set
     */
    public void setPersonalInformation(PersonalInformation personalInformation) {
        this.personalInformation = personalInformation;
    }
    
}
