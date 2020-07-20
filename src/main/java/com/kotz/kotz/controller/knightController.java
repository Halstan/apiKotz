package com.kotz.kotz.controller;

import com.kotz.kotz.entity.knight;
import com.kotz.kotz.service.knightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class knightController {

    @Autowired
    private knightService knightService;

    @GetMapping("/caballeros")
    public List<knight> getAll(){
        return knightService.findAll();
    }

}
