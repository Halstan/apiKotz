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

    @Autowired
    private knightRepository knightRepository;

    public knight addKnight(knight knight){
        return knightRepository.save(knight);
    }

    public List<knight> findAll(){
        return knightRepository.findAll();
    }

    public List<knight> findByGod(String name){
        return knightRepository.findKnightByGod(name);
    }

    public List<knight> findByArmor(String armor){
        return knightRepository.findKnightByArmor(armor);
    }

    public knight randomKnight(){
        return knightRepository.getRandomKnight();
    }

    public knight findById (Long id){
        return knightRepository.findById(id).get();
    }
}
