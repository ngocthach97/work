package com.example.traning.Model.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "orderItem")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderItem implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator_orderItem")
    @SequenceGenerator(name = "generator_orderItem", sequenceName = "seq_orderItem_id", allocationSize = 1, initialValue = 1)
    private Long id;
    @Column(name = "quantity")
    private Long quantity;
    @Column(name = "ordersID")
    private Long ordersID;
    @Column(name = "productID")
    private Long productID;
}
