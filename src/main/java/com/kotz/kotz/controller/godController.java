package com.kotz.kotz.controller;

import com.kotz.kotz.entity.god;
import com.kotz.kotz.service.godService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class godController {

    @Autowired
    private godService godService;

    @GetMapping("/dioses")
    public List<god> getAll(){
        return godService.findAll();
    }

}
