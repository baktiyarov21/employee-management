package com.arsenbaktiyarov.spring.springboot.springjpa.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
//@RequestMapping("/boot-api")
public class MyRESTController {


    @GetMapping
    public ResponseEntity<String> sayHello() {
        log.debug("###########################");
        log.debug("Rest Controller is running");
        log.debug("###########################");
        return ResponseEntity.ok("Hello");
    }

//    @Autowired
//    private EmployeeService employeeService;
//
//    @GetMapping("/employees")
//    public List<Employee> showAllEmployees() {
//        List<Employee> allEmployees = employeeService.getAllEmployees();
//        return allEmployees;
//    }
//
//    @GetMapping("/employees/{id}")
//    public Employee findById(@PathVariable int id) {
//        Employee employee = employeeService.findById(id);
//
//
//        return employee;
//
//    }
//
//    @PostMapping("/employees")
//    public Employee addNewEmployee(@RequestBody Employee employee) {
//        employeeService.saveEmployee(employee);
//
//        return employee;
//    }
//
//    @PutMapping("/employees")
//    public Employee updateEmployee(@RequestBody Employee employee) {
//        employeeService.saveEmployee(employee);
//
//        return employee;
//    }
//
//    @DeleteMapping("/employees/{id}")
//    public String deleteEmployee(@PathVariable int id) {
//        Employee employee = employeeService.findById(id);
//
//
//        employeeService.deleteEmployee(id);
//
//        return "Employee with id = " + id + " deleted";
//    }
//
//    @GetMapping("employees/name/{name}")
//    public List<Employee> showAllEmployees(@PathVariable String name) {
//        List<Employee> employees = employeeService.findAllByName(name);
//        return employees;
//    }
}
