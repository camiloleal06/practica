package org.pragma.practica.adaptadores.rest.mapper;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.pragma.practica.adaptadores.rest.dto.ClienteDto;
import org.pragma.practica.adaptadores.rest.dto.PlanDto;
import org.pragma.practica.dominio.modelo.Cliente;
import org.pragma.practica.dominio.modelo.Plan;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PlanMapperTest {

    private final PlanMapper mapper = Mappers.getMapper(PlanMapper.class);

    @Test
    void shouldMapperPlanToDto() {
        Plan plan=new Plan(1, "Fijo", "10M", new BigDecimal(80000));
        PlanDto dto = mapper.toPlanDto(plan);
        assertEquals("Fijo", dto.getDescripcion());
        assertEquals(new BigDecimal(80000), dto.getPrecio());
    }

    @Test
    void shouldMapperDtoToPlan() {
        PlanDto planDto=new PlanDto("Fijo", "10M", new BigDecimal(80000));
        Plan plan = mapper.toPlan(planDto);
        assertEquals("Fijo", plan.getDescripcion());
        assertEquals("10M", plan.getAnchodebanda());
    }
}
