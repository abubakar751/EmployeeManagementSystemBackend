package com.employeedetail.exception_handler;

public class EmployeeIdNotFound  extends  RuntimeException{

    public EmployeeIdNotFound(String employeeId) {
        super(employeeId);
    }
}
