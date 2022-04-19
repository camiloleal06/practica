package org.pragma.practica.dominio.puertos.out_ports;

import org.pragma.practica.dominio.modelo.Factura;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FacturaPersistence {

    Factura findFacturaById(Integer id);

    List<Factura> findAllFacturas();

    Factura saveFactura(Factura factura);

    Factura updateFactura(Factura factura, Integer id);

}
