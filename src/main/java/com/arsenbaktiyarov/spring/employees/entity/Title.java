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
@Table(name = "titles")
public class Title extends BaseEntity {

    @OneToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Column(name = "title")
    private String title;

    @Column(name = "from_date")
    @DateTimeFormat(pattern="dd/MM/yyyy")
    private Date fromDate;

    @Column(name = "to_date")
    @DateTimeFormat(pattern="dd/MM/yyyy")
    private Date toDate;

    public Title() {}

    @Builder
    public Title(Long id, Employee employee, String title, Date fromDate, Date toDate) {
        super(id);
        this.employee = employee;
        this.title = title;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }
}
