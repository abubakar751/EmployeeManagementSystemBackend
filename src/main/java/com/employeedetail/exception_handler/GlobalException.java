package com.employeedetail.exception_handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException  {
    @ExceptionHandler(FileNotFoundException.class)

ResponseEntity<String> handleFileNotFound(FileNotFoundException exception){

return new  ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
}
    @ExceptionHandler(EmployeeIdNotFound.class)
    public ResponseEntity<String> handleIdNotFound(EmployeeIdNotFound ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
