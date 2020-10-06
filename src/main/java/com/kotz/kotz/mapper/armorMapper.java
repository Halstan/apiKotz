package com.kotz.kotz.mapper;

import com.kotz.kotz.dto.ArmorDTO;
import com.kotz.kotz.entity.TypeArmor;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface armorMapper {

    TypeArmor toArmor(ArmorDTO armorDTO);

    List<ArmorDTO> toArmorDTOs(List<TypeArmor> armors);

    ArmorDTO toArmorDTO(TypeArmor typeArmor);

}
