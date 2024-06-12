package com.example.dream;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping
    public String test() {
        return "hi1";
    }

    @GetMapping("/hi2")
    public String test2() {
        return "hi2";
    }
}
