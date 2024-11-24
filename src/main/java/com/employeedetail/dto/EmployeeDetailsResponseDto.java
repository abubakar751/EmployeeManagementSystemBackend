package com.employeedetail.dto;

import com.employeedetail.constant.Country;
import com.employeedetail.constant.EmploymentStatus;
import com.employeedetail.constant.EmploymentType;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;
@Data
public class EmployeeDetailsResponseDto {

    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String email;
    private String phoneNumber;
    private String jobTitle;
    private LocalDate dateOfJoining;
    private EmploymentType employmentType;
    private EmploymentStatus employmentStatus;
    private String location;
    private Country country;
    private  byte[]image ;
    private  byte [] idProof ;
}
