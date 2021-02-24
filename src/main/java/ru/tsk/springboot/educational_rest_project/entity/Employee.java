package ru.tsk.springboot.educational_rest_project.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "employees")
@ApiModel(value = "Модель работника")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @ApiModelProperty(value = "id работника", example = "666")
    private long id;

    @Column(name = "name")
    @ApiModelProperty(value = "Имя работника", example = "Petr")
    private String name;

    @Column(name = "surname")
    @ApiModelProperty(value = "Фамилия работника", example = "Petrov")
    private String surName;

    @Column(name = "department")
    @ApiModelProperty(value = "Департамент работника", example = "IT")
    private String department;

    @Column(name = "salary")
    @ApiModelProperty(value = "Зарплата работника", example = "1500")
    private int salary;


    public Employee(){

    }

    public Employee(String name, String surName, String department, int salary) {
        this.name = name;
        this.surName = surName;
        this.department = department;
        this.salary = salary;
    }
}
