package com.kotz.kotz.controller;

import com.kotz.kotz.dto.knightDTO;
import com.kotz.kotz.entity.knight;
import com.kotz.kotz.mapper.knightMapper;
import com.kotz.kotz.mapper.knightMapperImpl;
import com.kotz.kotz.service.knightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/caballeros")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class knightController {

    private final knightMapper knightMapper = new knightMapperImpl();
    private final knightService knightService;

    @Autowired
    public knightController(knightService knightService) {
        this.knightService = knightService;
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<knightDTO>> getAll(){
        return ResponseEntity.ok(knightMapper.toKnightDTOs(this.knightService.findAll()));
    }

    @PostMapping(consumes = "application/json", produces="application/json")
    public ResponseEntity<knightDTO> addKnight(@RequestBody knightDTO knight){
        Map<String, Object> resp = new HashMap<>();
        List<String> error = new ArrayList<>();

        if (knight.getConstellation().isEmpty()) error.add("La constelación no puede estar vacia");
        if (knight.getName().isEmpty()) error.add("El nombre no puede estar vacío");
        if (knight.getUrl_photo().isEmpty()) error.add("La foto no puede estar vacia");
        if (knight.getHability1().isEmpty()) error.add("La habilidad no puede estar vacia");
        if (knight.getHability2().isEmpty()) error.add("La habilidad no puede estar vacia");
        if (knight.getHability3().isEmpty()) error.add("La habilidad no puede estar vacia");
        if (knight.getHability4().isEmpty()) error.add("La habilidad no puede estar vacia");

        try{
            if(error.isEmpty()){
                this.knightService.addKnight(knightMapper.toKnight(knight));
            }else{
                resp.put("message", "Se encontraron campos vacíos");
                resp.put("Errors", error);
                return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
            }

        }catch (DataAccessException exception){
            resp.put("message", "Error al registrar");
            resp.put("Errors", error);
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(knight);
    }

    @GetMapping(value = "{id}", produces = "application/json")
    public ResponseEntity<knightDTO> getKnightById(@PathVariable Long id){
        knight knight = this.knightService.findById(id);
        return ResponseEntity.ok(knightMapper.toKnightDTO(knight));
    }

    @GetMapping(value = "/dios/{name}", produces = "application/json")
    public ResponseEntity<List<knightDTO>> getKnightByGod(@PathVariable String name){
        List<knight> knight = this.knightService.findByGod(name);
        return ResponseEntity.ok(knightMapper.toKnightDTOs(knight));
    }

    @GetMapping(value = "/armadura/{armor}", produces = "application/json")
    public ResponseEntity<List<knightDTO>> getKnightByArmor(@PathVariable String armor){
        List<knight> knight = this.knightService.findByArmor(armor);
        return ResponseEntity.ok(knightMapper.toKnightDTOs(knight));
    }

    @GetMapping(value = "/random", produces = "application/json")
    public ResponseEntity<knightDTO> getRandomKnight(){
        knight knight = this.knightService.randomKnight();
        return ResponseEntity.ok(knightMapper.toKnightDTO(knight));
    }

}
