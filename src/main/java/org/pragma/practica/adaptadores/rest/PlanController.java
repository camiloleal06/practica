package org.pragma.practica.adaptadores.rest;

import lombok.AllArgsConstructor;
import org.pragma.practica.dominio.modelo.Plan;
import org.pragma.practica.dominio.puertos.in_ports.PlanService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/plan")
@AllArgsConstructor
public class PlanController {
    private PlanService planService;

    @GetMapping("/{id}")
    public ResponseEntity<Plan> getPlanById(@PathVariable Integer id) {
        return new ResponseEntity<>(planService.findPlanById(id), HttpStatus.OK);
    }


}
