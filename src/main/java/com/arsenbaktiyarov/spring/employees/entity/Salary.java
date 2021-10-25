package com.arsenbaktiyarov.spring.employees.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "salary")
public class Salary extends BaseEntity{

    @Column(name = "employee_salary")
    private Integer salary;

    @OneToMany(mappedBy = "salary", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Employee > employeeList;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Salary salary1 = (Salary) o;
        return Objects.equals(salary, salary1.salary) && Objects.equals(employeeList, salary1.employeeList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), salary, employeeList);
    }

}
