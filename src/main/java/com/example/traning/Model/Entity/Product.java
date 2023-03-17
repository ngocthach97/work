package com.example.traning.Model.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "product")
//@SqlResultSetMapping(name = "ProductResult",
//        classes = @ConstructorResult(targetClass = com.example.traning.Model.DTO.ProductDTO.class,
//                columns = {
//                        @ColumnResult(name = "name"),
//                        @ColumnResult(name = "describe"),
//                        @ColumnResult(name = "price", type = Float.class),
//                        @ColumnResult(name = "discount", type = Integer.class),
//                        @ColumnResult(name = "unit"),
//                        @ColumnResult(name = "nameImage"),
//                }
//        )
//)
@SqlResultSetMapping(
        name = "ProductResult",
        entities = {
                @EntityResult(
                        entityClass = com.example.traning.Model.Entity.Product.class,
                        fields = {
                                @FieldResult(name = "name", column = "name"),
                                @FieldResult(name = "describe", column = "describe"),
                                @FieldResult(name = "price", column = "price"),
                                @FieldResult(name = "discount", column = "discount"),
                                @FieldResult(name = "unit", column = "unit")
                        }
                ),
                @EntityResult(
                        entityClass = com.example.traning.Model.Entity.Image.class,
                        fields = {
                                @FieldResult(name = "name", column = "nameImage"),
                        }
                )
        }
)
public class Product implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator_product")
    @SequenceGenerator(name = "generator_product", sequenceName = "seq_product_id", allocationSize = 1, initialValue = 1)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "describe")
    private String describe;
    @Column(name = "price")
    private Float price;
    @Column(name = "discount")
    private Integer discount;
    @Column(name = "unit")
    private String unit;
    @Column(name = "createTime")
    @CreationTimestamp
    private Date createTime;
    @Column(name = "categoryID")
    private Long categoryID;
    @Column(name = "supplierID")
    private Long supplierID;
}
