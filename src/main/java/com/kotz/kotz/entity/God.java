package com.kotz.kotz.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class God {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id_god;

    @Column(length = 30, nullable = false, unique = true)
    private String name;

    @Column(length = 130)
    private String url_photo;

    @OneToMany (mappedBy = "god")
    @JsonIgnore
    private List<Knight> knight;

}
