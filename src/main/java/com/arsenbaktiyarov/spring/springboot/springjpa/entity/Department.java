package com.arsenbaktiyarov.spring.springboot.springjpa.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "departments")
public class Department extends BaseEntity {
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<Employee> employees;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
