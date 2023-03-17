package com.example.traning.Model.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "category")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Category implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator_category")
    @SequenceGenerator(name = "generator_category", sequenceName = "seq_category_id", allocationSize = 1, initialValue = 1)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "categoryID")
    private Long categoryID;
}
