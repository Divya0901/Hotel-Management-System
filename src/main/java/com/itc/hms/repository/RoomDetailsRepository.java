package com.itc.hms.repository;

import com.itc.hms.entity.RoomDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;


@Repository
public interface RoomDetailsRepository extends JpaRepository<RoomDetails, Integer> {
    List<RoomDetails> findRoomDetailsByRoomCategoryAndAndRoomPrice(String roomCategory, BigDecimal roomPrice);

    List<RoomDetails> findRoomDetailsByRoomCategory(String roomCategory);
}
