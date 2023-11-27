package com.example.sillim.controller;

import com.example.sillim.entity.Notice;
import com.example.sillim.entity.Test;
import com.example.sillim.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sillim")
public class TestController {
    private final TestService testService;

    @GetMapping("/test/{str}")
    public Optional<Test> test(@PathVariable String str) {
        Optional<Test> res = testService.testServiceMethod(str);

        return res;
    }

    @PostMapping("/test")
    public String test2(@RequestBody Test testParam){
        testService.save(testParam);
        return "OK";
    }

    @PostMapping("/notice")
    public String createNotice(@RequestBody Notice noticeParam){
        testService.save(noticeParam);
        return "OK";
    }
}
