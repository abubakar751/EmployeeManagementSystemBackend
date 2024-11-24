package com.employeedetail.service;

import com.employeedetail.dto.EmployeeDetailsDto;
import com.employeedetail.dto.EmployeeDetailsResponseDto;
import com.employeedetail.entity.EmployeeDetail;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface IEmployeeDetailService {
String createEmployee(String employeeDetailsDto,MultipartFile image, MultipartFile idProof) throws FileNotFoundException;
    EmployeeDetailsResponseDto getById(String employeeId);
List<EmployeeDetailsResponseDto> getAll();
String deleteData(String employeeId);
    EmployeeDetailsDto update(String employeeId,String employeeDetailsDto  ,MultipartFile image,MultipartFile idProof ) throws IOException;
}
