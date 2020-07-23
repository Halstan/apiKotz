package com.kotz.kotz.controller;

import com.kotz.kotz.entity.typeArmor;
import com.kotz.kotz.service.armorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RequestMapping(value = "armaduras")
public class armorController {

    private final armorService armorService;

    @Autowired
    public armorController(armorService armorService) {
        this.armorService = armorService;
    }

    @GetMapping(produces = "application/json")
    public List<typeArmor> findAll(){
        return armorService.findAll();
    }

    @PostMapping(consumes = "application/json", produces="application/json")
    public ResponseEntity addArmor(@RequestBody typeArmor armor){
        typeArmor armorCreated = armorService.addArmor(armor);
        return new ResponseEntity(armorCreated, HttpStatus.CREATED);
    }

}
