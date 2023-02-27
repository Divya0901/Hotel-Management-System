package com.itc.hms.controller;

import com.itc.hms.dto.ResponseDTO;
import com.itc.hms.entity.EmployeeDetails;
import com.itc.hms.service.DataValidations;
import com.itc.hms.service.EmployeeDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class EmployeeDetailsController {
    private static Logger logger = LoggerFactory.getLogger(EmployeeDetailsController.class);

    @Autowired
    private EmployeeDetailsService employeeDetailsService;
    @Autowired
    DataValidations dataValidations;

    @PostMapping("/saveEmployeeDetails")
    public ResponseEntity<ResponseDTO> saveEmployeeDetails(@RequestBody EmployeeDetails employeeDetails){
        ResponseDTO responseDTO = new ResponseDTO();
        if((dataValidations.validateMobileNumber(employeeDetails.getEmpMobileNumber())) && (dataValidations.validateEmailId(employeeDetails.getEmpEmailId()))) {
            employeeDetails = employeeDetailsService.saveEmployeeDetails(employeeDetails);
            responseDTO.setStatus("Success");
            responseDTO.setStatusCode(200);
            responseDTO.setMessage("Data saved successfully");
            responseDTO.setData(employeeDetails);
        }
        responseDTO.setStatus("Failed");
        responseDTO.setStatusCode(400);
        responseDTO.setMessage("Please provide the valid MobileNumber and EmailId");

        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/getEmployeeDetails")
    public ResponseEntity<ResponseDTO> getEmployeeDetails(@RequestBody Map<String, Long> request){
        ResponseDTO responseDTO = new ResponseDTO();
        EmployeeDetails employeeDetails;
        employeeDetails = employeeDetailsService.getEmployeeDetails(request.get("mobileNumber"), request.get("aadharNumber"));
        responseDTO.setStatus("Success");
        responseDTO.setStatusCode(200);
        responseDTO.setMessage("Data fetched successfully");
        responseDTO.setData(employeeDetails);

        return  new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
