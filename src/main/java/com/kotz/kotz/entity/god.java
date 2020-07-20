package com.kotz.kotz.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class god {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id_god;

    @Column(length = 30, nullable = false)
    private String name;

    @OneToMany (mappedBy = "god")
    @JsonIgnoreProperties("god")
    private List<knight> knight = new ArrayList<>();

}
