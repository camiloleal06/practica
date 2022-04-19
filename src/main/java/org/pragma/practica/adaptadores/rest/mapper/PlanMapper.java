package org.pragma.practica.adaptadores.rest.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.pragma.practica.adaptadores.rest.dto.PlanDto;
import org.pragma.practica.dominio.modelo.Plan;

@Mapper(componentModel = "spring")
public interface PlanMapper {

    PlanDto toPlanDto(Plan plan);

    @Mapping(target = "id", ignore = true)
    Plan toPlan(PlanDto planDto);

}