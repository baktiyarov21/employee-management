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
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Arrays;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(MockitoExtension.class)
class DepartmentControllerImplTest {

    @Mock
    DepartmentService departmentService;

    @InjectMocks
    DepartmentControllerImpl departmentController;

    ArrayList<Department> departments;

    ArrayList<Employee> employees;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        employees = new ArrayList<>();
        departments = new ArrayList<>();
        employees.add(new Employee("Steven", "Henry", 10000, null));
        departments.add(Department.builder().name("HR").build());
        departments.add(Department.builder().name("IT").build());
        mockMvc = MockMvcBuilders.standaloneSetup(departmentController).build();
    }

    @Test
    void findAll() throws Exception {
        when(departmentService.findAll())
                .thenReturn(Arrays.asList(Department.builder().name("IT").build()));
        mockMvc.perform(get("/department/")).andExpect(status().isOk());
        verify(departmentService).findAll();
    }

    @Test
    void findById() {
    }

    @Test
    void save() throws Exception {
        when(departmentService.save(any())).thenReturn(Department.builder().name("Dep").build());
        mockMvc.perform(post("/department/")).andExpect(status().isOk());
        verify(departmentService).save(any());
        verify(departmentService, times(1)).save(any());
    }

    @Test
    void deleteById() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                .delete("/department/")).andExpect(status().isOk()).andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());

    }
}