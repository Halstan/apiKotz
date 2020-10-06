package com.kotz.kotz.mapper;

import com.kotz.kotz.dto.KnightDTO;
import com.kotz.kotz.entity.Knight;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface knightMapper {

    Knight toKnight(KnightDTO knightDTO);

    List<KnightDTO> toKnightDTOs (List<Knight> Knights);

    KnightDTO toKnightDTO(Knight knight);

}
