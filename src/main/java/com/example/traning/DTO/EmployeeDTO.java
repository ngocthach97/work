package com.example.traning.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeDTO {
    private String name;
    private String phone;
    private String email;
    private String province;
    private String district;
    private String ward;
}
