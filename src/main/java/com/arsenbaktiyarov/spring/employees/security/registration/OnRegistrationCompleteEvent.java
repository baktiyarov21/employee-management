package com.arsenbaktiyarov.spring.employees.security.registration;

import com.arsenbaktiyarov.spring.employees.entity.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

@Getter
@Setter
public class OnRegistrationCompleteEvent extends ApplicationEvent {
    private String url;
    private User user;


    public OnRegistrationCompleteEvent(String url, User user) {
        super(user);
        this.url = url;
        this.user = user;
    }
}
