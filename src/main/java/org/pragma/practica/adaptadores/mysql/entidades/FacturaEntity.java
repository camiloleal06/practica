package org.pragma.practica.adaptadores.mysql.entidades;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
@Getter
@Setter
@ToString
@Entity
@Table(name = "facturas")
public class FacturaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String numeroFactura;
    private LocalDate fecha;
    private boolean estado;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private ClienteEntity cliente;
}
