package com.kotz.kotz.mapper;

import com.kotz.kotz.dto.godDTO;
import com.kotz.kotz.dto.knightDTO;
import com.kotz.kotz.entity.god;
import com.kotz.kotz.entity.knight;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface godMapper {

    god toGod(godDTO godDTO);

    List<godDTO> toGodDTOs(List<god> gods);

    godDTO toGodDTO(god god);

}
