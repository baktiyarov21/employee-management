package com.arsenbaktiyarov.spring.springboot.springjpa.service;

import com.arsenbaktiyarov.spring.springboot.springjpa.entity.Employee;
import com.arsenbaktiyarov.spring.springboot.springjpa.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class EmployeeServiceImplTest {

    EmployeeServiceImpl employeeService;

    @Mock
    EmployeeRepository employeeRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        employeeService = new EmployeeServiceImpl(employeeRepository);

    }

    @Test
    void findAll() {
        Employee employee = new Employee();
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(employee);
        when(employeeService.findAll()).thenReturn(employeeList);

        List<Employee> allEmployees = employeeService.findAll();
        assertEquals(allEmployees.size(), 1);
    }




}