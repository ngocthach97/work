package com.example.traning.Model.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


@SqlResultSetMapping(
        name = "EmployeeResult",
        entities = {
                @EntityResult(
                        entityClass = Employee.class,
                        fields = {
                                @FieldResult(name = "name", column = "E.NAME"),
                                @FieldResult(name = "phone", column = " E.NAME"),
                                @FieldResult(name = "email", column = "E.EMAIL"),
                        }
                )
        }
)
@Entity(name = "employee")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Component
public class Employee implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_seq_id")
    @SequenceGenerator(name = "employee_seq_id", sequenceName = "employee_seq_id", allocationSize = 1, initialValue = 1)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "phone")
    private String phone;
    @Column(name = "email")
    private String email;
    @Column(name = "role")
    private String role;
    @Column(name = "departmentID")
    private Long departmentID;
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "managerID")
    private Employee manager;
    @OneToMany(mappedBy = "manager")
    private Set<Employee> subordinates;
    @Column(name = "position")
    private String position;
    @Column(name = "provinceCode")
    private String provinceCode;
    @Column(name = "districtCode")
    private String districtCode;
    @Column(name = "wardCode")
    private String wardCode;
    @Column(name = "address")
    private String address;
    @Column(name = "status")
    private Boolean status;
}
