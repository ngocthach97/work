package com.example.traning.Model.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "inventory")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Inventory implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator_inventory")
    @SequenceGenerator(name = "generator_inventory", sequenceName = "seq_inventory_id", allocationSize = 1, initialValue = 1)
    private Long id;
    @Column(name = "count")
    private Long count;
    @Column(name = "productID")
    private Long productID;
    @Column(name = "warehouseID")
    private Long warehouseID;
}
