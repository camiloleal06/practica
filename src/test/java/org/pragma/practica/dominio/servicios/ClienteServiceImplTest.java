package org.pragma.practica.dominio.servicios;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.pragma.practica.dominio.modelo.Cliente;
import org.pragma.practica.dominio.puertos.out_ports.ClientePersistence;

class ClienteServiceImplTest {

    private final ClientePersistence service = Mockito.mock(ClientePersistence.class);
    ClienteServiceImpl sut = new ClienteServiceImpl(service);
    private final static int ID = 1;
    private final static String IDENTIFICACION = "73207639";
    Cliente cliente = new Cliente();
    List<Cliente> listCliente = List.of(cliente);

    @Test
    void shouldCallServiceFindClienteById() {
        when(service.findClienteById(ID)).thenReturn(cliente);
        assertNotEquals(null, sut.findClienteById(ID));
        verify(service, times(1)).findClienteById(ID);
    }

    @Test
    void shouldCallServiceFindClienteByIdentificacion() {
        when(service.findClienteByIdentificacion(IDENTIFICACION)).thenReturn(cliente);
        assertNotEquals(null, sut.findClienteByIdentificacion(IDENTIFICACION));
        verify(service, times(1)).findClienteByIdentificacion(IDENTIFICACION);
    }

    @Test
    void shouldCallServiceFindAllClientes() {
        when(service.findAllClientes()).thenReturn(listCliente);
        assertFalse(sut.findAllClientes().isEmpty());
        assertEquals(1, sut.findAllClientes().size());
        verify(service, times(2)).findAllClientes();
    }

    @Test
    void shouldCallServiceSaveCliente() {
        when(service.saveCliente(cliente)).thenReturn(cliente);
        assertNotNull(sut.saveCliente(cliente));
        verify(service, times(1)).saveCliente(cliente);
    }

    @Test
    void shouldCallServiceUpdateCliente() {
        when(service.updateCliente(cliente, ID)).thenReturn(cliente);
        assertNotNull(sut.updateCliente(cliente, ID));
        verify(service, times(1)).updateCliente(cliente, ID);
    }
}