package com.arsenbaktiyarov.spring.employees.service;

import com.arsenbaktiyarov.spring.employees.entity.User;

public interface UserService {
    User save(User user);
    User findByEmail(String email);
}
