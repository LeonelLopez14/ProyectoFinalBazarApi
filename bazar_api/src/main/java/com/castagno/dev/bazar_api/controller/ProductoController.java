package com.castagno.dev.bazar_api.controller;

import com.castagno.dev.bazar_api.dto.ProductoDTO;
import com.castagno.dev.bazar_api.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private IProductoService productoService;

    // GET /api/productos/traer
    @GetMapping ("/traer")
    public ResponseEntity<List<ProductoDTO>> getProductos() {
        return ResponseEntity.ok(productoService.getProductos());
    }

    // GET /api/productos/traer/{id}
    @GetMapping("/traer/{id}")
    public ResponseEntity<ProductoDTO> getProducto(@PathVariable Long id) {
        return ResponseEntity.ok(productoService.findProducto(id));
    }

    // POST /api/productos/crear
    @PostMapping ("/crear")
    public ResponseEntity<ProductoDTO> saveProducto(@RequestBody ProductoDTO productoDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productoService.saveProducto(productoDTO));
    }

    // PUT /api/productos/actualizar/{id}
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<ProductoDTO> updateProducto(@PathVariable Long id,
                                                      @RequestBody ProductoDTO productoDTO) {
        return ResponseEntity.ok(productoService.updateProducto(id, productoDTO));
    }

    // DELETE /api/productos/borrar/{id}
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<Void> deleteProducto(@PathVariable Long id) {
        productoService.deleteProducto(id);
        return ResponseEntity.noContent().build();
    }

    // GET /api/productos/stock-bajo
    // Trae todos los productos con cantidad_disponible < 5
    @GetMapping("/stock-bajo")
    public ResponseEntity<List<ProductoDTO>> getProductosConStockBajo() {
        return ResponseEntity.ok(productoService.getProductosConStockBajo());
    }

    // GET /api/productos/venta/{codigoVenta}
    // Trae todos los productos de una venta específica
    @GetMapping("/venta/{codigoVenta}")
    public ResponseEntity<List<ProductoDTO>> getProductosByVenta(@PathVariable Long codigoVenta) {
        return ResponseEntity.ok(productoService.getProductosByVenta(codigoVenta));
    }
}
