package com.example.traning.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity(name = "employee")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Employee implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_seq_id")
    @SequenceGenerator(name = "employee_seq_id", sequenceName = "employee_seq_id", allocationSize = 1, initialValue = 1)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "phone")
    private String phone;
    @Column(name = "email")
    private String email;
    @Column(name = "position")
    private String position;
    @ManyToOne
    @JoinColumn(name = "departmentID", nullable = false)
    private Department department;
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "managerID")
    private Employee manager;
    @OneToMany(mappedBy = "manager")
    private Set<Employee> subordinates;
    @Column(name = "provinceCode")
    private String provinceCode;
    @Column(name = "districtCode")
    private String districtCode;
    @Column(name = "wardCode")
    private String wardCode;
    @Column(name = "status")
    private boolean status;
}
