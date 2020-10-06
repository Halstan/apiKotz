package com.kotz.kotz.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class TypeArmor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_armor;

    @Column(length = 30, nullable = false, unique = true)
    private String nameArmor;

    @OneToMany(mappedBy = "armor")
    @JsonIgnore
    private List<Knight> knights;

}
