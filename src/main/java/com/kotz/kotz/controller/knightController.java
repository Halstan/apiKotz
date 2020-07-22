package com.kotz.kotz.controller;

import com.kotz.kotz.entity.knight;
import com.kotz.kotz.service.knightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/caballeros")
public class knightController {

    private final knightService knightService;

    @Autowired
    public knightController(knightService knightService) {
        this.knightService = knightService;
    }

    @GetMapping(produces = "application/json")
    public List<knight> getAll(){
        return knightService.findAll();
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity addKnight(@RequestBody knight knight){
        knight knightCreated = knightService.addKnight(knight);
        return new ResponseEntity(knightCreated, HttpStatus.CREATED);
    }

    @GetMapping(value = "/dios/{name}", produces = "application/json")
    public List<knight> getKnightByGod(@PathVariable String name){
        return knightService.findByGod(name);
    }

    @GetMapping(value = "/armadura/{armor}", produces = "application/json")
    public List<knight> getKnightByArmor(@PathVariable String armor){
        return knightService.findByArmor(armor);
    }

    @GetMapping(value = "/ramdon", produces = "application/json")
    public knight getRandomKnight(){
        return knightService.randomKnight();
    }

}
