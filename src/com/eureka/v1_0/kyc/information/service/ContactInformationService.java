/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eureka.v1_0.kyc.information.service;

import com.eureka.v1_0.kyc.information.entities.ContactInformation;
import java.util.List;

/**
 *
 * @author ceowit
 */
public interface ContactInformationService {
    
    public ContactInformation createContactInformation(ContactInformation contactInformation) throws Exception;
    
    public List<ContactInformation> listContactInformations(String accountName) throws Exception;
    
    public List<ContactInformation> listContactInformationsByType(String accountName,Integer contactInformationType) throws Exception;
    
    public ContactInformation getContactInformationByUid(String contactInformationUid) throws Exception;
    
    public ContactInformation updateContactInformation(ContactInformation updatedContactInformation) throws Exception;
    
    public Boolean deleteContactInformation(String contactInformationUid)throws Exception;
}
