package com.employee.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Employee {

    @Id
    @GeneratedValue(strategy =GenerationType.UUID)
    private String employeeId;

    private String name;

    private String position;

    private Double  salary;

    private LocalDate birthDay;

    private String gender;

}
