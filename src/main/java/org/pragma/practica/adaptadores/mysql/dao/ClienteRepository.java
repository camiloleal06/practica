package org.pragma.practica.adaptadores.mysql.dao;

import org.pragma.practica.adaptadores.mysql.entidades.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Integer> {
    Optional<ClienteEntity> findByIdentificacion(String identificacion);
}
