package com.arsenbaktiyarov.spring.springboot.springjpa.dao;

import com.arsenbaktiyarov.spring.springboot.springjpa.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    public List<Employee> findAllByName(String name);
}
