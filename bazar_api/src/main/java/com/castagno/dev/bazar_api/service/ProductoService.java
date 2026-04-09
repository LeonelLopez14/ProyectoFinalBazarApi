package com.castagno.dev.bazar_api.service;

import com.castagno.dev.bazar_api.model.Producto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService implements IProductoService{

    @Override
    public List<Producto> getProductos() {
        return List.of();
    }

    @Override
    public Producto findProducto(Long codigo_producto) {
        return null;
    }

    @Override
    public void saveProducto(Producto producto) {

    }

    @Override
    public void updateProducto(Producto producto) {

    }

    @Override
    public void deleteProducto(Long codigo_producto) {

    }
}
