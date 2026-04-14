package com.castagno.dev.bazar_api.service;

import com.castagno.dev.bazar_api.dto.VentaDTO;
import com.castagno.dev.bazar_api.exception.NotFoundException;
import com.castagno.dev.bazar_api.mapper.Mapper;
import com.castagno.dev.bazar_api.model.Cliente;
import com.castagno.dev.bazar_api.model.Producto;
import com.castagno.dev.bazar_api.model.Venta;
import com.castagno.dev.bazar_api.repository.IClienteRepository;
import com.castagno.dev.bazar_api.repository.IProductoRepository;
import com.castagno.dev.bazar_api.repository.IVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

        return ventaRepository.findAll().stream().map(Mapper::toDTO).toList();
    }

    @Override
    public VentaDTO findVenta(Long codigo_venta) {

        Venta venta = ventaRepository.findById(codigo_venta)
                .orElseThrow(() -> new NotFoundException("No existe la venta con el id: " + codigo_venta));

        return Mapper.toDTO(venta);
    }

    @Override
    public VentaDTO saveVenta(VentaDTO ventaDto) {
        Venta venta = new Venta();
        venta.setFecha_venta(ventaDto.getFecha_venta());
        asignarProductosYCliente(venta, ventaDto);
        return Mapper.toDTO(ventaRepository.save(venta));
    }

    @Override
    public VentaDTO updateVenta(Long codigo_venta, VentaDTO ventaDto) {
        //checkeo si existe el id en BD
        Venta venta = ventaRepository.findById(codigo_venta)
                .orElseThrow((() -> new NotFoundException("Venta no encontrada")));
        venta.setFecha_venta(ventaDto.getFecha_venta());
        asignarProductosYCliente(venta, ventaDto);
        return Mapper.toDTO(ventaRepository.save(venta));
    }

    @Override
    public void deleteVenta(Long codigo_venta) {
        //checkeo si existe el id en BD
        if (!ventaRepository.existsById(codigo_venta)) {
            throw new NotFoundException("Producto no encontrado");
        }
        ventaRepository.deleteById(codigo_venta);
    }

    private void asignarProductosYCliente(Venta venta, VentaDTO ventaDto) {
        List<Producto> productos = ventaDto.getListaProductos()
                .stream()
                .map(p -> productoRepository.findById(p.getCodigo_producto())
                        .orElseThrow(() -> new RuntimeException("Producto no encontrado")))
                .toList();

        productos.forEach(p -> p.setVenta(venta));
        venta.setListaProductos(productos);

        double total = productos.stream()
                .mapToDouble(Producto::getPrecio)
                .sum();
        venta.setTotal(total);

        Cliente cliente = clienteRepository.findById(ventaDto.getId_cliente())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        venta.setUnCliente(cliente);
    }
}
