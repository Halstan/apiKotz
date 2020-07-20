package com.kotz.kotz.controller;

import com.kotz.kotz.entity.typeArmor;
import com.kotz.kotz.service.armorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class armorController {

    @Autowired
    private armorService armorService;

    @GetMapping("/armaduras")
    public List<typeArmor> findAll(){
        return armorService.findAll();
    }

}
