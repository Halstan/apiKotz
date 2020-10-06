package com.kotz.kotz.controller;

import com.kotz.kotz.dto.ArmorDTO;
import com.kotz.kotz.mapper.armorMapper;
import com.kotz.kotz.mapper.armorMapperImpl;
import com.kotz.kotz.service.ArmorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RequestMapping(value = "armaduras")
public class ArmorController {

    private final armorMapper armorMapper = new armorMapperImpl();

    private final ArmorService armorService;

    @Autowired
    public ArmorController(ArmorService armorService) {
        this.armorService = armorService;
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<ArmorDTO>> findAll(){
        return ResponseEntity.ok(armorMapper.toArmorDTOs(this.armorService.findAll()));
    }

    @PostMapping(consumes = "application/json", produces="application/json")
    public ResponseEntity<ArmorDTO> addArmor(@RequestBody ArmorDTO armorDTO){
        this.armorService.addArmor(armorMapper.toArmor(armorDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(armorDTO);
    }

}
