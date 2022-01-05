package com.arsenbaktiyarov.spring.employees.bootstrap;

import com.arsenbaktiyarov.spring.employees.entity.Department;
import com.arsenbaktiyarov.spring.employees.entity.Employee;
import com.arsenbaktiyarov.spring.employees.entity.Salary;
import com.arsenbaktiyarov.spring.employees.service.DepartmentService;
import com.arsenbaktiyarov.spring.employees.service.EmployeeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.sql.Date;

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
        Salary salary = new Salary();
        salary.setEmployee(employee);
        salary.setSalary(2000);
        salary.setFromDate(new Date(2015-03-31));
        salary.setToDate(new Date(2016-03-31));
        employee.setSalary(salary);
        employeeService.save(employee);


        Employee employee2 = new Employee();
        employee2.setId(2L);
        employee2.setName("Justin");
        employee2.setSurname("Hunt");
        employeeService.save(employee2);

        Employee employee3 = new Employee();
        employee3.setId(3L);
        employee3.setName("Joe");
        employee3.setSurname("Perry");
        employeeService.save(employee3);



        Department it = new Department();
        it.setName("Information Technologies");
        it.getEmployees().add(employee);
        it.getEmployees().add(employee2);
        departmentService.save(it);

        Department accounting = new Department();
        accounting.setName("Accounting");
        accounting.getEmployees().add(employee3);
        departmentService.save(accounting);

    }



}
