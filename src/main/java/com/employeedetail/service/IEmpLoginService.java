package com.employeedetail.service;

import com.employeedetail.dto.EmpLoginDto;
import com.employeedetail.entity.EmpLogin;

public interface IEmpLoginService {
    public EmpLoginDto empSave(EmpLoginDto empLoginDto);
    public EmpLogin getEmail(String email);
}
