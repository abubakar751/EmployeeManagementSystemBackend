package com.employeedetail.controller;

import com.employeedetail.dto.EmpRegistrationDto;
import com.employeedetail.entity.EmpRegistration;
import com.employeedetail.service.IEmpRegistration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Register")
@CrossOrigin(origins = "http://localhost:4200")
public class EmpRegistrationController {
    @Autowired
    private IEmpRegistration iempRegistration;
    @PostMapping("/create")
    public ResponseEntity<String> registerEmp(@RequestBody EmpRegistration empRegistration){
        iempRegistration.register(empRegistration);
        return ResponseEntity.ok("{\"message\": \"Employee Successfully Registered\"}");
    }
}
