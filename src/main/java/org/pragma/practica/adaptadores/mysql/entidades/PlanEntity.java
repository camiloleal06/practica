package org.pragma.practica.adaptadores.mysql.entidades;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.pragma.practica.dominio.modelo.Plan;
import org.springframework.beans.BeanUtils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.var;

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
    private BigDecimal precio;

    public PlanEntity(Plan plan) {
        BeanUtils.copyProperties(plan, this);
    }

    public Plan toPlan() {
        var plan = new Plan();
        BeanUtils.copyProperties(this, plan);
        return plan;
    }
}
