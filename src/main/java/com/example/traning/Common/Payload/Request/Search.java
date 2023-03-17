package com.example.traning.Common.Payload.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Search extends Paging {
    private Long employeeID;
    private String provinceCode;
    private String districtCode;
    private String wardCode;
    private Long productID;
    private Long categoryID;
    private Boolean isDiscount;
    private Boolean isBestSelling;
    private Boolean isPrice;
    private Boolean isProductNew;
}
