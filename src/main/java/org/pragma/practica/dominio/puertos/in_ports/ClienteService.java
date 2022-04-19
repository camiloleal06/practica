package org.pragma.practica.dominio.puertos.in_ports;

import org.pragma.practica.dominio.modelo.Cliente;

import java.util.List;


public interface ClienteService {
    Cliente findClienteById(Integer id);

    Cliente findClienteByIdentificacion(String identificacion);

    List<Cliente> findAllClientes();

    Cliente saveCliente(Cliente cliente);

    Cliente updateCliente(Cliente cliente, Integer id);
}
