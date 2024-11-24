package com.employeedetail.service;

import com.employeedetail.dto.EmpRegistrationDto;
import com.employeedetail.entity.EmpRegistration;

public interface IEmpRegistration {
    public EmpRegistration register(EmpRegistration empRegistration);
}
