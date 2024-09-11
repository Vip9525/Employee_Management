package com.employee.controller;

import com.employee.dto.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    List<Employee> listEmp=new ArrayList<Employee>();

    @PostMapping
    void createEmployee(@RequestBody Employee emp){
        listEmp.add(emp);
    }

    @GetMapping
    List<Employee> getAllEmployee(){
        return listEmp;
    }

    @GetMapping("/{empId}")
    Employee getEmployee(@PathVariable("empId") Integer empId){
       return listEmp.stream().filter(emp->emp.getEmpId().equals(empId)).toList().get(0);
    }



}
