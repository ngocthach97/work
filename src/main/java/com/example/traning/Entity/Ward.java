package com.example.traning.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity(name = "ward")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Ward implements Serializable {
    @Id
    @Column(name = "wardCode")
    private String wardCode;
    @Column(name = "districtCode")
    private String districtCode;
    @Column(name = "name")
    private String name;
    @Column(name = "type")
    private String type;
}
