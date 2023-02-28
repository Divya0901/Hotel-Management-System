package com.itc.hms.controller;

import com.itc.hms.dto.ResponseDTO;
import com.itc.hms.entity.RoomDetails;
import com.itc.hms.service.RoomDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoomDetailsController {
    private static Logger logger = LoggerFactory.getLogger(RoomDetailsController.class);

    @Autowired
    RoomDetailsService roomDetailsService;

    @PostMapping("/saveRoomDetails")
    public ResponseEntity<ResponseDTO> saveRoomDetails(@RequestBody RoomDetails roomDetails){
        ResponseDTO responseDTO = new ResponseDTO();
        roomDetails = roomDetailsService.saveRoomDetails(roomDetails);
        responseDTO.setStatus("Success");
        responseDTO.setStatusCode(200);
        responseDTO.setMessage("Data saved successfully");
        responseDTO.setData(roomDetails);
     return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }


    @GetMapping("/getRoomDetails/{category}")
    public ResponseEntity<ResponseDTO> getRoomDetails(@PathVariable String category){
        ResponseDTO responseDTO = new ResponseDTO();
        List<RoomDetails> roomDetails;
        roomDetails = roomDetailsService.getRoomDetails(category);
        responseDTO.setStatus("Success");
        responseDTO.setStatusCode(200);
        responseDTO.setMessage("Data fetched successfully");
        responseDTO.setData(roomDetails);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
