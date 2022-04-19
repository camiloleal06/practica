package org.pragma.practica.dominio.puertos.out_ports;

import org.pragma.practica.dominio.modelo.Plan;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlanPersistence {

    Plan findPlanById(Integer id);

    List<Plan> findAllPlanes();

    Plan savePlan(Plan plan);

    Plan updatePlan(Plan plan, Integer id);
}
