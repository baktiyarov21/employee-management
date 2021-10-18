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

        Employee employee2 = new Employee();
        employee.setId(2L);
        employee.setName("Justin");
        employee.setSurname("Hunt");
        employee.setSalary(20000);
        employeeService.save(employee2);

        Employee employee3 = new Employee();
        employee.setId(3L);
        employee.setName("Joe");
        employee.setSurname("Perry");
        employee.setSalary(50000);
        employeeService.save(employee3);

        Employee employee4 = new Employee();
        employee.setId(4L);
        employee.setName("Ross");
        employee.setSurname("Geller");
        employee.setSalary(30000);
        employeeService.save(employee4);


        Department it = new Department();
        it.setName("Information Technologies");
        it.getEmployees().add(employee);
        departmentService.save(it);

        Department accounting = new Department();
        accounting.setName("Accounting");
        accounting.getEmployees().add(employee3);
        departmentService.save(accounting);


    }



}
