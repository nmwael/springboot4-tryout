package com.example.demo.rest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloWorldController {

    @GetMapping(path = "hello",produces = MediaType.TEXT_PLAIN_VALUE)
    public String sayHello() {
        return "Hello World";
    }

}