package com.arsenbaktiyarov.spring.employees.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "salary")
public class Salary extends BaseEntity{

    @Column(name = "employee_salary")
    private Integer salary;

    @OneToMany(mappedBy = "salary", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Employee > employeeList;


}
