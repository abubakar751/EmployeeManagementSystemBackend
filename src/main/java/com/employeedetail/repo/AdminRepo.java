package com.employeedetail.repo;

import com.employeedetail.dto.AdminDto;
import com.employeedetail.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepo extends JpaRepository<Admin,String> {

}
