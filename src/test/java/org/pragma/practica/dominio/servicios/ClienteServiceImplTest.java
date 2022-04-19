package org.pragma.practica.dominio.servicios;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.pragma.practica.dominio.modelo.Cliente;
import org.pragma.practica.dominio.modelo.Plan;
import org.pragma.practica.dominio.puertos.out_ports.ClientePersistence;
import org.pragma.practica.dominio.puertos.out_ports.PlanPersistence;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ClienteServiceImplTest {

    private final ClientePersistence service = Mockito.mock(ClientePersistence.class);
    ClienteServiceImpl sut = new ClienteServiceImpl(service);
    private final static int ID = 1;
    Cliente cliente = new Cliente();
    List<Cliente> listCliente = List.of(cliente);

    @Test
    void shouldCallServiceFindClienteById() {
        when(service.findClienteById(ID)).thenReturn(cliente);
        assertNotEquals(null, sut.findClienteById(ID));
        verify(service, times(1)).findClienteById(ID);
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
        assertNotNull(sut.updateCliente(cliente,ID));
        verify(service, times(1)).updateCliente(cliente,ID);
    }
}