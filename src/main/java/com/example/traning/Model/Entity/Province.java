package com.example.traning.Model.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity(name = "province")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Province  implements Serializable {
    @Id
    @Column(name = "provinceCode")
    private String provinceCode;
    @Column(name = "name")
    private String name;
    @Column(name = "type")
    private String type;
}
