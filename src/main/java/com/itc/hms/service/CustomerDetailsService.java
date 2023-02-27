package com.itc.hms.service;

import com.itc.hms.entity.CustomerDetails;
import com.itc.hms.repository.CustomerDetailsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class CustomerDetailsService {
    private static Logger logger = LoggerFactory.getLogger(CustomerDetailsService.class);

    @Autowired
    private CustomerDetailsRepository customerDetailsRepository;

    public CustomerDetails saveCustomerDetails(CustomerDetails customerDetails){
        customerDetails = customerDetailsRepository.save(customerDetails);
        return customerDetails;
    }

}
