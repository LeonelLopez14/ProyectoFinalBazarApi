package com.castagno.dev.bazar_api.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductoDTO {

    //detalles producto
    private Long codigo_producto;
    private String nombre;
    private String marca;
    private double precio;
    private double cantidadDisponible;
    //detalle venta
    private Long codigo_venta;


}
