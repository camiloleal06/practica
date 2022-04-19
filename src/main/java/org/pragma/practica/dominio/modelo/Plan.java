package org.pragma.practica.dominio.modelo;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Plan {
    private String descripcion;
    private String anchodebanda;
    private int precio;
  }
