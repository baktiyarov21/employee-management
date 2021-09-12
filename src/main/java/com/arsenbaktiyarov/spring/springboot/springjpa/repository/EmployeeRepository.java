package com.arsenbaktiyarov.spring.springboot.springjpa.repository;

import com.arsenbaktiyarov.spring.springboot.springjpa.entity.Department;
import com.arsenbaktiyarov.spring.springboot.springjpa.entity.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee,Integer> {
    public List<Employee> findAllByName(String name);

}
