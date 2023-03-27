package com.example.traning.Common.Payload.Response;

import com.example.traning.Common.Constant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Message {
    private Object data;
    private String message;
    private int code;
    private String type;
    private int total;
    private int size;

    public Message(String type) {
        this.type = type;
    }

    public Message error() {
        return new Message(Constant.MessageType.error);
    }

    public Message warning() {
        return new Message(Constant.MessageType.warning);
    }

    public Message success() {
        return new Message(Constant.MessageType.success);
    }
}
