package com.arsenbaktiyarov.spring.employees.controller;

import com.arsenbaktiyarov.spring.employees.entity.Employee;
import com.arsenbaktiyarov.spring.employees.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/employee-mvc")
public class EmployeeMvcController {
    private final EmployeeService employeeService;

    public EmployeeMvcController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping({"", "/"})
    public String getIndexPage(Model model) {
        List<Employee> employees = employeeService.findAll();
        model.addAttribute("employees", employees);
        log.info(employees.get(0).toString());
        return "employee";
    }
}
