package com.kotz.kotz.mapper;

import com.kotz.kotz.dto.knightDTO;
import com.kotz.kotz.entity.knight;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface knightMapper {

    knight toKnight(knightDTO knightDTO);

    List<knightDTO> toKnightDTOs (List<knight> knights);

    knightDTO toKnightDTO(knight knight);

}
