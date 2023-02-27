package com.itc.hms.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;

@Entity
@Table
public class EmployeeDetails {

    @JsonInclude(JsonInclude.Include.NON_NULL)

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer empId;
    private String empName;
    private Long empMobileNumber;
    private String empEmailId;
    private String empAddress;
    private Long empAadharCardNumber;

    @ManyToOne(fetch = FetchType.EAGER)
    private CustomerDetails customerDetails;

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Long getEmpMobileNumber() {
        return empMobileNumber;
    }

    public void setEmpMobileNumber(Long empMobileNumber) {
        this.empMobileNumber = empMobileNumber;
    }

    public String getEmpEmailId() {
        return empEmailId;
    }

    public void setEmpEmailId(String empEmailId) {
        this.empEmailId = empEmailId;
    }

    public String getEmpAddress() {
        return empAddress;
    }

    public void setEmpAddress(String empAddress) {
        this.empAddress = empAddress;
    }

    public Long getEmpAadharCardNumber() {
        return empAadharCardNumber;
    }

    public void setEmpAadharCardNumber(Long empAadharCardNumber) {
        this.empAadharCardNumber = empAadharCardNumber;
    }

    public CustomerDetails getCustomerDetails() {
        return customerDetails;
    }

    public void setCustomerDetails(CustomerDetails customerDetails) {
        this.customerDetails = customerDetails;
    }
}
