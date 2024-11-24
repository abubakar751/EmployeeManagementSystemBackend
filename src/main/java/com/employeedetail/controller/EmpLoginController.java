package com.employeedetail.controller;

import com.employeedetail.dto.EmpLoginDto;
import com.employeedetail.entity.EmpLogin;
import com.employeedetail.service.IEmpLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/empLogin")
public class EmpLoginController {
    @Autowired
    private IEmpLoginService iEmpLoginService;

    @PostMapping("/save")
    public EmpLoginDto saveEmp(@RequestBody EmpLoginDto empLoginDto) {
        return iEmpLoginService.empSave(empLoginDto);
    }
    @PostMapping("/getAll")
    public ResponseEntity<?> getByEmail(@RequestBody EmpLogin empLogin) {
        EmpLogin retrievedEmpLogin = iEmpLoginService.getEmail(empLogin.getEmail());
        if (retrievedEmpLogin.getEmail().equals(empLogin.getEmail()) &&
                retrievedEmpLogin.getPassword().equals(empLogin.getPassword())) {
            Map<String, String> response = new HashMap<>();
            response.put("message", "Login successful");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Invalid credentials", HttpStatus.BAD_REQUEST);
        }
    }
   /*
   @PostMapping("/getAll")
public ResponseEntity<?> getByEmail(@RequestBody EmpLogin empLogin) {
    // Retrieve user details using email
    EmpLogin empLogin2 = iEmpLoginService.getEmail(empLogin.getEmail());

    // Compare the retrieved email and password with input
    if (empLogin2 != null &&
        empLogin2.getEmail().equals(empLogin.getEmail()) &&
        empLogin2.getPassword().equals(empLogin.getPassword())) {
        return new ResponseEntity<>("Employee Successfully Logged In", HttpStatus.OK);
    } else {
        return new ResponseEntity<>("Invalid Credentials", HttpStatus.BAD_REQUEST);
    }
}

    */
}
