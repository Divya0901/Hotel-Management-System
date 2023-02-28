package com.itc.hms.repository;

import com.itc.hms.entity.CustomerDetails;
import com.itc.hms.entity.EmployeeDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeDetailsRepository extends JpaRepository<EmployeeDetails, Integer> {
     EmployeeDetails findEmployeeDetailsByEmpMobileNumberAndEmpAadharCardNumber(Long mobileNumber, Long aadharNumber);

     List<EmployeeDetails> findEmployeeDetailsByCustomerDetails(CustomerDetails customerDetails);
}

