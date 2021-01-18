package com.xkcoding.session.controller;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }
}
