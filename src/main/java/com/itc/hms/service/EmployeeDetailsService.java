package com.itc.hms.service;

import com.itc.hms.entity.EmployeeDetails;
import com.itc.hms.repository.EmployeeDetailsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeDetailsService {
    private static Logger logger = LoggerFactory.getLogger(EmployeeDetailsService.class);

    @Autowired
    private EmployeeDetailsRepository employeeDetailsRepository;

    public EmployeeDetails saveEmployeeDetails(EmployeeDetails employeeDetails){
        employeeDetails = employeeDetailsRepository.save(employeeDetails);
        return employeeDetails;
    }

    public EmployeeDetails getEmployeeDetails(Long mobileNumber, Long aadharNumber){
        EmployeeDetails employeeDetails;
        employeeDetails = employeeDetailsRepository.findEmployeeDetailsByEmpMobileNumberAndEmpAadharCardNumber(mobileNumber, aadharNumber);
        return employeeDetails;
    }
}
