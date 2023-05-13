package fr.isep.genielogiciel.mapper;

import java.util.List;
import java.util.stream.Collectors;

public interface EntityToDTOMapper<ENTITY, DTO> {

    DTO toDTO(ENTITY entity);

    default List<DTO> toDTO(List<ENTITY> entities) {
        return entities.stream().map(this::toDTO).collect(Collectors.toList());
    }

}
