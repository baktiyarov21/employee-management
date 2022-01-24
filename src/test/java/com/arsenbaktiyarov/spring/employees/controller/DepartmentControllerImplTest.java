package com.arsenbaktiyarov.spring.employees.controller;

import com.arsenbaktiyarov.spring.employees.entity.Department;
import com.arsenbaktiyarov.spring.employees.entity.Employee;
import com.arsenbaktiyarov.spring.employees.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.sql.Date;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(MockitoExtension.class)
class DepartmentControllerImplTest {

    @Mock
    DepartmentService departmentService;

    @InjectMocks
    DepartmentController departmentController;

    ArrayList<Department> departments;

    ArrayList<Employee> employees;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        employees = new ArrayList<>();
        departments = new ArrayList<>();
        employees.add(new Employee(1L,"Steven", "Henry"
                , new Date(2000-02-21), null, null));
        departments.add(Department.builder().name("HR").build());
        departments.add(Department.builder().name("IT").build());
        mockMvc = MockMvcBuilders.standaloneSetup(departmentController).build();
    }

    @Test
    void findAll() throws Exception {
        when(departmentService.findAll())
                .thenReturn(departments);
        mockMvc.perform(get("/department/")).andExpect(status().isOk());
        assertEquals(2, departmentService.findAll().size());
    }

    @Test
    void findById() throws Exception {
        when(departmentService.findById(anyLong()))
                .thenReturn(Department.builder().id(1L).name("Dep").build());
        mockMvc.perform(get("/department/"))
                .andExpect(status().isOk())
                .andReturn();
        Department department = departmentService.findById(anyLong());
        assertEquals(1L, department.getId());

    }
}