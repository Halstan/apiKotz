package com.kotz.kotz.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class knight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id_knight;

    @NotNull
    @Column(length = 50)
    private String name;

    @Column(length = 50)
    private String constellation;

    @Column(length = 120)
    private String url_photo;

    @Column(length = 50)
    private String hability1;

    @Column(length = 50)
    private String hability2;

    @Column(length = 50)
    private String hability3;

    @Column(length = 50)
    private String hability4;

    @ManyToOne
    @JsonIgnoreProperties("knig")
    private typeArmor armor;

    @ManyToOne
    @JsonIgnoreProperties("knight")
    private god god;
}
