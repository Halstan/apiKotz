package com.kotz.kotz.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class typeArmor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_armor;
    @Column(length = 30, nullable = false)
    private String nameArmor;

    @OneToMany(mappedBy = "armor")
    @JsonIgnoreProperties("armor")
    private List<knight> knig = new ArrayList<>();
}
