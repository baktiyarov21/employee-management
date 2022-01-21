package com.arsenbaktiyarov.spring.employees.config;

import com.arsenbaktiyarov.spring.employees.security.EmployeePasswordEncoderFactories;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
@Configuration
public class EmployeeSecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;

    public EmployeeSecurityConfig(@Qualifier("employeeUserDetailsService") UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/signup", "/user/register").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().
                loginPage("/login").permitAll().
                loginProcessingUrl("/doLogin")
                .and()
                .rememberMe().tokenValiditySeconds(604800)
                .key("EmployeeAppKey")
//                .useSecureCookie(true)
                .rememberMeCookieName("my-cookie")
                .and()
                .logout().permitAll().logoutUrl("/doLogout")
                .and()
                .csrf().disable();
    }

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return EmployeePasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
