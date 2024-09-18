package com.example.demo.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyServiceTest {

    @Test
    public void testGetMessage() {
        MyService myService = new MyService();
        assertEquals("Hello, World!", myService.getMessage());
    }
}