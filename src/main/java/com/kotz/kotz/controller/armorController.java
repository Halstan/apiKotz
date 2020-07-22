package com.kotz.kotz.controller;

import com.kotz.kotz.entity.typeArmor;
import com.kotz.kotz.service.armorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "armaduras")
public class armorController {

    private final armorService armorService;

    @Autowired
    public armorController(armorService armorService) {
        this.armorService = armorService;
    }

    @GetMapping()
    public List<typeArmor> findAll(){
        return armorService.findAll();
    }

}
