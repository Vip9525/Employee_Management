package com.employee.controller;

import com.employee.dto.EmployeeDto;
import com.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/employee")
@CrossOrigin("*")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @PostMapping
    void createEmployee(@RequestBody EmployeeDto emp){
        EmployeeDto empDto=  employeeService.addEmployee(emp);
    }

    @GetMapping
    List<EmployeeDto> getAllEmployee(){
        return employeeService.getAllEmployee();
    }

    @GetMapping("/{empId}")
    EmployeeDto getEmployee(@PathVariable("empId") String empId){
       return employeeService.getEmployeeById(empId);
    }

    @PutMapping
    EmployeeDto updateEmployee(@RequestBody EmployeeDto employeeDto){
        return employeeService.updateEmployee(employeeDto);
    }

    @DeleteMapping("/{empId}")
    Map<String, String> deleteEmployee(@PathVariable("empId") String employeeId){
        return employeeService.deleteEmployee(employeeId);
    }

}
