package com.example.sillim.service;

import com.example.sillim.entity.Notice;
import com.example.sillim.entity.Test;
import com.example.sillim.repository.NoticeRepository;
import com.example.sillim.repository.TestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TestService {
    private final TestRepository testRepository;
    private final NoticeRepository noticeRepository;

    public Optional<Test> testServiceMethod(String str) {
        Optional<Test> test = testRepository.findById(1);

        return test;
    }

    public void save(Test test){
        testRepository.save(test);
    }

    public void save(Notice notice){
        noticeRepository.save(notice);
    }
}
