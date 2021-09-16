package com.arsenbaktiyarov.spring.employees.service;

import com.arsenbaktiyarov.spring.employees.entity.Employee;

import java.util.List;


public interface EmployeeService {
    List<Employee> findAll();

    Employee save(Employee employee);

    Employee findById(Long id);

    void delete(Employee employee);

    void deleteById(Long id);

    List<Employee> findAllByName(String name);
}
