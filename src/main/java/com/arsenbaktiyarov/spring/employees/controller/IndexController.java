package com.arsenbaktiyarov.spring.employees.controller;

import com.arsenbaktiyarov.spring.employees.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/index")
public class IndexController {
    private final EmployeeService employeeService;

    public IndexController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping({"","/"})
    public String getIndexPage(Model model) {
        log.debug("Getting Index Page");
        model.addAttribute("employees", employeeService.findAll());
        return "index";
    }
}
