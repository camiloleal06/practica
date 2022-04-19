package org.pragma.practica.adaptadores.rest.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.pragma.practica.adaptadores.rest.dto.ClienteDto;
import org.pragma.practica.dominio.modelo.Cliente;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    @Mapping(source = "plan.id", target = "planId")
    ClienteDto toClienteDto(Cliente cliente);

    @Mapping(target = "plan.id", source = "clienteDto.planId")
    @Mapping(target = "id", ignore = true)
    Cliente toCliente(ClienteDto clienteDto);

}