package com.arsenbaktiyarov.spring.employees.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "department")
public class Department extends BaseEntity {
    @Column(name = "name")
    private String name;

    @OneToMany(cascade =  {
            CascadeType.MERGE,
            CascadeType.REFRESH
    })
    @JoinColumn(name = "department_id")
    private List<Employee> employees = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Department that = (Department) o;
        return Objects.equals(name, that.name) && Objects.equals(employees, that.employees);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, employees);
    }


}
