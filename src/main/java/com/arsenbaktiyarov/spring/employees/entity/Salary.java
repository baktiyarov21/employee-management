package com.arsenbaktiyarov.spring.employees.entity;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Date;

@Getter
@Setter
@Entity
@Table(name = "salaries")
public class Salary extends BaseEntity {

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Column(name = "salary")
    private int salary;

    @Column(name = "from_date")
    @DateTimeFormat(pattern="dd/MM/yyyy")
    private Date fromDate;

    @Column(name = "to_date")
    @DateTimeFormat(pattern="dd/MM/yyyy")
    private Date toDate;

    public Salary() {}

    @Builder
    public Salary(Long id, Employee employee, int salary, Date fromDate, Date toDate) {
        super(id);
        this.employee = employee;
        this.salary = salary;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }
}
