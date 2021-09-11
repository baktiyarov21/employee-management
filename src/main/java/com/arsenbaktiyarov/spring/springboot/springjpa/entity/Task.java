package com.arsenbaktiyarov.spring.springboot.springjpa.entity;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "tasks")
public class Task extends BaseEntity {
    @Column(name = "title")
    private String title;

    @Lob
    @Column(name = "description")
    private String description;

    @Column(name = "deadline")
    private LocalDate deadline;

    @ManyToMany
    @JoinTable(name = "employee_tasks",
            joinColumns = @JoinColumn(name = "task_id"),
            inverseJoinColumns = @JoinColumn(name = "employee_id"))
    private List<Employee> employees;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
