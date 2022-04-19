package org.pragma.practica.dominio.servicios;

import org.pragma.practica.dominio.modelo.Plan;
import org.pragma.practica.dominio.puertos.in_ports.PlanInterface;
import org.pragma.practica.dominio.puertos.out_ports.PlanPersistence;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanServiceImpl implements PlanInterface {

    private final PlanPersistence planPersistence;

    public PlanServiceImpl(PlanPersistence planPersistence) {
        this.planPersistence = planPersistence;
    }

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
