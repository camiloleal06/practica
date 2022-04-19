package org.pragma.practica.adaptadores.mysql.persistencia;

import lombok.AllArgsConstructor;
import org.pragma.practica.adaptadores.mysql.dao.PlanRepository;
import org.pragma.practica.adaptadores.mysql.entidades.PlanEntity;
import org.pragma.practica.dominio.modelo.Plan;
import org.pragma.practica.dominio.puertos.out_ports.PlanPersistence;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class PlanServiceMysql implements PlanPersistence {
    private PlanRepository planRepository;

    @Override
    public Plan findPlanById(Integer id) {
        return planRepository.findById(id).orElseThrow(RuntimeException::new).toPlan();
    }

    @Override
    public List<Plan> findAllPlanes() {
        return planRepository.findAll().stream().map(PlanEntity::toPlan).collect(Collectors.toList());
    }

    @Override
    public Plan savePlan(Plan plan) {
        return planRepository.save(new PlanEntity(plan)).toPlan();
    }

    @Override
    public Plan updatePlan(Plan plan, Integer id) {
        return planRepository.save(new PlanEntity(plan)).toPlan();
    }
}