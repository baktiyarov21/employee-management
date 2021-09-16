package com.arsenbaktiyarov.spring.springboot.springjpa.service;

import com.arsenbaktiyarov.spring.springboot.springjpa.entity.Employee;

import java.util.List;


public interface EmployeeService {
    List<Employee> findAll();

    Employee save(Employee employee);

    Employee findById(Long id);

    void delete(Employee employee);

    void deleteById(Long id);

    public List<Employee> findAllByName(String name);
}
