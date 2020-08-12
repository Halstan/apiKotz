package com.kotz.kotz.mapper;

import com.kotz.kotz.dto.armorDTO;
import com.kotz.kotz.entity.typeArmor;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface armorMapper {

    typeArmor toArmor(armorDTO armorDTO);

    List<armorDTO> toArmorDTOs(List<typeArmor> armors);

    armorDTO toArmorDTO(typeArmor typeArmor);

}
