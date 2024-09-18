package com.example.demo.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.service.MyService;

@WebMvcTest(MyController.class) // Focuses only on MyController
public class MyControllerTest {

    @Autowired
    private MockMvc mockMvc;  // MockMvc will be automatically configured by Spring

    @MockBean  // Use @MockBean instead of @Mock to let Spring inject it properly
    private MyService myService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetMessage() throws Exception {
        when(myService.getMessage()).thenReturn("Hello, World!");

        mockMvc.perform(get("/api/message"))
               .andExpect(status().isOk())
               .andExpect(content().string("Hello, World!"));
    }
}