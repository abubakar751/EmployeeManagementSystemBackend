package com.employeedetail.controller;

import com.employeedetail.dto.EmployeeDetailsDto;
import com.employeedetail.dto.EmployeeDetailsResponseDto;
import com.employeedetail.service.IEmployeeDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/emp")
public class EmployeeDetailsController {
    @Autowired
    private IEmployeeDetailService iEmployeeDetailService;


    /* public String createData(@RequestParam EmployeeDetailsDto employeeDetailsDto , ){
            iEmployeeDetailService.create(employeeDetailsDto);

       return "Data Inserted ";
      }
  */
    @PostMapping("/create")
    public String createEmployee(@RequestParam("image") MultipartFile image,
                                 @RequestParam("idProof") MultipartFile idProof,
                                 @RequestParam("employeeDetailsDto") String employeeDetailsDto)
                                 throws FileNotFoundException {
        String formattedData = employeeDetailsDto.replaceAll("\n", "");
        return iEmployeeDetailService.createEmployee(formattedData, image, idProof);
    }


    @GetMapping("/getId/{employeeId}")
    public EmployeeDetailsResponseDto getDataById(@PathVariable String employeeId) {
        return iEmployeeDetailService.getById(employeeId);
    }

    @GetMapping("/getAll")
    public List<EmployeeDetailsResponseDto> getAllData() {
        return iEmployeeDetailService.getAll();
    }

    @DeleteMapping("/delete/{employeeId}")
    public String deleteData(@PathVariable String employeeId) {
        iEmployeeDetailService.deleteData(employeeId);
        return "deleted Data";
    }
    @PutMapping("/update/{employeeId}")
    public EmployeeDetailsDto updateData(@PathVariable("employeeId") String employeeId,
                                         @RequestParam("image") MultipartFile image,
                                         @RequestParam("idProof") MultipartFile idProof,
                                         @RequestParam("employeeDetailsDto") String employeeDetailsDto)
            throws IOException {
        return iEmployeeDetailService.update(employeeId, employeeDetailsDto, image, idProof);
    }


}
