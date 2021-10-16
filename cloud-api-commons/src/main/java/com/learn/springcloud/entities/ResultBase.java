package com.learn.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultBase<T> {
    private String code;
    private String message;
    private T data;

    public ResultBase(String code, String message) {
        this(code, message, null);
    }
}
