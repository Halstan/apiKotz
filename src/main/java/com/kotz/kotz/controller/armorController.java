package com.kotz.kotz.controller;

import com.kotz.kotz.dto.armorDTO;
import com.kotz.kotz.mapper.armorMapper;
import com.kotz.kotz.mapper.armorMapperImpl;
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

    private final armorMapper armorMapper = new armorMapperImpl();

    private final armorService armorService;

    @Autowired
    public armorController(armorService armorService) {
        this.armorService = armorService;
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<armorDTO>> findAll(){
        return ResponseEntity.ok(armorMapper.toArmorDTOs(this.armorService.findAll()));
    }

    @PostMapping(consumes = "application/json", produces="application/json")
    public ResponseEntity<armorDTO> addArmor(@RequestBody armorDTO armorDTO){
        this.armorService.addArmor(armorMapper.toArmor(armorDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(armorDTO);
    }

}
