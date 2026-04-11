package com.castagno.dev.bazar_api.dto;

import com.castagno.dev.bazar_api.model.Cliente;
import com.castagno.dev.bazar_api.model.Producto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class VentaDTO {

    //datos venta
    private Long codigo_venta;
    private LocalDate fecha_venta;
    private Double total;
    //datos productos
    private List<Producto> listaProductos;
    //datos cliente
    private Long id_cliente;
}
