package com.example.sillim.service;

import com.example.sillim.dto.TestDto;
import com.example.sillim.repository.TestRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class TestService {
    private final TestRepository testRepository;

    public TestService(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    public TestDto testServiceMethod(String str) {
        TestDto testDto = new TestDto(str);

        return testDto;
    }
}
