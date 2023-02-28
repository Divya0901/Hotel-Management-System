package com.itc.hms.controller;

import com.itc.hms.dto.CustomerDetailsRequestDTO;
import com.itc.hms.dto.ResponseDTO;
import com.itc.hms.entity.CustomerDetails;
import com.itc.hms.entity.LogsDetails;
import com.itc.hms.service.CustomerDetailsService;
import com.itc.hms.service.DataValidations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CustomerDetailsController {
    private static Logger logger = LoggerFactory.getLogger(CustomerDetailsController.class);

    @Autowired
    private CustomerDetailsService customerDetailsService;

    @Autowired
    private DataValidations dataValidations;

    @PostMapping("/saveCustomerDetails")
    public ResponseEntity<ResponseDTO> saveCustomerDetails(@RequestBody CustomerDetailsRequestDTO customerDetailsRequestDTO){
        ResponseDTO responseDTO = new ResponseDTO();
        LogsDetails logsDetails;
        if((dataValidations.validateMobileNumber(customerDetailsRequestDTO.getPhoneNumber())) && (dataValidations.validateEmailId(customerDetailsRequestDTO.getEmailId()))) {
            logsDetails = customerDetailsService.saveCustomerDetails(customerDetailsRequestDTO);
            responseDTO.setStatus("Success");
            responseDTO.setStatusCode(200);
            responseDTO.setMessage("Data saved successfully");
            responseDTO.setData(logsDetails);
            return new ResponseEntity<>(responseDTO, HttpStatus.OK);
        }
        responseDTO.setStatus("Failed");
        responseDTO.setStatusCode(400);
        responseDTO.setMessage("Please provide the valid MobileNumber or EmailId");

        return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
    }


}
