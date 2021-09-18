package com.arsenbaktiyarov.spring.employees.service;

import com.arsenbaktiyarov.spring.employees.entity.Employee;
import com.arsenbaktiyarov.spring.employees.repository.EmployeeRepository;
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
        assertEquals(1,allEmployees.size());
    }




}