package org.pragma.practica.dominio.puertos;

import org.pragma.practica.dominio.modelo.Cliente;

import java.util.List;

public interface ClientePersistence {
    Cliente findClienteById(Integer id);
    Cliente findClienteByIdentificacion(String identificacion);
    List<Cliente> findAllClientes();
    Cliente saveCliente(Cliente cliente);
}
