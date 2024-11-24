package com.employeedetail.repo;

import com.employeedetail.entity.EmpRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpRegistrationRepo  extends JpaRepository<EmpRegistration,Integer> {
}
