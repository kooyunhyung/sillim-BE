package com.example.sillim.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TestDto {
    public String getTestStr() {
        return testStr;
    }

    public void setTestStr(String testStr) {
        this.testStr = testStr;
    }

    private String testStr;

    public TestDto(String testStr) {
        this.testStr = testStr;
    }
}
