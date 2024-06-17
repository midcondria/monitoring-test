package com.example.dream;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/hi")
public class TestController {

    @GetMapping("/hi1")
    public String test() {
        return "hi1";
    }

    @GetMapping("/hi2")
    public String test2() {
        return "hi2";
    }

    @PostMapping("/hi3")
    public TestDto test3(@RequestBody TestDto request) {
        log.info("[DTO] {}",request);
        return request;
    }
}
