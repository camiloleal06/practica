package org.pragma.practica.dominio.servicios;

import lombok.AllArgsConstructor;
import org.pragma.practica.dominio.modelo.Cliente;
import org.pragma.practica.dominio.puertos.in_ports.ClienteService;
import org.pragma.practica.dominio.puertos.out_ports.ClientePersistence;

import java.util.List;

@AllArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private ClientePersistence clientePersistence;

    @Override
    public Cliente findClienteById(Integer id) {
        return clientePersistence.findClienteById(id);
    }

    @Override
    public Cliente findClienteByIdentificacion(String identificacion) {
        return clientePersistence.findClienteByIdentificacion(identificacion);
    }

    @Override
    public List<Cliente> findAllClientes() {
        return clientePersistence.findAllClientes();
    }

    @Override
    public Cliente saveCliente(Cliente cliente) {
        return clientePersistence.saveCliente(cliente);
    }

    @Override
    public Cliente updateCliente(Cliente cliente, Integer id) {
        return clientePersistence.updateCliente(cliente,id);
    }
}