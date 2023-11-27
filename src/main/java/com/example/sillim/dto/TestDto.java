package com.example.sillim.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TestDto {
    private String testStr;

    public TestDto(String testStr) {
        this.testStr = testStr;
    }
}
