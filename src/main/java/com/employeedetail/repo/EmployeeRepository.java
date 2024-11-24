package com.employeedetail.repo;

import com.employeedetail.entity.EmpLogin;
import com.employeedetail.entity.EmployeeDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository  extends JpaRepository<EmployeeDetail,String> {


}
