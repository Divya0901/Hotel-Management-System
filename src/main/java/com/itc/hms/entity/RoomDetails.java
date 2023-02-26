package com.itc.hms.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table
public class RoomDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer roomNumber;
    private String roomCategory;
    private BigDecimal roomPrice;

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomCategory() {
        return roomCategory;
    }

    public void setRoomCategory(String roomCategory) {
        this.roomCategory = roomCategory;
    }

    public BigDecimal getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(BigDecimal roomPrice) {
        this.roomPrice = roomPrice;
    }
}
