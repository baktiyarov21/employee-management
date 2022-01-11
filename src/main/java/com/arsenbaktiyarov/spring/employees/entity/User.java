package com.arsenbaktiyarov.spring.employees.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Calendar;

@Getter
@Setter
@Entity
public class User extends BaseEntity {

    @Email
    @NotEmpty(message = "Email is required.")
    private String email;

    @NotEmpty(message = "Password is required.")
    private String password;

    @Transient
    @NotEmpty(message = "Password confirmation is required.")
    private String passwordConfirmation;

    private Calendar created = Calendar.getInstance();

    public User() {}

    @Builder
    public User(Long id, @Email @NotEmpty(message = "Email is required.") String email,
                @NotEmpty(message = "Password is required.") String password,
                @NotEmpty(message = "Password confirmation is required.") String passwordConfirmation) {
        super(id);
        this.email = email;
        this.password = password;
        this.passwordConfirmation = passwordConfirmation;
    }
}