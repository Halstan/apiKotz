package com.kotz.kotz.dto;

import lombok.Data;

@Data
public class knightDTO {

    private long Id_knight;

    private String name;

    private String constellation;

    private String url_photo;

    private String hability1;

    private String hability2;

    private String hability3;

    private String hability4;

    private armorDTO armor;

    private godDTO god;

}
