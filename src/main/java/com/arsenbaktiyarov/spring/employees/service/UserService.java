package com.arsenbaktiyarov.spring.employees.service;

import com.arsenbaktiyarov.spring.employees.entity.User;
import com.arsenbaktiyarov.spring.employees.entity.VerificationToken;
import com.arsenbaktiyarov.spring.employees.validation.EmailExistsException;

public interface UserService {
    User save(User user);
    User findByEmail(String email);
    User registerNewUser(User user) throws EmailExistsException;
    void createVerificationTokenForUser(User user, String token);
    VerificationToken getVerificationToken(String token);
}
