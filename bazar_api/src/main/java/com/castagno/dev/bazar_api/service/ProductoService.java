package com.castagno.dev.bazar_api.service;

import com.castagno.dev.bazar_api.dto.ProductoDTO;
import com.castagno.dev.bazar_api.exception.NotFoundException;
import com.castagno.dev.bazar_api.mapper.Mapper;
import com.castagno.dev.bazar_api.model.Producto;
import com.castagno.dev.bazar_api.model.Venta;
import com.castagno.dev.bazar_api.repository.IProductoRepository;
import com.castagno.dev.bazar_api.repository.IVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService implements IProductoService{

    @Autowired
    private IProductoRepository productoRepository;

    @Autowired
    private IVentaRepository ventaRepository;

    @Override
    public List<ProductoDTO> getProductos() {
        return productoRepository.findAll().stream().map(Mapper::toDTO).toList();
    }

    @Override
    public ProductoDTO findProducto(Long codigo_producto) {
        //checke eno si existe el id en BD
        Producto producto = productoRepository.findById(codigo_producto)
                .orElseThrow(() -> new NotFoundException("No existe el producto con el id: " + codigo_producto));

        return Mapper.toDTO(producto);
    }

    @Override
    public ProductoDTO saveProducto(ProductoDTO productoDto) {

        //checkeo si viene con venta asignada, si es asi la busco y asigno al producto
        Venta venta = null;
        if (productoDto.getCodigo_venta() != null) {
            venta = ventaRepository.findById(productoDto.getCodigo_venta())
                    .orElseThrow(() -> new NotFoundException("Venta no encontrada"));
        }

        //asigno los datos del DTO al producto
        Producto producto = Producto.builder()
                .nombre(productoDto.getNombre())
                .marca(productoDto.getMarca())
                .precio(productoDto.getPrecio())
                .cantidad_disponible(productoDto.getCantidad_disponible())
                .venta(venta)
                .build();

        return Mapper.toDTO(productoRepository.save(producto));
    }

    @Override
    public ProductoDTO updateProducto(Long codigo_producto, ProductoDTO productoDto) {
         //checkeo si existe el id en BD
        Producto producto = productoRepository.findById(codigo_producto)
                .orElseThrow(() -> new NotFoundException("Producto no encontrado"));

        // Actualizo los campos con los datos nuevos
        producto.setNombre(productoDto.getNombre());
        producto.setMarca(productoDto.getMarca());
        producto.setPrecio(productoDto.getPrecio());
        producto.setCantidad_disponible(productoDto.getCantidad_disponible());

        // Si viene con venta asignada, la busco y asigno
        if (productoDto.getCodigo_venta() != null) {
            Venta venta = ventaRepository.findById(productoDto.getCodigo_venta())
                    .orElseThrow(() -> new RuntimeException("Venta no encontrada"));
            producto.setVenta(venta);
        }

        return Mapper.toDTO(productoRepository.save(producto));
    }

    @Override
    public void deleteProducto(Long codigo_producto) {
    //checkeo si existe el id en BD
        if (!productoRepository.existsById(codigo_producto)) {
            throw new NotFoundException("Producto no encontrado");
        }
        productoRepository.deleteById(codigo_producto);
    }
}
