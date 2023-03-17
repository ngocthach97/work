package com.example.traning.Model.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDTO {
    private String name;
    private String describe;
    private Float price;
    private Integer discount;
    private String unit;
    private String nameImage;
}
