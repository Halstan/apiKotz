package com.kotz.kotz.controller;

import com.kotz.kotz.entity.god;
import com.kotz.kotz.service.godService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/dioses")
public class godController {

    private final godService godService;

    @Autowired
    public godController(godService godService) {
        this.godService = godService;
    }

    @GetMapping()
    public List<god> getAll(){
        return godService.findAll();
    }

}
