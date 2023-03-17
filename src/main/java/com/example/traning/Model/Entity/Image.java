package com.example.traning.Model.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "image")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Image implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator_image")
    @SequenceGenerator(name = "generator_image", sequenceName = "seq_image_id", allocationSize = 1, initialValue = 1)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "path")
    private String path;
    @Column(name = "type")
    private String type;
    @Column(name = "productID")
    private Long productID;
    public Image(String name, String path, String type, Long productID) {
        this.name = name;
        this.path = path;
        this.type = type;
        this.productID = productID;
    }
}
