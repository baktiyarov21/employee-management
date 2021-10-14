package com.arsenbaktiyarov.spring.employees.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "departments")
public class Department extends BaseEntity {
    @Column(name = "name")
    private String name;

    @OneToMany(cascade =  {
            CascadeType.MERGE,
            CascadeType.REFRESH
    })
    @JoinColumn(name = "department_id")
    private List<Employee> employees = new ArrayList<>();

}
