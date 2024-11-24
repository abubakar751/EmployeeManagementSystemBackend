package com.employeedetail.dto;

import com.employeedetail.constant.Country;
import com.employeedetail.constant.EmploymentStatus;
import com.employeedetail.constant.EmploymentType;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDetailsDto {

    private String firstName;
    private String lastName;
    @JsonFormat(pattern = "yyyy-dd-MM")
    private LocalDate dateOfBirth;
    private String email;
    private String phoneNumber;
    private String jobTitle;
    @JsonFormat(pattern = "yyyy-dd-MM")
    private LocalDate dateOfJoining;
    private EmploymentType employmentType;
    private EmploymentStatus employmentStatus;
    private String location;
    private Country country;
}
