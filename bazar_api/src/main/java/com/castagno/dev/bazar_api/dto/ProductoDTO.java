package com.castagno.dev.bazar_api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductoDTO {

    //detalles producto
    private Long codigo_producto;
    private String nombre;
    private String marca;
    private double precio;
    private double cantidad_disponible;
    //detalle venta
    private Long codigo_venta;


}
