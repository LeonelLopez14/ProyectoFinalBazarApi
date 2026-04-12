package com.castagno.dev.bazar_api.service;

import com.castagno.dev.bazar_api.dto.ProductoDTO;
import com.castagno.dev.bazar_api.mapper.Mapper;
import com.castagno.dev.bazar_api.repository.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService implements IProductoService{

    @Autowired
    private IProductoRepository productoRepository;

    @Override
    public List<ProductoDTO> getProductos() {
        return productoRepository.findAll().stream().map(Mapper::toDTO).toList();
    }

    @Override
    public ProductoDTO findProducto(Long codigo_producto) {
        return null;
    }

    @Override
    public ProductoDTO saveProducto(ProductoDTO productoDto) {
        return null;
    }

    @Override
    public ProductoDTO updateProducto(Long codigo_producto, ProductoDTO productoDto) {
        return null;
    }

    @Override
    public void deleteProducto(Long codigo_producto) {

    }
}
