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

    @GetMapping("/")
    @Override
    public Department findById(@RequestParam Long id) {
        return departmentService.findById(id);
    }


    @GetMapping("/")
    @Override
    public Department findByName(@RequestParam String name) {
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

    @DeleteMapping("/")
    @Override
    public String deleteById(@RequestParam Long id) {
        departmentService.deleteById(id);

        if(departmentService.findById(id) == null) {
            return "Department with " + id + " was deleted";
        }

        return "Department with " + id + " not found ";


    }
}
