package com.arsenbaktiyarov.spring.employees.bootstrap;

import com.arsenbaktiyarov.spring.employees.entity.Department;
import com.arsenbaktiyarov.spring.employees.entity.Employee;
import com.arsenbaktiyarov.spring.employees.service.DepartmentService;
import com.arsenbaktiyarov.spring.employees.service.EmployeeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Slf4j
@AllArgsConstructor
@Component
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {


    private final EmployeeService employeeService;
    private final DepartmentService departmentService;


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        log.info("######################");
        log.info("Loading data.........");
        loadData();
        log.info("######################");
    }



    private void loadData() {
        Employee employee = new Employee();
        employee.setId(1L);
        employee.setName("Arsen");
        employee.setSurname("Baktiyarov");
        employee.setSalary(100000);
        employeeService.save(employee);


        Department department = new Department();
        department.setName("IT");
        department.getEmployees().add(employee);
        departmentService.save(department);
    }



}
