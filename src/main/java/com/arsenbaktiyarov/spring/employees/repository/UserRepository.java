package com.arsenbaktiyarov.spring.employees.repository;

import com.arsenbaktiyarov.spring.employees.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User save(User user);
    User findByEmail(String email);
}
