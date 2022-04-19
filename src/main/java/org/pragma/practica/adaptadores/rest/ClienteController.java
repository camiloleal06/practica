package org.pragma.practica.adaptadores.rest;

import java.util.List;

import org.pragma.practica.adaptadores.rest.dto.ClienteDto;
import org.pragma.practica.adaptadores.rest.mapper.ClienteMapper;
import org.pragma.practica.dominio.modelo.Cliente;
import org.pragma.practica.dominio.puertos.in_ports.ClienteInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/cliente")
public class ClienteController {

    private final ClienteInterface clienteInterface;
    private final ClienteMapper clienteMapper;

    public ClienteController(ClienteInterface clienteInterface, ClienteMapper clienteMapper) {
        this.clienteInterface = clienteInterface;
        this.clienteMapper = clienteMapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDto> getClienteById(@PathVariable Integer id) {
        return new ResponseEntity<>(clienteMapper.toClienteDto(clienteInterface.findClienteById(id)), HttpStatus.OK);
    }

    @GetMapping("/identificacion/{identificacion}")
    public ResponseEntity<Cliente> getClienteByIdentificacion(@PathVariable String identificacion) {
        return new ResponseEntity<>(clienteInterface.findClienteByIdentificacion(identificacion), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> getAllClientes() {
        return new ResponseEntity<>(clienteInterface.findAllClientes(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Cliente> createCliente(@RequestBody ClienteDto clienteDto) {
        return new ResponseEntity<>(clienteInterface.saveCliente(clienteMapper.toCliente(clienteDto)),
                HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> updateCliente(@RequestBody Cliente cliente, Integer id) {
        return new ResponseEntity<>(clienteInterface.updateCliente(cliente, id), HttpStatus.OK);
    }

}
