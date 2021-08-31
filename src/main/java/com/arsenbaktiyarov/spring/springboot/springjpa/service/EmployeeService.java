package com.arsenbaktiyarov.spring.springboot.springjpa.service;

import com.arsenbaktiyarov.spring.springboot.springjpa.entity.Employee;

import java.util.List;


public interface EmployeeService {
    public List<Employee> getAllEmployees();

    public void saveEmployee(Employee employee);

    public Employee getEmployee(int id);

    public void deleteEmployee(int id);

    public List<Employee> findAllByName(String name);
}
