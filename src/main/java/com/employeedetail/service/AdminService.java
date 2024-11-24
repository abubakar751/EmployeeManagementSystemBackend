package com.employeedetail.service;

import com.employeedetail.dto.AdminDto;
import com.employeedetail.entity.Admin;
import com.employeedetail.repo.AdminRepo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminService  implements IAdminService{
    @Autowired
private AdminRepo adminRepo;
    @Autowired
    private ObjectMapper objectMapper;
    public AdminDto save(AdminDto adminDto){
        Admin admin = objectMapper.convertValue(adminDto, Admin.class);
        Admin save = adminRepo.save(admin);
      return   objectMapper.convertValue(save,AdminDto.class);
    }

    @Override
    public Admin getByeUserName(String username) {
        Admin admin = adminRepo.findById(username).get();
        return  admin;

    }
}
