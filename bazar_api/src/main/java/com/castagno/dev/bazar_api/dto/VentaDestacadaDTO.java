package com.castagno.dev.bazar_api.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VentaDestacadaDTO {

    // Datos de la venta
    private Long codigo_venta;
    private Double total;
    private int cantidadProductos;

    // Datos del cliente
    private String nombreCliente;
    private String apellidoCliente;
}
