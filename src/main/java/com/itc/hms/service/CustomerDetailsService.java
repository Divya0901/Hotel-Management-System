package com.itc.hms.service;

import com.itc.hms.dto.CustomerDetailsRequestDTO;
import com.itc.hms.entity.CustomerDetails;
import com.itc.hms.entity.EmployeeDetails;
import com.itc.hms.entity.LogsDetails;
import com.itc.hms.entity.RoomDetails;
import com.itc.hms.repository.CustomerDetailsRepository;
import com.itc.hms.repository.EmployeeDetailsRepository;
import com.itc.hms.repository.LogsDetailsRepository;
import com.itc.hms.repository.RoomDetailsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CustomerDetailsService {
    private static Logger logger = LoggerFactory.getLogger(CustomerDetailsService.class);

    @Autowired
    private CustomerDetailsRepository customerDetailsRepository;

    @Autowired
    private RoomDetailsRepository roomDetailsRepository;

    @Autowired
    private LogsDetailsRepository logsDetailsRepository;

    @Autowired
    private EmployeeDetailsRepository employeeDetailsRepository;

    public LogsDetails saveCustomerDetails(CustomerDetailsRequestDTO customerDetailsRequestDTO){
       LogsDetails logsDetails = new LogsDetails();
       CustomerDetails customerDetails = new CustomerDetails();

        customerDetails.setFullName(customerDetailsRequestDTO.getFullName());
        customerDetails.setPhoneNumber(customerDetailsRequestDTO.getPhoneNumber());
        customerDetails.setAddress(customerDetailsRequestDTO.getAddress());
        customerDetails.setFamilyMemberCount(customerDetailsRequestDTO.getFamilyMemberCount());
        customerDetails.setEmailId(customerDetailsRequestDTO.getEmailId());
        customerDetails.setPersonalIdentityCard(customerDetailsRequestDTO.getPersonalIdentityCard());
        customerDetails.setPersonalIdentityCardNumber(customerDetailsRequestDTO.getPersonalIdentityCard());
        customerDetails = customerDetailsRepository.save(customerDetails);

        List<RoomDetails> roomDetailsList = roomDetailsRepository.findRoomDetailsByRoomCategoryAndAndRoomPrice(customerDetailsRequestDTO.getRoomCategory(), customerDetailsRequestDTO.getPaidAmount());
        if (!CollectionUtils.isEmpty(roomDetailsList)){
            for (RoomDetails roomDetails : roomDetailsList) {
                if (roomDetails.getRoomStatus().equalsIgnoreCase("Vacant"))
                    logsDetails.setRoomDetails(roomDetails);
                break;
            }
        }


        logsDetails.setAmountPaid(customerDetailsRequestDTO.getPaidAmount());
        logsDetails.setCheckInDate(new Date());
        logsDetails.setCheckOutDate(customerDetailsRequestDTO.getCheckOutDate());
        logsDetails.setCustomerDetails(customerDetails);
        logsDetails = logsDetailsRepository.save(logsDetails);

        List<EmployeeDetails> employeeDetailsList = employeeDetailsRepository.findEmployeeDetailsByCustomerDetails(null);
        for(EmployeeDetails employeeDetails1 : employeeDetailsList){
            if((employeeDetails1.getCustomerDetails() == null))
                logsDetails.setEmployeeDetails(employeeDetails1);
                logsDetails.setCustomerDetails(logsDetails.getCustomerDetails());
            employeeDetailsRepository.save(employeeDetails1);
            break;
        }
        return logsDetails;
    }

}
