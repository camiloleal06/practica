package org.pragma.practica.dominio.modelo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Cliente {
    private String identificacion;
    private String nombres;
    private String apellidos;
    private String email;
    private String telefono;
    private String direccion;
    private int diaPago;
    private Plan plan;
}
