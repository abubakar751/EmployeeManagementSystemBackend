package com.employeedetail.service;

import com.employeedetail.dto.AdminDto;
import com.employeedetail.entity.Admin;

public interface IAdminService {
    public AdminDto save(AdminDto adminDto);
    public Admin getByeUserName(String username);
}
