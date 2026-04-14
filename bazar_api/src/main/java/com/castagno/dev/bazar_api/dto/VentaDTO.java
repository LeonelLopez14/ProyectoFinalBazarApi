package com.castagno.dev.bazar_api.dto;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VentaDTO {

    //datos venta
    private Long codigo_venta;
    private LocalDate fechaVenta;
    private Double total;
    //datos productos
    private List<ProductoDTO> listaProductos;
    //datos cliente
    private Long id_cliente;
}
