package com.itc.hms.repository;

import com.itc.hms.entity.RoomDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomDetailsRepository extends JpaRepository<RoomDetails, Integer> {
}
