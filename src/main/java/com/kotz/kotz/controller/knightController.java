package com.kotz.kotz.controller;

import com.kotz.kotz.entity.knight;
import com.kotz.kotz.exception.apiRequestException;
import com.kotz.kotz.service.knightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.http.HTTPException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/caballeros")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class knightController {

    private final knightService knightService;

    @Autowired
    public knightController(knightService knightService) {
        this.knightService = knightService;
    }

    @GetMapping(produces = "application/json")
    public List<knight> getAll(){
        return this.knightService.findAll();
    }

    @PostMapping(consumes = "application/json", produces="application/json")
    public ResponseEntity<?> addKnight(@RequestBody knight knight){
        Map<String, Object> resp = new HashMap<>();
        List<String> error = new ArrayList<>();

        if (knight.getConstellation().isEmpty()) error.add("La constelacion no puede estar vacia");
        if (knight.getName().isEmpty()) error.add("El nombre no puede estar vacio");
        if (knight.getUrl_photo().isEmpty()) error.add("La foto no puede estar vacia");
        if (knight.getHability1().isEmpty()) error.add("La habilidad no puede estar vacia");
        if (knight.getHability2().isEmpty()) error.add("La habilidad no puede estar vacia");
        if (knight.getHability3().isEmpty()) error.add("La habilidad no puede estar vacia");
        if (knight.getHability4().isEmpty()) error.add("La habilidad no puede estar vacia");

        try{
            if(error.isEmpty()){
                knight knightCreated = this.knightService.addKnight(knight);
                if (knight.getArmor().getId_armor() == 5){
                    resp.put("message", "El espectro " + knight.getName() + " de " + knight.getConstellation() + " ha sido registrado");
                }else if(knight.getArmor().getId_armor() == 4){
                    resp.put("message", "El general marino " + knight.getName() + " de " + knight.getConstellation() + " ha sido registrado");
                }else {
                    resp.put("message", "El caballero " + knight.getName() + " de " + knight.getConstellation() + " ha sido registrado");
                }
                //resp.put("Knight", knightCreated);
            }else{
                resp.put("message", "Se encontraron campos vacios");
                resp.put("Errors", error);
                return new ResponseEntity<>(resp, HttpStatus.NOT_ACCEPTABLE);
            }

        }catch (DataAccessException exception){
            resp.put("message", "Error al registrar");
            resp.put("Errors", error);
            return new ResponseEntity<>(resp, HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>(resp, HttpStatus.CREATED);
    }

    @GetMapping(value = "{id}", produces = "application/json")
    public knight getKnightById(@PathVariable Long id){
        return this.knightService.findById(id);
    }

    @GetMapping(value = "/dios/{name}", produces = "application/json")
    public List<knight> getKnightByGod(@PathVariable String name){
        return this.knightService.findByGod(name);
    }

    @GetMapping(value = "/armadura/{armor}", produces = "application/json")
    public List<knight> getKnightByArmor(@PathVariable String armor){
        return this.knightService.findByArmor(armor);
    }

    @GetMapping(value = "/random", produces = "application/json")
    public knight getRandomKnight(){
        return this.knightService.randomKnight();
    }

}
