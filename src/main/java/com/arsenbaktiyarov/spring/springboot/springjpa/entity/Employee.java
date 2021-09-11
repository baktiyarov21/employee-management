package com.arsenbaktiyarov.spring.springboot.springjpa.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "employees")
public class Employee extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @Column(name = "salary")
    private int salary;

    @ManyToMany(mappedBy = "employees")
    private List<Task> tasks;

    public Employee() {}

    public Employee(String name, String surname, Department department, int salary) {
        this.name = name;
        this.surname = surname;
        this.department = department;
        this.salary = salary;
    }

}
