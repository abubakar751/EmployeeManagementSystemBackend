package com.employeedetail.repo;

import com.employeedetail.entity.EmpLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpLoginRepo extends JpaRepository<EmpLogin,String> {
    EmpLogin findEmployeeByEmail(String email);
}
