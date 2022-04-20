package org.pragma.practica.adaptadores.rest.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class ClienteDto {
    private String identificacion;
    private String nombres;
    private String apellidos;
    private String email;
    private String telefono;
    private String direccion;
    private int diaPago;
    private int planId;
}