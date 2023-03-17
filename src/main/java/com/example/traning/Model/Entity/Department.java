package com.example.traning.Model.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity(name = "department")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Department implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator_department")
    @SequenceGenerator(name = "generator_department", sequenceName = "seq_department_id", allocationSize = 1, initialValue = 1)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "departmentID")
    private Long departmentID;
}
