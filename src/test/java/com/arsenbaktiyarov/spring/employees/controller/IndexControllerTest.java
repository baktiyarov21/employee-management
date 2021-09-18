package com.arsenbaktiyarov.spring.employees.controller;

import com.arsenbaktiyarov.spring.employees.entity.Employee;
import com.arsenbaktiyarov.spring.employees.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

class IndexControllerTest {

    @Mock
    EmployeeService employeeService;

    @Mock
    Model model;

    IndexController indexController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        indexController = new IndexController(employeeService);
    }

    @Test
    void getIndexPage() {
        // given
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee());
        Employee employee = new Employee();
        employee.setId(1L);
        employeeList.add(employee);
        when(employeeService.findAll()).thenReturn(employeeList);
        ArgumentCaptor<List<Employee>> argumentCaptor = ArgumentCaptor.forClass(List.class);
        // when
        String viewName = indexController.getIndexPage(model);
        //then
        assertEquals("index", viewName);
        verify(employeeService, times(1)).findAll();
        verify(model, times(1)).addAttribute(eq("employees"), argumentCaptor.capture());
        List<Employee> listInController = argumentCaptor.getValue();
        assertEquals(2, listInController.size());
    }
}