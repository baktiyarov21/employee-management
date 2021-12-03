package com.arsenbaktiyarov.spring.employees.controller;

import com.arsenbaktiyarov.spring.employees.entity.Employee;
import com.arsenbaktiyarov.spring.employees.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/employee-rest")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employee/{id}")
    public Employee getById(@PathVariable Long id) {
        return employeeService.findById(id);
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.findAll();
    }



    @PostMapping("/employees")
    public Employee addNewEmployee(@RequestBody Employee employee) {
        employeeService.save(employee);
        return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        employeeService.save(employee);
        return employee;
    }

    @DeleteMapping("/employees/")
    public String delete(@RequestBody Employee employee) {
        employeeService.delete(employee);
        return "Employee deleted" + employee.getName();
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployeeById (@PathVariable Long id) {
        employeeService.deleteById(id);
        return "Employee with id = " + id + " deleted";
    }

    @GetMapping("employees/name/{name}")
    public List<Employee> findAllByName(@PathVariable String name) {
        return employeeService.findAllByName(name);
    }
}
