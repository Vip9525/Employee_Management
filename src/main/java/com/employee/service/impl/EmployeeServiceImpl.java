package com.employee.service.impl;

import com.employee.dto.EmployeeDto;
import com.employee.entities.Employee;
import com.employee.repository.EmployeeRepository;
import com.employee.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public EmployeeDto addEmployee(EmployeeDto empDto) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate birthday = LocalDate.parse(empDto.getBirthDay(), formatter);
        Employee emp= modelMapper.map(empDto, Employee.class);
        emp.setBirthDay(birthday);
        Employee employee= employeeRepository.save(emp);
        return modelMapper.map(employee,EmployeeDto.class);
    }


    @Override
    public List<EmployeeDto> getAllEmployee() {
       return employeeRepository.findAll().stream().map(employee->modelMapper.map(employee,EmployeeDto.class)).toList();
    }

    @Override
    public EmployeeDto getEmployeeById(String employeeId) {
       Employee employee=employeeRepository.findById(employeeId).orElse(null);
        return modelMapper.map(employee,EmployeeDto.class);
    }

    @Override
    public EmployeeDto updateEmployee(EmployeeDto employeeDto) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate birthday = LocalDate.parse(employeeDto.getBirthDay(), formatter);
        Optional<Employee> employee=employeeRepository.findById(employeeDto.getEmployeeId());
        if(employee.isPresent()){
           Employee emp= employee.get();
            emp.setName(employeeDto.getName());
            emp.setPosition(employeeDto.getPosition());
            emp.setSalary(employeeDto.getSalary());
            emp.setGender(employeeDto.getGender());
            emp.setBirthDay(birthday);
           return modelMapper.map(employeeRepository.save(emp),EmployeeDto.class);
        }else{
            return null;
        }

    }

    @Override
    public Map<String, String> deleteEmployee(String employeId) {
        employeeRepository.deleteById(employeId);
        return Map.of("Deleted","Employee Deleted Successfully");
    }
}
