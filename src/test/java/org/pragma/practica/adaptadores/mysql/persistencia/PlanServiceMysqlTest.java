package org.pragma.practica.adaptadores.mysql.persistencia;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.pragma.practica.adaptadores.mysql.dao.PlanRepository;
import org.pragma.practica.adaptadores.mysql.entidades.PlanEntity;
import org.pragma.practica.adaptadores.mysql.mapper.PlanEntityMapper;
import org.pragma.practica.dominio.modelo.Plan;


import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.timeout;

@ExtendWith(MockitoExtension.class)
class PlanServiceMysqlTest {

    PlanRepository planRepository= mock(PlanRepository.class);
    PlanEntityMapper mapper = Mappers.getMapper(PlanEntityMapper.class);
    PlanServiceMysql service = new PlanServiceMysql(planRepository,mapper);

    @Test
    void shouldfindByAllPlanesTest() {
        //Given
        PlanEntity planEntity = new PlanEntity(1,"Plan","10M", new BigDecimal(50000));
        given(planRepository.findAll()).willReturn(List.of(planEntity));
        //When
        List<Plan> foundPlan = service.findAllPlanes();
        //Then
        assertThat(foundPlan).isNotNull();
        assertThat(foundPlan.get(0).getId()).isEqualTo(1);
        assertThat(foundPlan.get(0).getPrecio()).isEqualTo(new BigDecimal(50000));
        then(planRepository).should(timeout(100)).findAll();
        then(planRepository).shouldHaveNoMoreInteractions();
    }

    @Test
    void shouldfindPlanByIdTest() {
        //Given
        PlanEntity planEntity = new PlanEntity(1,"Plan","10M", new BigDecimal(50000));
        given(planRepository.findById(1)).willReturn(Optional.of(planEntity));
        //When
        Plan foundPlan = service.findPlanById(1);
        //Then
        assertThat(foundPlan).isNotNull();
        assertThat(foundPlan.getAnchodebanda()).isEqualTo("10M");
        assertEquals("Plan", foundPlan.getDescripcion());
        then(planRepository).should(timeout(100)).findById(1);
        then(planRepository).shouldHaveNoMoreInteractions();
    }
 }