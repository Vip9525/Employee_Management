package com.employee.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    private Integer empId;

    private String employeeName;

    private Double salary;
}
