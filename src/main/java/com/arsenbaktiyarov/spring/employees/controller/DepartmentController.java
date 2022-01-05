package com.arsenbaktiyarov.spring.employees.controller;

import com.arsenbaktiyarov.spring.employees.entity.Department;
import com.arsenbaktiyarov.spring.employees.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController{

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/")
    public List<Department> findAll() {
        return departmentService.findAll();
    }

    @GetMapping("/{id}")
    public Department findById(@PathVariable Long id) {
        return departmentService.findById(id);
    }


    @GetMapping("/{name}")
    public Department findByName(@PathVariable String name) {
        return departmentService.findByName(name);
    }

    @PostMapping("/")
    public Department save(Department department) {
        return departmentService.save(department);
    }

    @DeleteMapping("/")
    public String delete(Department department) {
        departmentService.delete(department);
        return "Department " + department.getName() + " was deleted";
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable Long id) {
        departmentService.deleteById(id);
        if(departmentService.findById(id) == null) {
            return "Department with " + id + " was deleted";
        }
        return "Department with " + id + " not found ";


    }
}
