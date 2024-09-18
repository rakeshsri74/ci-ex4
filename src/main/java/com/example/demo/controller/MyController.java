package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.MyService;

@RestController
@RequestMapping("/api")
public class MyController {
	@Autowired
	private MyService myService;

    @GetMapping("/message")
    public String getMessage() {
        return myService.getMessage();
    }
}
