package org.pragma.practica.adaptadores.rest;

import lombok.AllArgsConstructor;
import org.pragma.practica.dominio.modelo.Plan;
import org.pragma.practica.dominio.puertos.in_ports.PlanService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/plan")
@AllArgsConstructor
public class PlanController {
    private PlanService planService;

    @GetMapping("/{id}")
    public ResponseEntity<Plan> getPlanById(@PathVariable Integer id) {
        return new ResponseEntity<>(planService.findPlanById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Plan>> getAllPlanes() {
        return new ResponseEntity<>(planService.findAllPlanes(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Plan> createPlan(@RequestBody Plan plan) {
        return new ResponseEntity<>(planService.savePlan(plan), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Plan> updatePlan(@RequestBody Plan plan, Integer id) {
        return new ResponseEntity<>(planService.updatePlan(plan,id), HttpStatus.OK);
    }



}
