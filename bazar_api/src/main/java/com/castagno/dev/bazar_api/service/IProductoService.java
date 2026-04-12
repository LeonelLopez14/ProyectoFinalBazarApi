package com.castagno.dev.bazar_api.service;

import com.castagno.dev.bazar_api.dto.ProductoDTO;

import java.util.List;

public interface IProductoService {

    //Metodo READ todos los productos
    public List<ProductoDTO> getProductos();

    //metodo READ un producto por id
    public ProductoDTO findProducto(Long codigo_producto);

    //Metodo CREATE un producto
    public ProductoDTO saveProducto(ProductoDTO productoDto);

    //Metodo UPDATE un producto
    public ProductoDTO updateProducto(Long codigo_producto,ProductoDTO productoDto);

    //Metodo DELETE un producto
    public void deleteProducto(Long codigo_producto);

}
