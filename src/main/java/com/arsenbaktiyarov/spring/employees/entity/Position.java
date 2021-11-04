package com.arsenbaktiyarov.spring.employees.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
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
}
