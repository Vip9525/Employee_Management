package com.employee.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {

    private String employeeId;

    private String name;

    private String position;

    private Double  salary;

    private String birthDay;

    private String gender;

}
