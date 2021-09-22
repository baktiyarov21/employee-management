package com.arsenbaktiyarov.spring.employees.repository;

import com.arsenbaktiyarov.spring.employees.entity.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
class EmployeeRepositoryIT {

    @Autowired
    EmployeeRepository employeeRepository;

    @BeforeEach
    void setUp() {

    }

    @Test
    void findEmployeeByName() {
        Employee savedEmployee = new Employee();
        savedEmployee.setName("Joe");
        employeeRepository.save(savedEmployee);
        Employee employee
                = employeeRepository.findEmployeeByName("Joe");
        assertEquals(savedEmployee.getName(), employee.getName());
//        assertEquals("Joe", employee.getName());
    }
}