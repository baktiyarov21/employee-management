package com.arsenbaktiyarov.spring.employees.entity;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "position")
public class Position extends BaseEntity {

    @Column(name = "name")
    private String name;

    @OneToMany(cascade =  {
            CascadeType.MERGE,
            CascadeType.REFRESH
    })
    @JoinColumn(name = "position_id")
    private List<Employee> employees = new ArrayList<>();

    public Position() {
    }

    @Builder
    public Position(Long id, String name, List<Employee> employees) {
        super(id);
        this.name = name;
        this.employees = employees;
    }
}
