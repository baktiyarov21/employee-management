package com.arsenbaktiyarov.spring.employees.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@EnableWebSecurity
@Configuration
public class EmployeeSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("user")  // #1
                .password("{noop}password")
                .authorities("USER")
                .and()
                .withUser("admin") // #2
                .password("{noop}password")
                .authorities("ADMIN");
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login").permitAll()
                .loginProcessingUrl("/doLogin")
                .and().logout().permitAll()
                .logoutRequestMatcher(new AntPathRequestMatcher("/doLogout", "GET"))
                .and().csrf().disable();
    }
}
