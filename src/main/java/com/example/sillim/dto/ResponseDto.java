package com.example.sillim.dto;

import com.example.sillim.entity.Notice;
import lombok.Getter;

import java.util.List;
import java.util.Optional;

@Getter
public class ResponseDto {
    private int statusCode;
    private Optional<Notice> notice;

    public ResponseDto(int statusCode, Optional<Notice> notice) {
        this.statusCode = statusCode;
        this.notice = notice;
    }

    public ResponseDto(int statusCode) {
        this.statusCode = statusCode;
    }
}
