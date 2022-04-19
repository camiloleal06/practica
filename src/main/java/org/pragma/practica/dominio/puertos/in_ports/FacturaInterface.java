package org.pragma.practica.dominio.puertos.in_ports;

import org.pragma.practica.dominio.modelo.Factura;

import java.util.List;


public interface FacturaInterface {

    Factura findFacturaById(Integer id);

    List<Factura> findAllFacturas();

    Factura saveFactura(Factura factura);

    Factura updateFactura(Factura factura, Integer id);

}
