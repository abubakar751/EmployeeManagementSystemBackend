package com.employeedetail.service;

import com.employeedetail.dto.EmployeeDetailsDto;
import com.employeedetail.dto.EmployeeDetailsResponseDto;
import com.employeedetail.entity.EmployeeDetail;
import com.employeedetail.exception_handler.EmployeeIdNotFound;
import com.employeedetail.repo.EmployeeRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeDetailService implements IEmployeeDetailService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public String createEmployee(String employeeDetailsDto, MultipartFile image,
                                 MultipartFile idProof) {
        String savedId = null;
        try {
            EmployeeDetail employeeDetail = objectMapper.readValue(employeeDetailsDto,
                    EmployeeDetail.class);
            employeeDetail.setImage(image != null ? image.getBytes() : null);
            employeeDetail.setIdProof(idProof != null ? idProof.getBytes() : null);

            savedId = employeeRepository.save(employeeDetail).getEmployeeId();
//            return "Data Inserted";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return savedId != null ? "Account created" : "Account  not created!";
    }


    @Override
    public EmployeeDetailsResponseDto getById(String employeeId) {
        EmployeeDetail byId = employeeRepository.findById(employeeId).get();
        if (byId != null) {
            return objectMapper.convertValue(byId, EmployeeDetailsResponseDto.class);
        } else
            throw new EmployeeIdNotFound("EmployeeId Not found" + employeeId);
    }

    @Override
    public List<EmployeeDetailsResponseDto> getAll() {
        ArrayList<EmployeeDetailsResponseDto> objects = new ArrayList<>();
        List<EmployeeDetail> all = employeeRepository.findAll();
        for (EmployeeDetail list : all) {
            if (list != null) {
                EmployeeDetailsResponseDto employeeDetailsResponseDto = objectMapper.convertValue(list, EmployeeDetailsResponseDto.class);
                objects.add(employeeDetailsResponseDto);
            } else
                return null;
        }
        return objects;
    }
    @Override
    public String deleteData(String employeeId) {
      //  EmployeeDetail byId = employeeRepository.findById(employeeId).get();
        if (employeeRepository.existsById(employeeId)) {
            employeeRepository.deleteById(employeeId);
        } else {
            throw new EmployeeIdNotFound("Id Not Found " + employeeId);
        }

        return "employeeData Deleted" + employeeId;
    }

    @Override
    public EmployeeDetailsDto update(String employeeId, String employeeDetailsDto,
                                     MultipartFile image, MultipartFile idProof) throws IOException {
        Optional<EmployeeDetail> optionalEmployeeDetail = employeeRepository.findById(employeeId);
        if (!optionalEmployeeDetail.isPresent()) {
            throw new EmployeeIdNotFound("Employee not found with ID: " + employeeId);
        }
        EmployeeDetail existingEmployeeDetail = optionalEmployeeDetail.get();

        EmployeeDetail updatedEmployeeDetail = objectMapper.readValue(employeeDetailsDto, EmployeeDetail.class);

        existingEmployeeDetail.setFirstName(updatedEmployeeDetail.getFirstName());
        existingEmployeeDetail.setLastName(updatedEmployeeDetail.getLastName());
        existingEmployeeDetail.setDateOfBirth(updatedEmployeeDetail.getDateOfBirth());
        existingEmployeeDetail.setEmail(updatedEmployeeDetail.getEmail());
        existingEmployeeDetail.setPhoneNumber(updatedEmployeeDetail.getPhoneNumber());
        existingEmployeeDetail.setJobTitle(updatedEmployeeDetail.getJobTitle());
        existingEmployeeDetail.setDateOfJoining(updatedEmployeeDetail.getDateOfJoining());
        existingEmployeeDetail.setEmploymentType(updatedEmployeeDetail.getEmploymentType());
        existingEmployeeDetail.setEmploymentStatus(updatedEmployeeDetail.getEmploymentStatus());
        existingEmployeeDetail.setLocation(updatedEmployeeDetail.getLocation());
        existingEmployeeDetail.setCountry(updatedEmployeeDetail.getCountry());
        // Update the image and ID proof if new files are provided
        if (image != null && !image.isEmpty()) {
            existingEmployeeDetail.setImage(image.getBytes());
        }
        if (idProof != null && !idProof.isEmpty()) {
            existingEmployeeDetail.setIdProof(idProof.getBytes());
        }
        // Save the updated employee details
        EmployeeDetail savedEmployeeDetail = employeeRepository.save(existingEmployeeDetail);
        // Convert the saved entity back into a DTO for the response
        return objectMapper.convertValue(savedEmployeeDetail, EmployeeDetailsDto.class);
    }}
























       /* EmployeeDetail existingEmployeeDetail = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new EmployeeIdNotFound("Employee not found with ID: " + employeeId));
        objectMapper.updateValue(existingEmployeeDetail, employeeDetailsDto);

        EmployeeDetail updatedEmployeeDetail = employeeRepository.save(existingEmployeeDetail);
        return objectMapper.convertValue(updatedEmployeeDetail, EmployeeDetailsDto.class);*/






