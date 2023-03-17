package com.example.traning.Common.Payload.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Message {
    private List<? extends Object> data;
    private String message;
    private int code;
    private int total;
    private int size;
}
