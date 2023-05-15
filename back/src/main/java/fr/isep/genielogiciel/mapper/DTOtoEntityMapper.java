package fr.isep.genielogiciel.mapper;

import java.util.List;
import java.util.stream.Collectors;

public interface DTOtoEntityMapper<ENTITY, DTO> {

    ENTITY toEntity(DTO dto);

    default List<ENTITY> toEntity(List<DTO> dtos){
        return dtos.stream().map(this::toEntity).collect(Collectors.toList());
    }

}
