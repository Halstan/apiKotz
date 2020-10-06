package com.kotz.kotz.controller;

import com.kotz.kotz.dto.GodDTO;
import com.kotz.kotz.entity.God;
import com.kotz.kotz.mapper.godMapper;
import com.kotz.kotz.mapper.godMapperImpl;
import com.kotz.kotz.service.GodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/dioses")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class GodController {

    private final GodService godService;

    private final godMapper godMapper = new godMapperImpl();

    @Autowired
    public GodController(GodService godService) {
        this.godService = godService;
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<GodDTO>> getAll(){
        return ResponseEntity.ok(godMapper.toGodDTOs(this.godService.findAll()));
    }

    @PostMapping(consumes = "application/json", produces="application/json")
    public ResponseEntity<GodDTO> addGod(@RequestBody GodDTO godDTO){
        this.godService.addGod(godMapper.toGod(godDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(godDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GodDTO> findGod(@PathVariable Long id){
        God god = this.godService.findById(id);
        return ResponseEntity.ok(godMapper.toGodDTO(god));
    }

}
