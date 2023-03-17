package com.example.traning.Model.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "warehouse")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Warehouse implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator_warehouse")
    @SequenceGenerator(name = "generator_warehouse", sequenceName = "seq_warehouse_id", allocationSize = 1, initialValue = 1)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "provinceCode")
    private String provinceCode;
    @Column(name = "districtCode")
    private String districtCode;
    @Column(name = "wardCode")
    private String wardCode;
    @Column(name = "address")
    private String address;
}
