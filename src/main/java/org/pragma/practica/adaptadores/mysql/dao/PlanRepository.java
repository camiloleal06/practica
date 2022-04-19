package org.pragma.practica.adaptadores.mysql.dao;

import org.pragma.practica.adaptadores.mysql.entidades.PlanEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanRepository extends JpaRepository<PlanEntity, Integer> {
}
