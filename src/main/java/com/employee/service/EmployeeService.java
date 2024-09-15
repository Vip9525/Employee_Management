package com.employee.service;

import com.employee.dto.EmployeeDto;
import com.employee.entities.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeService {
    EmployeeDto addEmployee(EmployeeDto empDto);
    List<EmployeeDto> getAllEmployee();
    EmployeeDto getEmployeeById(String employeeId);
    EmployeeDto updateEmployee(EmployeeDto employeeDto);
    Map<String,String> deleteEmployee(String employeId);
}
