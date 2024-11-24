package com.employeedetail.controller;

import com.employeedetail.dto.AdminDto;
import com.employeedetail.entity.Admin;
import com.employeedetail.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private IAdminService iAdminService;
    @PostMapping("/save")
    public AdminDto save(@RequestBody AdminDto adminDto){
     return    iAdminService.save(adminDto);
    }
    @PostMapping("/get")
    public ResponseEntity<?> getByUserName(@RequestBody Admin admin) {
        Admin byeUserName = iAdminService.getByeUserName(admin.getUsername());
        if (byeUserName.getUsername().equals(admin.getUsername()) && (byeUserName.getPassword()).equals(admin.getPassword())) {
            Map<String, String> response = new HashMap<>();
            response.put("message", "Login successFully");

            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Invalid credential", HttpStatus.BAD_REQUEST);
        }
    }
    }

