package com.example.sillim.controller;

import com.example.sillim.dto.TestDto;
import com.example.sillim.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
    private final TestService testService;

    @Autowired
    public TestController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping("/test/{str}")
    public String test(@PathVariable String str) {
        TestDto res = testService.testServiceMethod(str);

        return "hello " + res.getTestStr();
    }
}
