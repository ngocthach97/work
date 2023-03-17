package com.example.traning.Model.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Orders implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator_orders")
    @SequenceGenerator(name = "generator_orders", sequenceName = "seq_orders_id", allocationSize = 1, initialValue = 1)
    private Long id;
    @Column(name = "orderDate")
    @CreationTimestamp
    private Date orderDate;
    @Column(name = "status")
    private String status;
    @Column(name = "employeeID")
    private Long employeeID;
}
