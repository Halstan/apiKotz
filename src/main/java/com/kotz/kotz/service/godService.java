package com.kotz.kotz.service;

import com.kotz.kotz.entity.god;
import com.kotz.kotz.exception.apiRequestException;
import com.kotz.kotz.repository.godRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class godService {

    private godRepository godRepository;

    @Autowired
    public godService(godRepository godRepository) {
        this.godRepository = godRepository;
    }

    public List<god> findAll(){
        return this.godRepository.findAll();
    }

    public god addGod(god god){
        return this.godRepository.save(god);
     }

     public god findById(Long id){
        return this.godRepository.findById(id).orElseThrow(() -> new apiRequestException("Este dios aun no despierta"));
     }
}
