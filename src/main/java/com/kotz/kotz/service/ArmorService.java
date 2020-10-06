package com.kotz.kotz.service;

import com.kotz.kotz.entity.TypeArmor;
import com.kotz.kotz.repository.ArmorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ArmorService {

    private final ArmorRepository armorRepository;

    @Autowired
    public ArmorService(ArmorRepository armorRepository) {
        this.armorRepository = armorRepository;
    }

    public List<TypeArmor> findAll(){
        return this.armorRepository.findAll();
    }

    public TypeArmor addArmor(TypeArmor armor){
        return this.armorRepository.save(armor);
    }

}
