package com.example.sillim.dto;

import lombok.Getter;
import java.util.Optional;

@Getter
public class ResponseDto<T> {
    private int statusCode;
    private Optional<T> obj;

    public ResponseDto(int statusCode, Optional<T> obj) {
        this.statusCode = statusCode;
        this.obj = obj;
    }

    public ResponseDto(int statusCode) {
        this.statusCode = statusCode;
    }
}
