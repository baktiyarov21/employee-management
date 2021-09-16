package com.arsenbaktiyarov.spring.employees.service;


import com.arsenbaktiyarov.spring.employees.repository.EmployeeRepository;
import com.arsenbaktiyarov.spring.employees.entity.Employee;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {


    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    @Transactional // можно убрать JpaRepository обеспечивает транзакционность
    public List<Employee> findAll() {
        List<Employee> employeeList = new ArrayList<>();
        employeeRepository.findAll().iterator().forEachRemaining(employeeList::add);
        return employeeList;
    }

    @Override
    @Transactional
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    @Transactional
    public Employee findById(Long id) {
        Optional<Employee> emp = employeeRepository.findById(id);
        Employee employee = null;
        if (emp.isPresent()) {
            employee = emp.get();
        }
        return employee;

    }

    @Override
    @Transactional
    public void delete(Employee employee) {
        employeeRepository.delete(employee);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> findAllByName(String name) {
        return employeeRepository.findAllByName(name);
    }
}
