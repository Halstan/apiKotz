package com.kotz.kotz.service;

import com.kotz.kotz.entity.typeArmor;
import com.kotz.kotz.repository.armorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class armorService {

    private armorRepository armorRepository;

    @Autowired
    public armorService(armorRepository armorRepository) {
        this.armorRepository = armorRepository;
    }

    public List<typeArmor> findAll(){
        return this.armorRepository.findAll();
    }

    public typeArmor addArmor(typeArmor armor){
        return this.armorRepository.save(armor);
    }

}
