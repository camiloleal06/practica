package org.pragma.practica.adaptadores.mysql.persistencia;

import java.util.List;
import java.util.stream.Collectors;

import org.pragma.practica.adaptadores.mysql.dao.PlanRepository;
import org.pragma.practica.adaptadores.mysql.mapper.PlanEntityMapper;
import org.pragma.practica.dominio.excepciones.NotFoundException;
import org.pragma.practica.dominio.modelo.Plan;
import org.pragma.practica.dominio.puertos.out_ports.PlanPersistence;
import org.springframework.stereotype.Repository;

@Repository
public class PlanServiceMysql implements PlanPersistence {

    private PlanRepository planRepository;
    private PlanEntityMapper mapper;

    public PlanServiceMysql(PlanRepository planRepository, PlanEntityMapper mapper) {
        this.planRepository = planRepository;
        this.mapper = mapper;
    }

    @Override
    public Plan findPlanById(Integer id) {
        return mapper.toPlan(planRepository.findById(id).orElseThrow(() -> new NotFoundException("No Existe el plan")));
    }

    @Override
    public List<Plan> findAllPlanes() {
        return planRepository.findAll().stream().map(mapper::toPlan).collect(Collectors.toList());
    }

    @Override
    public Plan savePlan(Plan plan) {
        return mapper.toPlan(planRepository.save(mapper.toPlanEntiy(plan)));
    }

    @Override
    public Plan updatePlan(Plan plan, Integer id) {
        return mapper.toPlan(planRepository.save(mapper.toPlanEntiy(plan)));
    }
}