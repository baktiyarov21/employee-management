package com.arsenbaktiyarov.spring.employees.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "salary")
public class Salary extends BaseEntity{

    @Column(name = "employee_salary")
    private Integer salary;

    @OneToMany(mappedBy = "salary", cascade = CascadeType.ALL)
    private List<Employee > employeeList;

}
