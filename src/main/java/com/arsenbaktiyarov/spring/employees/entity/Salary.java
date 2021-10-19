package com.arsenbaktiyarov.spring.employees.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "salary")
public class Salary extends BaseEntity{

    @Column(name = "employee_salary")
    private Integer salary;

    @OneToOne(mappedBy = "salary", cascade = CascadeType.ALL)
    private Employee employee;

}
