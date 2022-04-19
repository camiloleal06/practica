package org.pragma.practica.dominio.modelo;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Plan {
    private Integer id;
    private String descripcion;
    private String anchodebanda;
    private BigDecimal precio;
}
