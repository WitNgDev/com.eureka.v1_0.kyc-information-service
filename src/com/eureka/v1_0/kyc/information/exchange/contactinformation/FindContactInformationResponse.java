/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eureka.v1_0.kyc.information.exchange.contactinformation;

import com.eureka.v1_0.kyc.information.entities.ContactInformation;
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
public class FindContactInformationResponse {
    
    @XmlElement(required = true)
    private List<ContactInformation> contactInformations;

    /**
     * @return the contactInformations
     */
    public List<ContactInformation> getContactInformations() {
        return contactInformations;
    }

    /**
     * @param contactInformations the contactInformations to set
     */
    public void setContactInformations(List<ContactInformation> contactInformations) {
        this.contactInformations = contactInformations;
    }
    
}
