package org.pragma.practica.dominio.puertos.out_ports;

import org.pragma.practica.dominio.modelo.Cliente;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientePersistence {
    Cliente findClienteById(Integer id);

    Cliente findClienteByIdentificacion(String identificacion);

    List<Cliente> findAllClientes();

    Cliente saveCliente(Cliente cliente);
}
