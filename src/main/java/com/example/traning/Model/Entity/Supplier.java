package com.example.traning.Model.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "supplier")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Supplier implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator_supplier")
    @SequenceGenerator(name = "generator_supplier", sequenceName = "seq_supplier_id", allocationSize = 1, initialValue = 1)
    private Long id;
    @Column(name = "name")
    private String name;
}
