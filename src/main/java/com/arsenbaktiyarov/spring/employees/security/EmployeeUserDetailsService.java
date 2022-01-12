package com.arsenbaktiyarov.spring.employees.security;

import com.arsenbaktiyarov.spring.employees.entity.User;
import com.arsenbaktiyarov.spring.employees.exception.UsernameNotFoundException;
import com.arsenbaktiyarov.spring.employees.service.UserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;

@Service
public class EmployeeUserDetailsService implements UserDetailsService {

    private static final String ROLE_USER = "ROLE_USER";
    private final UserService userService;


    public EmployeeUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    public UserDetails loadUserByUsername(final String email) {
        final User user = userService.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("No user found with username: " + email);
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
                user.getEnabled(), true, true, true,
                getAuthorities(ROLE_USER));
    }

    private Collection<? extends GrantedAuthority> getAuthorities(String role) {
        return Arrays.asList(new SimpleGrantedAuthority(role));
    }

}
