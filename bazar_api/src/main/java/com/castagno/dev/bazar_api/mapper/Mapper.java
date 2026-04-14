package com.castagno.dev.bazar_api.mapper;

import com.castagno.dev.bazar_api.dto.ClienteDTO;
import com.castagno.dev.bazar_api.dto.ProductoDTO;
import com.castagno.dev.bazar_api.dto.VentaDTO;
import com.castagno.dev.bazar_api.model.Cliente;
import com.castagno.dev.bazar_api.model.Producto;
import com.castagno.dev.bazar_api.model.Venta;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Mapper {

    //Mapeo de Producto a ProductoDTO
    public static ProductoDTO toDTO(Producto p) {
        if (p == null) return null;

        return ProductoDTO.builder()
                .codigo_producto(p.getCodigo_producto())
                .nombre(p.getNombre())
                .marca(p.getMarca())
                .precio(p.getPrecio())
                .cantidadDisponible(p.getCantidadDisponible())
                .codigo_venta(p.getVenta() != null ? p.getVenta().getCodigo_venta() : null)
                .build();
    }

    //Mapeo de Venta a VentaDTO
    public static VentaDTO toDTO(Venta v) {
        if (v == null) return null;

        return VentaDTO.builder()
                .codigo_venta(v.getCodigo_venta())
                .fechaVenta(v.getFechaVenta())
                .total(v.getTotal())
                .listaProductos(
                        v.getListaProductos() != null
                                ? v.getListaProductos().stream()
                                  .map(Mapper::toDTO)
                                  .collect(Collectors.toList())
                                : new ArrayList<>()
                )
                .id_cliente(v.getUnCliente() != null ? v.getUnCliente().getId_cliente() : null)
                .build();
    }

    //Mapeo de Cliente a ClienteDTO
    public static ClienteDTO toDTO(Cliente c) {
        if (c == null) return null;

        return ClienteDTO.builder()
                .id_cliente(c.getId_cliente())
                .nombre(c.getNombre())
                .apellido(c.getApellido())
                .dni(c.getDni())
                .build();
    }


}
