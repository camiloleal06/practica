package org.pragma.practica.adaptadores.rest.mapper;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.pragma.practica.adaptadores.rest.dto.ClienteDto;
import org.pragma.practica.adaptadores.rest.mapper.ClienteMapper;
import org.pragma.practica.dominio.modelo.Cliente;
import org.pragma.practica.dominio.modelo.Plan;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ClienteMapperTest {

    private final ClienteMapper mapper = Mappers.getMapper(ClienteMapper.class);

    @Test
    void shouldMapperClienteToDto() {

        Cliente cliente = new Cliente();
        cliente.setNombres("Camilo");
        cliente.setApellidos("Leal");
        cliente.setEmail("camilo.leal@pragma.com.co");
        cliente.setDireccion("Cartagena");
        cliente.setIdentificacion("73207639");
        cliente.setDiaPago(10);
        cliente.setTelefono("3225996394");
        cliente.setPlan(new Plan(1, "Fijo", "10M", new BigDecimal(80000)));
        ClienteDto dto = mapper.toClienteDto(cliente);
        assertEquals("Camilo", dto.getNombres());
        assertEquals(1, dto.getPlanId());
        assertEquals(cliente.getEmail(), dto.getEmail());
    }

    @Test
    void shouldMapperDtoToCliente() {

        ClienteDto clienteDto = new ClienteDto();
        clienteDto.setNombres("Camilo");
        clienteDto.setApellidos("Leal");
        clienteDto.setEmail("camilo.leal@pragma.com.co");
        clienteDto.setDireccion("Cartagena");
        clienteDto.setIdentificacion("73207639");
        clienteDto.setDiaPago(10);
        clienteDto.setTelefono("3225996394");
        clienteDto.setPlanId(1);
        Cliente cliente = mapper.toCliente(clienteDto);
        assertEquals("Camilo", cliente.getNombres());
        assertEquals(1,cliente.getPlan().getId());
        assertEquals(clienteDto.getEmail(), cliente.getEmail());
    }
}
