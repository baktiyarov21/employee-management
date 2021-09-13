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


    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    @Transactional // можно убрать JpaRepository обеспечивает транзакционность
    public List<Employee> findAll() {
        return (List<Employee>) employeeRepository.findAll();
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
