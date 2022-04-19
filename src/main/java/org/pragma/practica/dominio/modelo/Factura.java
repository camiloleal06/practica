package org.pragma.practica.dominio.modelo;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Factura {
    private Integer id;
    private String numeroFactura;
    private LocalDate fecha;
    private boolean estado;
    private Cliente cliente;
}
