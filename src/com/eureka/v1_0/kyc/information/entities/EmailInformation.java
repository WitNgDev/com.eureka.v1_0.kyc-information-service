/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eureka.v1_0.kyc.information.entities;

import com.eureka.v1_0.account.information.entities.Account;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ceowit
 */
@Entity
@Table(catalog = "donations_ng",schema = "_donations_ng_kyc_info_module",name = "_donations_ng_email_info")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class EmailInformation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String emailAddress;
    private boolean primaryState;
    
    @Column(nullable = false,unique = true)
    private String externalUid;

    @ManyToOne
    @JoinColumn(referencedColumnName = "externalUid")    
    private Account account;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getId() != null ? getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmailInformation)) {
            return false;
        }
        EmailInformation other = (EmailInformation) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "com.eureka.v1_0.kyc.information.entities.EmailInformation[ id=" + getId() + " ]";
    }

    /**
     * @return the emailAddress
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * @param emailAddress the emailAddress to set
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /**
     * @return the primaryState
     */
    public boolean isPrimaryState() {
        return primaryState;
    }

    /**
     * @param primaryState the primaryState to set
     */
    public void setPrimaryState(boolean primaryState) {
        this.primaryState = primaryState;
    }

    /**
     * @return the externalUid
     */
    public String getExternalUid() {
        return externalUid;
    }

    /**
     * @param externalUid the externalUid to set
     */
    public void setExternalUid(String externalUid) {
        this.externalUid = externalUid;
    }

    /**
     * @return the account
     */
    public Account getAccount() {
        return account;
    }

    /**
     * @param account the account to set
     */
    public void setAccount(Account account) {
        this.account = account;
    }

    /**
     * @return the creationDate
     */
    public Date getCreationDate() {
        return creationDate;
    }

    /**
     * @param creationDate the creationDate to set
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
    
}
