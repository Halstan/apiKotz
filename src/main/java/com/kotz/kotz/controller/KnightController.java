package com.kotz.kotz.controller;

import com.kotz.kotz.dto.KnightDTO;
import com.kotz.kotz.entity.Knight;
import com.kotz.kotz.mapper.knightMapper;
import com.kotz.kotz.mapper.knightMapperImpl;
import com.kotz.kotz.service.KnightService;
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
public class KnightController {

    private final knightMapper knightMapper = new knightMapperImpl();
    private final KnightService knightService;

    @Autowired
    public KnightController(KnightService knightService) {
        this.knightService = knightService;
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<KnightDTO>> getAll(){
        return ResponseEntity.ok(knightMapper.toKnightDTOs(this.knightService.findAll()));
    }

    @PostMapping(consumes = "application/json", produces="application/json")
    public ResponseEntity<KnightDTO> addKnight(@RequestBody KnightDTO knight){
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
    public ResponseEntity<KnightDTO> getKnightById(@PathVariable Long id){
        Knight knight = this.knightService.findById(id);
        return ResponseEntity.ok(knightMapper.toKnightDTO(knight));
    }

    @GetMapping(value = "/dios/{name}", produces = "application/json")
    public ResponseEntity<List<KnightDTO>> getKnightByGod(@PathVariable String name){
        List<Knight> knight = this.knightService.findByGod(name);
        return ResponseEntity.ok(knightMapper.toKnightDTOs(knight));
    }

    @GetMapping(value = "/armadura/{armor}", produces = "application/json")
    public ResponseEntity<List<KnightDTO>> getKnightByArmor(@PathVariable String armor){
        List<Knight> knight = this.knightService.findByArmor(armor);
        return ResponseEntity.ok(knightMapper.toKnightDTOs(knight));
    }

    @GetMapping(value = "/random", produces = "application/json")
    public ResponseEntity<KnightDTO> getRandomKnight(){
        Knight knight = this.knightService.randomKnight();
        return ResponseEntity.ok(knightMapper.toKnightDTO(knight));
    }

    @GetMapping(value = "/nombre/{name}", produces = "application/json")
    public ResponseEntity<List<KnightDTO>> getKnightsByName(@PathVariable String name){
        List<Knight> knights = this.knightService.getKnightsByName(name);

        return ResponseEntity.ok(knightMapper.toKnightDTOs(knights));
    }

}
