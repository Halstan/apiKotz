package com.kotz.kotz.mapper;

import com.kotz.kotz.dto.GodDTO;
import com.kotz.kotz.entity.God;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface godMapper {

    God toGod(GodDTO godDTO);

    List<GodDTO> toGodDTOs(List<God> Gods);

    GodDTO toGodDTO(God god);

}
