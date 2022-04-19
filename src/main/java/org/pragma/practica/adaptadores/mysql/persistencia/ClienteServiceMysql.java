package org.pragma.practica.adaptadores.mysql.persistencia;

import java.util.List;
import java.util.stream.Collectors;

import org.pragma.practica.adaptadores.mysql.dao.ClienteRepository;
import org.pragma.practica.adaptadores.mysql.mapper.ClienteEntityMapper;
import org.pragma.practica.dominio.excepciones.ConflictException;
import org.pragma.practica.dominio.excepciones.NotFoundException;
import org.pragma.practica.dominio.modelo.Cliente;
import org.pragma.practica.dominio.puertos.out_ports.ClientePersistence;
import org.springframework.stereotype.Repository;

@Repository
public class ClienteServiceMysql implements ClientePersistence {

    private ClienteRepository clienteRepository;
    private ClienteEntityMapper mapper;

    public ClienteServiceMysql(ClienteRepository clienteRepository, ClienteEntityMapper mapper) {
        this.clienteRepository = clienteRepository;
        this.mapper = mapper;
    }

    private void assertNoExistByEmailOrIdentificacion(String email, String dni) {
        if (this.clienteRepository.findByEmailOrIdentificacion(email, dni).isPresent()) {
            throw new ConflictException("The EMAIL or Identificacion already exists: ");
        }
    }

    @Override
    public Cliente findClienteById(Integer id) {
        return mapper.toCliente(
                clienteRepository.findById(id).orElseThrow(() -> new NotFoundException("No existe el cliente")));

    }

    @Override
    public Cliente findClienteByIdentificacion(String identificacion) {
        return mapper.toCliente(clienteRepository.findByIdentificacion(identificacion).orElseThrow(
                () -> new NotFoundException("No existe el cliente con Identificacion : " + identificacion)));
    }

    @Override
    public List<Cliente> findAllClientes() {
        return clienteRepository.findAll().stream().map(mapper::toCliente).collect(Collectors.toList());
    }

    @Override
    public Cliente saveCliente(Cliente cliente) {
        this.assertNoExistByEmailOrIdentificacion(cliente.getEmail(), cliente.getIdentificacion());
        return mapper.toCliente(clienteRepository.save(mapper.toClienteEntiy(cliente)));
    }

    @Override
    public Cliente updateCliente(Cliente cliente, Integer id) {
        return mapper.toCliente(clienteRepository.save(mapper.toClienteEntiy(cliente)));
    }
}
