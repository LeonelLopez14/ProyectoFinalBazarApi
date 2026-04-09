package com.castagno.dev.bazar_api.service;

import com.castagno.dev.bazar_api.model.Producto;

import java.util.List;

public interface IProductoService {

    //Metodo READ todos los productos
    public List<Producto> getProductos();

    //metodo READ un producto por id
    public Producto findProducto(Long codigo_producto);

    //Metodo CREATE un producto
    public void saveProducto(Producto producto);

    //Metodo UPDATE un producto
    public void updateProducto(Producto producto);

    //Metodo DELETE un producto
    public void deleteProducto(Long codigo_producto);

}
