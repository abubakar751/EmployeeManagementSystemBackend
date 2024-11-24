package com.employeedetail.service;

import com.employeedetail.dto.EmpLoginDto;
import com.employeedetail.entity.EmpLogin;
import com.employeedetail.repo.EmpLoginRepo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmpLoginService  implements  IEmpLoginService{
    @Autowired
    private EmpLoginRepo empLoginRepo;
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public EmpLoginDto empSave(EmpLoginDto empLoginDto) {
        EmpLogin empLogin = objectMapper.convertValue(empLoginDto, EmpLogin.class);
        EmpLogin save = empLoginRepo.save(empLogin);
      return   objectMapper.convertValue(save, EmpLoginDto.class);
    }
    @Override
    public EmpLogin getEmail(String email){

        return empLoginRepo.findEmployeeByEmail(email);
    }
}
