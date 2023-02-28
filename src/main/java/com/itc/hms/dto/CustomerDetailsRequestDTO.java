package com.itc.hms.dto;

import java.math.BigDecimal;
import java.util.Date;

public class CustomerDetailsRequestDTO {
    private String fullName;
    private Long phoneNumber;
    private String emailId;
    private String personalIdentityCard;
    private Long personalIdentityCardNumber;
    private String address;
    private Integer familyMemberCount;
    private String  roomCategory;
    private Date checkOutDate;
    private BigDecimal paidAmount;

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

    public Long getPersonalIdentityCardNumber() {
        return personalIdentityCardNumber;
    }

    public void setPersonalIdentityCardNumber(Long personalIdentityCardNumber) {
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

    public String getRoomCategory() {
        return roomCategory;
    }

    public void setRoomCategory(String roomCategory) {
        this.roomCategory = roomCategory;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public BigDecimal getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(BigDecimal paidAmount) {
        this.paidAmount = paidAmount;
    }
}
