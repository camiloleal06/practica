package org.pragma.practica.adaptadores.mysql.mapper;

import org.mapstruct.Mapper;
import org.pragma.practica.adaptadores.mysql.entidades.ClienteEntity;
import org.pragma.practica.dominio.modelo.Cliente;

@Mapper(componentModel = "spring")
public interface ClienteEntityMapper {

    ClienteEntity toClienteEntiy(Cliente cliente);

    Cliente toCliente(ClienteEntity clienteEntity);
}