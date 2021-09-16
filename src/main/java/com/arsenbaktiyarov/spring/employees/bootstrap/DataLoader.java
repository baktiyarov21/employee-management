package com.arsenbaktiyarov.spring.employees.bootstrap;

import com.arsenbaktiyarov.spring.employees.entity.Employee;
import com.arsenbaktiyarov.spring.employees.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DataLoader implements CommandLineRunner {


    private final EmployeeService employeeService;

    public DataLoader(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("######################");
        log.info("Loading data.........");
        loadData();
        log.info("######################");
    }

    private void loadData() {
        Employee employee = new Employee();
        employee.setId(1L);
        employee.setName("Arsen");
        employee.setSurname("Baktiayrov");
        employee.setSalary(100000);
        employeeService.save(employee);
    }


}
