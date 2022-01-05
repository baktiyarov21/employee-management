package com.arsenbaktiyarov.spring.employees.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "employee")
public class Employee extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "birth_date")
    private Date birthday;

    @Enumerated(EnumType.ORDINAL)
    private Gender gender;

    @OneToOne(mappedBy = "employee", cascade = CascadeType.MERGE)
    private Salary salary;

    public Employee() {

    }

    @Builder
    public Employee(Long id, String name, String surname, Date birthday, Gender gender, Salary salary) {
        super(id);
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.gender = gender;
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name) && Objects.equals(surname, employee.surname) && Objects.equals(salary, employee.salary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, surname, salary);
    }

}
