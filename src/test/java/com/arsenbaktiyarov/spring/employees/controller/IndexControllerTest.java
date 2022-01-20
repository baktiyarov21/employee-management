package com.arsenbaktiyarov.spring.employees.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
class IndexControllerTest {

    IndexController indexController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        indexController = new IndexController();
    }


    @Test
    void getIndexPage() {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(indexController)
                .build();
        try {
            mockMvc.perform(get("/"))
                    .andExpect(status().isOk())
                    .andExpect(view().name("index"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}