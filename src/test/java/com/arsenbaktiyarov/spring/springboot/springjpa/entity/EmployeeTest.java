package com.arsenbaktiyarov.spring.springboot.springjpa.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    Employee employee;

    @BeforeEach
    void setUp() {
        employee = new Employee();
        employee.setName("Arsen");
        employee.setSurname("Baktiyarov");
    }

    @Test
    void getName() {
        String name = "Arsen";
        assertEquals(name, employee.getName());
    }

    @Test
    void getSurname() {
        String surname = "Baktiyarov";
        assertEquals(surname, employee.getSurname());
    }
}