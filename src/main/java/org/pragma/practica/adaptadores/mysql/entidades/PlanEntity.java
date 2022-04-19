package org.pragma.practica.adaptadores.mysql.entidades;


import lombok.*;
import org.pragma.practica.dominio.modelo.Plan;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "planes")
public class PlanEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String descripcion;
    private String anchodebanda;
    private int precio;

    public PlanEntity(Plan plan) {
        BeanUtils.copyProperties(plan, this);
    }

    public Plan toPlan() {
        Plan plan = new Plan();
        BeanUtils.copyProperties(this, plan);
        return plan;
    }
}
