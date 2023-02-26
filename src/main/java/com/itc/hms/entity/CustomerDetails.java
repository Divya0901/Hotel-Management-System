package com.itc.hms.entity;

import jakarta.persistence.*;

@Entity
@Table
public class CustomerDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer customerId;
    private String fullName;
    private Long phoneNumber;
    private String emailId;
    private String personalIdentityCard;
    private String personalIdentityCardNumber;
    private String address;
    private Integer familyMemberCount;

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPersonalIdentityCard() {
        return personalIdentityCard;
    }

    public void setPersonalIdentityCard(String personalIdentityCard) {
        this.personalIdentityCard = personalIdentityCard;
    }

    public String getPersonalIdentityCardNumber() {
        return personalIdentityCardNumber;
    }

    public void setPersonalIdentityCardNumber(String personalIdentityCardNumber) {
        this.personalIdentityCardNumber = personalIdentityCardNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getFamilyMemberCount() {
        return familyMemberCount;
    }

    public void setFamilyMemberCount(Integer familyMemberCount) {
        this.familyMemberCount = familyMemberCount;
    }
}
