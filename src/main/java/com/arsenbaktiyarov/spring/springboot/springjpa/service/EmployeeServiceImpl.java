package com.arsenbaktiyarov.spring.springboot.springjpa.service;


import com.arsenbaktiyarov.spring.springboot.springjpa.repository.EmployeeRepository;
import com.arsenbaktiyarov.spring.springboot.springjpa.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    @Transactional // можно убрать JpaRepository обеспечивает транзакционность
    public List<Employee> getAllEmployees() {
        return (List<Employee>) employeeRepository.findAll();
    }

    @Override
    @Transactional
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    @Transactional
    public Employee getEmployee(int id) {
        Optional<Employee> emp = employeeRepository.findById(id);
        Employee employee = null;
        if (emp.isPresent()) {
            employee = emp.get();
        }
        return employee;

    }

    @Override
    @Transactional
    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> findAllByName(String name) {
        List<Employee> employees = employeeRepository.findAllByName(name);
        return employees;
    }


}
