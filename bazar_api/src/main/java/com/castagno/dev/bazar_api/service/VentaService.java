package com.castagno.dev.bazar_api.service;

import com.castagno.dev.bazar_api.dto.VentaDTO;
import com.castagno.dev.bazar_api.mapper.Mapper;
import com.castagno.dev.bazar_api.model.Cliente;
import com.castagno.dev.bazar_api.model.Producto;
import com.castagno.dev.bazar_api.model.Venta;
import com.castagno.dev.bazar_api.repository.IClienteRepository;
import com.castagno.dev.bazar_api.repository.IProductoRepository;
import com.castagno.dev.bazar_api.repository.IVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class VentaService implements IVentaService{

    @Autowired
    private IVentaRepository ventaRepository;

    @Autowired
    private IProductoRepository productoRepository;

    @Autowired
    private IClienteRepository clienteRepository;

    @Override
    public List<VentaDTO> getVentas() {
        return List.of();
    }

    @Override
    public VentaDTO findVenta(Long codigo_venta) {
        return null;
    }

    @Override
    public VentaDTO saveVenta(VentaDTO ventaDto) {
        Venta venta = new Venta();
        venta.setFecha_venta(ventaDto.getFecha_venta());

        // Traer los productos desde el repo usando los Id del DTO
        List<Producto> productos = ventaDto.getListaProductos().stream()
                .map(p -> productoRepository.findById(p.getCodigo_producto())
                        .orElseThrow(() -> new RuntimeException("producto no encontrado")))
        .toList();

        //asociar la venta a cada producto
        productos.forEach(p -> p.setVenta(venta));
        venta.setListaProductos(productos);

        //calcular el total de la venta
        double total = productos.stream()
                .mapToDouble(Producto::getPrecio)
                .sum();
        venta.setTotal(total);

        //traer y asignar cliente
        Cliente cliente = clienteRepository.findById(ventaDto.getId_cliente())
                .orElseThrow(() -> new RuntimeException("cliente no encontrado"));
        venta.setUnCliente(cliente);

        return Mapper.toDTO(ventaRepository.save(venta));
    }

    @Override
    public VentaDTO updateVenta(Long codigo_venta, VentaDTO ventaDto) {
        return null;
    }

    @Override
    public void deleteVenta(Long codigo_venta) {

    }
}
