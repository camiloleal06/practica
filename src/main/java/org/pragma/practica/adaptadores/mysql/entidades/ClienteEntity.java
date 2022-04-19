package org.pragma.practica.adaptadores.mysql.entidades;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "clientes")
public class ClienteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String identificacion;
    private String nombres;
    private String apellidos;
    private String email;
    private String telefono;
    private String direccion;
    private int diaPago;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private PlanEntity plan;
}
