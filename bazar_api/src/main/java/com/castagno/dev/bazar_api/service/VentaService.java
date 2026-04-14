package com.castagno.dev.bazar_api.service;

import com.castagno.dev.bazar_api.dto.ResumenVentasDiaDTO;
import com.castagno.dev.bazar_api.dto.VentaDTO;
import com.castagno.dev.bazar_api.dto.VentaDestacadaDTO;
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

import java.time.LocalDate;
import java.util.List;


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
        venta.setFechaVenta(ventaDto.getFechaVenta());
        asignarProductosYCliente(venta, ventaDto);
        return Mapper.toDTO(ventaRepository.save(venta));
    }

    @Override
    public VentaDTO updateVenta(Long codigo_venta, VentaDTO ventaDto) {
        //checkeo si existe el id en BD
        Venta venta = ventaRepository.findById(codigo_venta)
                .orElseThrow((() -> new NotFoundException("Venta no encontrada")));
        venta.setFechaVenta(ventaDto.getFechaVenta());
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
    @Override
    public ResumenVentasDiaDTO getResumenPorDia(LocalDate fecha) {
        List<Venta> ventasDelDia = ventaRepository.findByFechaVenta(fecha);

        long cantidad = ventasDelDia.size();
        double sumatoria = ventasDelDia.stream()
                .mapToDouble(Venta::getTotal)
                .sum();

        return ResumenVentasDiaDTO.builder()
                .fecha(fecha)
                .cantidadVentas(cantidad)
                .montoTotal(sumatoria)
                .build();
    }

    @Override
    public VentaDestacadaDTO getVentaConMayorMonto() {
        Venta venta = ventaRepository.findVentaConMayorTotal()
                .orElseThrow(() -> new NotFoundException("No hay ventas registradas"));

        return VentaDestacadaDTO.builder()
                .codigo_venta(venta.getCodigo_venta())
                .total(venta.getTotal())
                .cantidadProductos(venta.getListaProductos().size())
                .nombreCliente(venta.getUnCliente().getNombre())
                .apellidoCliente(venta.getUnCliente().getApellido())
                .build();
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
