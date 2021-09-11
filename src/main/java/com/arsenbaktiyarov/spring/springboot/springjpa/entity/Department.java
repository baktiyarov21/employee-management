package com.arsenbaktiyarov.spring.springboot.springjpa.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "departments")
public class Department extends BaseEntity {
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<Employee> employees;

}
