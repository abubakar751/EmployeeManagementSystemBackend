package com.employeedetail.entity;

import com.employeedetail.constant.Country;
import com.employeedetail.constant.EmploymentStatus;
import com.employeedetail.constant.EmploymentType;
import com.employeedetail.util.LocalDateDeserializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class EmployeeDetail implements Serializable {
    @Id
    @GeneratedValue(generator = "custom-generator")
    @GenericGenerator(name = "custom-generator", strategy = "org.hibernate.id.UUIDGenerator")
    private String employeeId;
    private String firstName;
    private String lastName;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate dateOfBirth;
    private String email;
    private String phoneNumber;
    private String jobTitle;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate dateOfJoining;
    @Enumerated(EnumType.STRING)
    private EmploymentType employmentType;
    @Enumerated(EnumType.STRING)
    private EmploymentStatus employmentStatus;
    @Enumerated(EnumType.STRING)
    private Country country;
    @Lob
    private byte[] image;
    @Lob
    private byte[] idProof;
    private String location;


}
