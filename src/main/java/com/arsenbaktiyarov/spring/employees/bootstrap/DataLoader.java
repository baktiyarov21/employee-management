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
        Salary juniorsSalary = new Salary();
        juniorsSalary.setId(1L);
        juniorsSalary.setSalary(25000);

        Salary middlesSalary = new Salary();
        middlesSalary.setId(2L);
        middlesSalary.setSalary(55000);

        Employee employee = new Employee();
        employee.setId(1L);
        employee.setName("Arsen");
        employee.setSurname("Baktiyarov");
        employee.setSalary(middlesSalary);
        employeeService.save(employee);

        Employee employee2 = new Employee();
        employee2.setId(2L);
        employee2.setName("Justin");
        employee2.setSurname("Hunt");
        employee2.setSalary(middlesSalary);
        employeeService.save(employee2);

        Employee employee3 = new Employee();
        employee3.setId(3L);
        employee3.setName("Joe");
        employee3.setSurname("Perry");
        employee3.setSalary(juniorsSalary);
        employeeService.save(employee3);

        Employee employee4 = new Employee();
        employee4.setId(4L);
        employee4.setName("Ross");
        employee4.setSurname("Geller");
        employee4.setSalary(juniorsSalary);
        employeeService.save(employee4);


        Department it = new Department();
        it.setName("Information Technologies");
        it.getEmployees().add(employee);
        it.getEmployees().add(employee2);
        departmentService.save(it);

        Department accounting = new Department();
        accounting.setName("Accounting");
        accounting.getEmployees().add(employee3);
        accounting.getEmployees().add(employee4);
        departmentService.save(accounting);


    }



}
