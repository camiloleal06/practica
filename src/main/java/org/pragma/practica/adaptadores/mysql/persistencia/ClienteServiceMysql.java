package org.pragma.practica.adaptadores.mysql.persistencia;

import org.pragma.practica.adaptadores.mysql.dao.ClienteRepository;
import org.pragma.practica.adaptadores.mysql.entidades.ClienteEntity;
import org.pragma.practica.dominio.excepciones.ConflictException;
import org.pragma.practica.dominio.excepciones.NotFoundException;
import org.pragma.practica.dominio.modelo.Cliente;
import org.pragma.practica.dominio.puertos.out_ports.ClientePersistence;

import java.util.List;
import java.util.stream.Collectors;

public class ClienteServiceMysql implements ClientePersistence {

    private final ClienteRepository clienteRepository;

    public ClienteServiceMysql(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    private void assertNoExistByEmailOrIdentificacion(String email, String dni) {
        if (this.clienteRepository.findByEmailOrIdentificacion(email,dni).isPresent()) {
            throw new ConflictException("The EMAIL or Identificacion already exists: ");
        }
      }

    @Override
    public Cliente findClienteById(Integer id) {
        return clienteRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("No existe el cliente")).toCliente();
    }

    @Override
    public Cliente findClienteByIdentificacion(String identificacion) {
        return clienteRepository.findByIdentificacion(identificacion)
                .orElseThrow(()-> new NotFoundException("No existe el cliente con Identificacion : "+identificacion))
                .toCliente();
    }

    @Override
    public List<Cliente> findAllClientes() {
        return clienteRepository.findAll()
                .stream()
                .map(ClienteEntity::toCliente)
                .collect(Collectors.toList());
    }

    @Override
    public Cliente saveCliente(Cliente cliente) {
        this.assertNoExistByEmailOrIdentificacion(cliente.getEmail(), cliente.getIdentificacion());
        return this.clienteRepository.save(new ClienteEntity(cliente)).toCliente();
    }

    @Override
    public Cliente updateCliente(Cliente cliente, Integer id) {
        return this.clienteRepository.save(new ClienteEntity(cliente)).toCliente();
    }
}
