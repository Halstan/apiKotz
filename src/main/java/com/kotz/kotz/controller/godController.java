package com.kotz.kotz.controller;

import com.kotz.kotz.entity.god;
import com.kotz.kotz.service.godService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/dioses")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class godController {

    private final godService godService;

    @Autowired
    public godController(godService godService) {
        this.godService = godService;
    }

    @GetMapping(produces = "application/json")
    public List<god> getAll(){
        return this.godService.findAll();
    }

    @PostMapping(consumes = "application/json", produces="application/json")
    public ResponseEntity addGod(@RequestBody god god){
        god godCreated = this.godService.addGod(god);
        return new ResponseEntity(godCreated, HttpStatus.CREATED);
    }

}
