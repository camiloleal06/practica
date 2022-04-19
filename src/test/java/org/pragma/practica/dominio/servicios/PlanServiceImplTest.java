package org.pragma.practica.dominio.servicios;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.pragma.practica.dominio.modelo.Plan;
import org.pragma.practica.dominio.puertos.out_ports.PlanPersistence;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PlanServiceImplTest {
    private final PlanPersistence planService = Mockito.mock(PlanPersistence.class);
    PlanServiceImpl sut = new PlanServiceImpl(planService);
    private final static int ID = 1;
    private final static String PLAN = "PLAN DUO";
    Plan plan = new Plan();
    List<Plan> listPlan = List.of(plan);

    @Test
    void shouldCallServiceFindPlanById() {
        when(planService.findPlanById(ID)).thenReturn(plan);
        assertNotEquals(null, sut.findPlanById(ID));
        verify(planService, times(1)).findPlanById(ID);
    }

    @Test
    void shouldCallServiceFindAllPlanes() {
        when(planService.findAllPlanes()).thenReturn(listPlan);
        assertFalse(sut.findAllPlanes().isEmpty());
        assertEquals(1, sut.findAllPlanes().size());
        verify(planService, times(2)).findAllPlanes();
    }

    @Test
    void shouldCallServiceSavePlan() {
        when(planService.savePlan(plan)).thenReturn(plan);
        assertNotNull(sut.savePlan(plan));
        verify(planService, times(1)).savePlan(plan);
    }
    @Test
    void shouldCallServiceUpdatePlan() {
        when(planService.updatePlan(plan, ID)).thenReturn(plan);
        assertNotNull(sut.updatePlan(plan,ID));
        verify(planService, times(1)).updatePlan(plan,ID);
    }
}