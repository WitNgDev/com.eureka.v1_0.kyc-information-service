/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eureka.v1_0.kyc.information.exchange.personalinformation;

import java.util.Date;
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
public class UpdatePersonalInformationRequest {
    
    @XmlElement(required = true)
    private String firstName;
    private String middleName;
    @XmlElement(required = true)
    private String lastName;
    private String nickName;
    private String birthName;
    private String gender;

    private String belief;
    private String occupation;
    private Date dateOfBirth;
    private String languageCode;
    private String bio;
    private String summary;
    private String favoriteQuote;

    @XmlElement(required = true)
    private String primaryEmailAddress;

    @XmlElement(required = true)
    private String accountName;
    
    @XmlElement(required = true)
    private String personalInformationUid;

    @XmlElement(required = true)
    private Long id;
    
    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the middleName
     */
    public String getMiddleName() {
        return middleName;
    }

    /**
     * @param middleName the middleName to set
     */
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the nickName
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * @param nickName the nickName to set
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    /**
     * @return the birthName
     */
    public String getBirthName() {
        return birthName;
    }

    /**
     * @param birthName the birthName to set
     */
    public void setBirthName(String birthName) {
        this.birthName = birthName;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return the belief
     */
    public String getBelief() {
        return belief;
    }

    /**
     * @param belief the belief to set
     */
    public void setBelief(String belief) {
        this.belief = belief;
    }

    /**
     * @return the occupation
     */
    public String getOccupation() {
        return occupation;
    }

    /**
     * @param occupation the occupation to set
     */
    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    /**
     * @return the dateOfBirth
     */
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * @param dateOfBirth the dateOfBirth to set
     */
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * @return the languageCode
     */
    public String getLanguageCode() {
        return languageCode;
    }

    /**
     * @param languageCode the languageCode to set
     */
    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

    /**
     * @return the bio
     */
    public String getBio() {
        return bio;
    }

    /**
     * @param bio the bio to set
     */
    public void setBio(String bio) {
        this.bio = bio;
    }

    /**
     * @return the summary
     */
    public String getSummary() {
        return summary;
    }

    /**
     * @param summary the summary to set
     */
    public void setSummary(String summary) {
        this.summary = summary;
    }

    /**
     * @return the favoriteQuote
     */
    public String getFavoriteQuote() {
        return favoriteQuote;
    }

    /**
     * @param favoriteQuote the favoriteQuote to set
     */
    public void setFavoriteQuote(String favoriteQuote) {
        this.favoriteQuote = favoriteQuote;
    }

    /**
     * @return the primaryEmailAddress
     */
    public String getPrimaryEmailAddress() {
        return primaryEmailAddress;
    }

    /**
     * @param primaryEmailAddress the primaryEmailAddress to set
     */
    public void setPrimaryEmailAddress(String primaryEmailAddress) {
        this.primaryEmailAddress = primaryEmailAddress;
    }

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

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }
    
}
