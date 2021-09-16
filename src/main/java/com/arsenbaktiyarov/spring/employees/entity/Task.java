package com.arsenbaktiyarov.spring.employees.entity;


import lombok.*;
import lombok.extern.slf4j.Slf4j;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
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
}
