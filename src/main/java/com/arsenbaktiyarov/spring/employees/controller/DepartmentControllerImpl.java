package com.arsenbaktiyarov.spring.employees.controller;

import com.arsenbaktiyarov.spring.employees.entity.Department;
import com.arsenbaktiyarov.spring.employees.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/department")
public class DepartmentControllerImpl implements DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentControllerImpl(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }


    @GetMapping("/")
    @Override
    public List<Department> findAll() {
        return departmentService.findAll();
    }

    @GetMapping("/{id}")
    @Override
    public Department findById(@PathVariable Long id) {
        return departmentService.findById(id);
    }


    @GetMapping("/{name}")
    @Override
    public Department findByName(@PathVariable String name) {
        return departmentService.findByName(name);
    }

    @PostMapping("/")
    @Override
    public Department save(Department department) {
        return departmentService.save(department);
    }

    @DeleteMapping("/")
    @Override
    public String delete(Department department) {
        departmentService.delete(department);
        return "Department " + department.getName() + " was deleted";
    }

    @DeleteMapping("/{id}")
    @Override
    public String deleteById(@PathVariable Long id) {
        departmentService.deleteById(id);

        if(departmentService.findById(id) == null) {
            return "Department with " + id + " was deleted";
        }

        return "Department with " + id + " not found ";


    }
}
