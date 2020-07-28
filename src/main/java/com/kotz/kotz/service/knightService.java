package com.kotz.kotz.service;

import com.kotz.kotz.entity.knight;
import com.kotz.kotz.exception.apiRequestException;
import com.kotz.kotz.repository.knightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class knightService {

    private final knightRepository knightRepository;

    @Autowired
    public knightService(knightRepository knightRepository) {
        this.knightRepository = knightRepository;
    }

    public knight addKnight(knight knight){
        return this.knightRepository.save(knight);
    }

    public List<knight> findAll(){
        return this.knightRepository.findAll();
    }

    public List<knight> findByGod(String name){
        return this.knightRepository.findKnightByGod(name);
    }

    public List<knight> findByArmor(String armor){
        return this.knightRepository.findKnightByArmor(armor);
    }

    public knight randomKnight(){
        return this.knightRepository.getRandomKnight();
    }

    public knight findById (Long id){
        return this.knightRepository.findById(id).orElseThrow(() -> new apiRequestException("Este caballero no viste su armadura"));
    }
}
