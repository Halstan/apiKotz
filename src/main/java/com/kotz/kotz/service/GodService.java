package com.kotz.kotz.service;

import com.kotz.kotz.entity.God;
import com.kotz.kotz.exception.apiRequestException;
import com.kotz.kotz.repository.GodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class GodService {

    private GodRepository godRepository;

    @Autowired
    public GodService(GodRepository godRepository) {
        this.godRepository = godRepository;
    }

    public List<God> findAll(){
        return this.godRepository.findAll();
    }

    public God addGod(God god){
        return this.godRepository.save(god);
     }

     public God findById(Long id){
        return this.godRepository.findById(id).orElseThrow(() -> new apiRequestException("Este dios aun no despierta"));
     }
}
