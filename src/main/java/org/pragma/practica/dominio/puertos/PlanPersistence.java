package org.pragma.practica.dominio.puertos;

import org.pragma.practica.dominio.modelo.Plan;

import java.util.List;

public interface PlanPersistence {

    Plan findPlanById(Integer id);

    List<Plan> findAllPlanes();

    Plan savePlan(Plan plan);

    Plan updatePlan(Plan plan, Integer id);
}
