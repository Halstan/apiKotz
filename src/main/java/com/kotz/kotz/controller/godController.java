package com.kotz.kotz.controller;

import com.kotz.kotz.dto.godDTO;
import com.kotz.kotz.entity.god;
import com.kotz.kotz.mapper.godMapper;
import com.kotz.kotz.mapper.godMapperImpl;
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

    private final godMapper godMapper = new godMapperImpl();

    @Autowired
    public godController(godService godService) {
        this.godService = godService;
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<godDTO>> getAll(){
        return ResponseEntity.ok(godMapper.toGodDTOs(this.godService.findAll()));
    }

    @PostMapping(consumes = "application/json", produces="application/json")
    public ResponseEntity<godDTO> addGod(@RequestBody godDTO godDTO){
        this.godService.addGod(godMapper.toGod(godDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(godDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<godDTO> findGod(@PathVariable Long id){
        god god = this.godService.findById(id);
        return ResponseEntity.ok(godMapper.toGodDTO(god));
    }

}
