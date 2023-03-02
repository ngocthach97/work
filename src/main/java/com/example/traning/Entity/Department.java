package com.example.traning.Entity;

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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "department_seq_id")
    @SequenceGenerator(name = "department_seq_id", sequenceName = "department_seq_id", allocationSize = 1, initialValue = 1)
    private Long id;
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "department")
    private Set<Employee> employeeSet;
}
