package com.employeedetail.controller;

import com.employeedetail.dto.AdminDto;
import com.employeedetail.entity.Admin;
import com.employeedetail.security.JWTUtil;
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

    @Autowired
    private JWTUtil jwtUtil;

    @PostMapping("/save")
    public AdminDto save(@RequestBody AdminDto adminDto) {
        return iAdminService.save(adminDto);
    }

    @PostMapping("/get")
    public ResponseEntity<?> getByUserName(@RequestBody Admin admin) {
        Admin existingAdmin = iAdminService.getByeUserName(admin.getUsername());

        if (existingAdmin != null
                && existingAdmin.getUsername().equals(admin.getUsername())
                && existingAdmin.getPassword().equals(admin.getPassword())) {

            String token = jwtUtil.generateToken(admin.getUsername());

            Map<String, String> response = new HashMap<>();
            response.put("username",admin.getUsername());
            response.put("message", "Login successful");
            response.put("token", token);


            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Invalid credentials", HttpStatus.BAD_REQUEST);
        }
    }
}
