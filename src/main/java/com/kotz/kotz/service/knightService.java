package com.kotz.kotz.service;

import com.kotz.kotz.entity.knight;
import com.kotz.kotz.repository.knightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class knightService {

    private knightRepository knightRepository;

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
        return this.knightRepository.findById(id).get();
    }
}
