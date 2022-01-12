package com.arsenbaktiyarov.spring.employees.controller;


import com.arsenbaktiyarov.spring.employees.entity.User;
import com.arsenbaktiyarov.spring.employees.entity.VerificationToken;
import com.arsenbaktiyarov.spring.employees.repository.VerificationTokenRepository;
import com.arsenbaktiyarov.spring.employees.security.registration.OnRegistrationCompleteEvent;
import com.arsenbaktiyarov.spring.employees.service.UserService;
import com.arsenbaktiyarov.spring.employees.validation.EmailExistsException;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Calendar;
import java.util.UUID;

@Controller
class RegistrationController {

    private final UserService userService;
    private final VerificationTokenRepository verificationTokenRepository;
    private final ApplicationEventPublisher eventPublisher;


    RegistrationController(UserService userService, VerificationTokenRepository verificationTokenRepository, ApplicationEventPublisher eventPublisher) {
        this.userService = userService;
        this.verificationTokenRepository = verificationTokenRepository;
        this.eventPublisher = eventPublisher;
    }

    @GetMapping("signup")
    public ModelAndView registrationForm() {
        return new ModelAndView("registrationPage", "user", new User());
    }

    @PostMapping("user/register")
    public ModelAndView registerUser(@Valid User user, BindingResult result,
                                     HttpServletRequest request) {
        if (result.hasErrors()) {
            return new ModelAndView("registrationPage", "user", user);
        }
        try {
            user.setEnabled(false);
            User registered = userService.registerNewUser(user);
            String token = UUID.randomUUID().toString();
            VerificationToken verificationToken = new VerificationToken(token, user);
            verificationTokenRepository.save(verificationToken);
            String url = "http://" + request.getServerName() + ":" + request.getServerPort() +
                    request.getContextPath();
            eventPublisher.publishEvent(new OnRegistrationCompleteEvent(url, registered));
        } catch (EmailExistsException e) {
            result.addError(new FieldError("user", "email", e.getMessage()));
            return new ModelAndView("registrationPage", "user", user);
        }
        return new ModelAndView("redirect:/login");
    }

    @PostMapping("/registrationConfirm")
    public ModelAndView confirmRegistration(@RequestParam("token") String token,
                                            RedirectAttributes redirectAttributes) {
        VerificationToken verificationToken = userService.getVerificationToken(token);
        if (verificationToken == null) {
            redirectAttributes.addFlashAttribute("errorMessage", "Invalid account confirmation token.");
            return new ModelAndView("redirect:/login");
        }

        User user = verificationToken.getUser();
        Calendar cal = Calendar.getInstance();
        if ((verificationToken.getExpiryDate()
                .getTime()
                - cal.getTime()
                .getTime()) <= 0) {
            redirectAttributes.addFlashAttribute("errorMessage", "Your registration token has expired. Please register again.");
            return new ModelAndView("redirect:/login");
        }

        user.setEnabled(true);
        userService.save(user);
        redirectAttributes.addFlashAttribute("message", "Your account verified successfully");
        return new ModelAndView("redirect:/login");
    }





}
