package com.example.traning.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity(name = "district")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class District implements Serializable {
    @Id
    @Column(name = "districtCode")
    private String districtCode;
    @Column(name = "provinceCode")
    private String provinceCode;
    @Column(name = "name")
    private String name;
    @Column(name = "type")
    private String type;
}
