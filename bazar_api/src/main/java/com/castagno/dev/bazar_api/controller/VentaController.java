package com.castagno.dev.bazar_api.controller;

import com.castagno.dev.bazar_api.dto.ResumenVentasDiaDTO;
import com.castagno.dev.bazar_api.dto.VentaDTO;
import com.castagno.dev.bazar_api.dto.VentaDestacadaDTO;
import com.castagno.dev.bazar_api.service.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/ventas")
public class VentaController {

    @Autowired
    private IVentaService ventaService;

    // GET /api/ventas/traer
    @GetMapping ("/traer")
    public ResponseEntity<List<VentaDTO>> getVentas() {
        return ResponseEntity.ok(ventaService.getVentas());
    }

    // GET /api/ventas/traer/{id}
    @GetMapping("/traer/{id}")
    public ResponseEntity<VentaDTO> getVenta(@PathVariable Long id) {
        return ResponseEntity.ok(ventaService.findVenta(id));
    }

    // POST /api/ventas/crear
    @PostMapping ("/crear")
    public ResponseEntity<VentaDTO> saveVenta(@RequestBody VentaDTO ventaDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ventaService.saveVenta(ventaDTO));
    }

    // PUT /api/ventas/actualizar/{id}
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<VentaDTO> updateVenta(@PathVariable Long id,
                                                @RequestBody VentaDTO ventaDTO) {
        return ResponseEntity.ok(ventaService.updateVenta(id, ventaDTO));
    }

    // DELETE /api/ventas/borrar/{id}
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<Void> deleteVenta(@PathVariable Long id) {
        ventaService.deleteVenta(id);
        return ResponseEntity.noContent().build();
    }
    // GET /api/ventas/resumen-dia?fecha=2025-06-15
    // Devuelve la sumatoria de montos y cantidad de ventas de un día
    @GetMapping("/resumen-dia")
    public ResponseEntity<ResumenVentasDiaDTO> getResumenPorDia(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha) {
        return ResponseEntity.ok(ventaService.getResumenPorDia(fecha));
    }
    // GET /api/ventas/mayor-monto
    // Devuelve la venta con el monto más alto junto a los datos del cliente
    @GetMapping("/mayor-monto")
    public ResponseEntity<VentaDestacadaDTO> getVentaConMayorMonto() {
        return ResponseEntity.ok(ventaService.getVentaConMayorMonto());
    }

}
