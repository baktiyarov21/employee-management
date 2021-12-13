package com.arsenbaktiyarov.spring.employees.entity;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "task")
public class Task extends BaseEntity {

    @Column(name = "title")
    private String title;

    @Lob
    @Column(name = "description")
    private String description;

    @Column(name = "deadline")
    private LocalDate deadline;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(name = "employee_tasks",
            joinColumns = @JoinColumn(name = "task_id"),
            inverseJoinColumns = @JoinColumn(name = "employee_id"))
    private List<Employee> employees;

    public Task() {
    }

    @Builder
    public Task(Long id, String title, String description, LocalDate deadline, List<Employee> employees) {
        super(id);
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.employees = employees;
    }
}
