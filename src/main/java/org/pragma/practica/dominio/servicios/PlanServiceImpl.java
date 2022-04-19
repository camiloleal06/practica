package org.pragma.practica.dominio.servicios;

import lombok.AllArgsConstructor;
import org.pragma.practica.dominio.modelo.Plan;
import org.pragma.practica.dominio.puertos.in_ports.PlanService;
import org.pragma.practica.dominio.puertos.out_ports.PlanPersistence;

import java.util.List;

@AllArgsConstructor
public class PlanServiceImpl implements PlanService {

    private PlanPersistence planPersistence;

    @Override
    public Plan findPlanById(Integer id) {
        return planPersistence.findPlanById(id);
    }

    @Override
    public List<Plan> findAllPlanes() {
        return planPersistence.findAllPlanes();
    }

    @Override
    public Plan savePlan(Plan plan) {
        return planPersistence.savePlan(plan);
    }

    @Override
    public Plan updatePlan(Plan plan, Integer id) {
        return planPersistence.updatePlan(plan, id);
    }
}
