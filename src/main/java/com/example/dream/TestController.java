package com.example.dream;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hi")
public class TestController {

    @GetMapping("/hi1")
    public String test() {
        return "hi1";
    }

    @GetMapping("/hi2")
    public String test2() {
        return "hi2";
    }
}
