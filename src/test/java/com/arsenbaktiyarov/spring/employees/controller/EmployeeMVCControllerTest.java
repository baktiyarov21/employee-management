package com.arsenbaktiyarov.spring.employees.controller;

import com.arsenbaktiyarov.spring.employees.entity.Employee;
import com.arsenbaktiyarov.spring.employees.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@ExtendWith(MockitoExtension.class)
class EmployeeMVCControllerTest {

    @Mock
    EmployeeService employeeService;

    @Mock
    Model model;

    @InjectMocks
    EmployeeMvcController employeeMvcController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void textMockMVC() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(employeeMvcController).build();

        mockMvc.perform(get("/employee-mvc/"))
        .andExpect(status().isOk())
        .andExpect(view().name("index"));
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
        String viewName = employeeMvcController.showUsersList(model);
        //then
        assertEquals("index", viewName);
        verify(employeeService, times(1)).findAll();
        verify(model, times(1)).addAttribute(eq("employees"), argumentCaptor.capture());
        List<Employee> listInController = argumentCaptor.getValue();
        assertEquals(2, listInController.size());
    }
}