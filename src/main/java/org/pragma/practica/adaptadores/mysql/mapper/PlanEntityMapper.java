package org.pragma.practica.adaptadores.mysql.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.pragma.practica.adaptadores.mysql.entidades.PlanEntity;
import org.pragma.practica.dominio.modelo.Plan;

@Mapper(componentModel = "spring",uses = PlanEntityMapper.class, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface PlanEntityMapper {

    PlanEntity toPlanEntiy(Plan plan);

    Plan toPlan(PlanEntity planEntity);
}