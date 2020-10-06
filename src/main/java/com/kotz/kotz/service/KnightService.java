package com.kotz.kotz.service;

import com.kotz.kotz.entity.Knight;
import com.kotz.kotz.exception.apiRequestException;
import com.kotz.kotz.repository.KnightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class KnightService {

    private final KnightRepository knightRepository;

    @Autowired
    public KnightService(KnightRepository knightRepository) {
        this.knightRepository = knightRepository;
    }

    public Knight addKnight(Knight knight){
        return this.knightRepository.save(knight);
    }

    public List<Knight> findAll(){
        return this.knightRepository.findAll();
    }

    public List<Knight> findByGod(String name){
        return this.knightRepository.findKnightByGod(name);
    }

    public List<Knight> findByArmor(String armor){
        return this.knightRepository.findKnightByArmor(armor);
    }

    public Knight randomKnight(){
        return this.knightRepository.getRandomKnight();
    }

    public Knight findById (Long id){
        return this.knightRepository.findById(id).orElseThrow(() -> new apiRequestException("Este caballero no viste su armadura"));
    }

    public List<Knight> getKnightsByName(String name){
        return this.knightRepository.getKnightsByNameStartsWith(name);
    }
}
