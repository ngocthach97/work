package com.example.traning.Common.Payload.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Paging {
    private int page;
    private int size;
}
