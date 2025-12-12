package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/")
    public String index() {
        // Spring Boot sẽ render: /WEB-INF/views/index.jsp
        return "index";
    }
}

