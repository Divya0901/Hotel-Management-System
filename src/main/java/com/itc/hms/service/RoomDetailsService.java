package com.itc.hms.service;

import com.itc.hms.dto.ResponseDTO;
import com.itc.hms.entity.RoomDetails;
import com.itc.hms.repository.RoomDetailsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomDetailsService {
    private static Logger logger = LoggerFactory.getLogger(RoomDetailsService.class);

    @Autowired
    RoomDetailsRepository roomDetailsRepository;

    public RoomDetails saveRoomDetails(RoomDetails roomDetails){
        return roomDetailsRepository.save(roomDetails);
    }

    public RoomDetails getRoomDetails(String category){
        RoomDetails roomDetails;
        roomDetails = roomDetailsRepository.findRoomDetailsByRoomCategory(category);
        return roomDetails;
    }
}
