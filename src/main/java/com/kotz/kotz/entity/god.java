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

    @Column(length = 30, nullable = false, unique = true)
    private String name;

    @Column(length = 130)
    private String url_photo;

    @OneToMany (mappedBy = "god")
    @JsonIgnoreProperties("god")
    private List<knight> knight = new ArrayList<>();

}
