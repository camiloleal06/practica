package org.pragma.practica.adaptadores.mysql.entidades;

import lombok.*;
import org.pragma.practica.dominio.modelo.Cliente;
import org.springframework.beans.BeanUtils;

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

    public ClienteEntity(Cliente cliente) {
        BeanUtils.copyProperties(cliente, this);
    }

    public Cliente toCliente() {
        var cliente = new Cliente();
        BeanUtils.copyProperties(this, cliente);
        return cliente;
    }

}
