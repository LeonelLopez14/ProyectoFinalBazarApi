package com.castagno.dev.bazar_api.service;

import com.castagno.dev.bazar_api.dto.ResumenVentasDiaDTO;
import com.castagno.dev.bazar_api.dto.VentaDTO;
import com.castagno.dev.bazar_api.dto.VentaDestacadaDTO;

import java.time.LocalDate;
import java.util.List;

public interface IVentaService {

    //Metodo READ todas las ventas
    public List<VentaDTO> getVentas();

    //metodo READ una venta por id
    public VentaDTO findVenta(Long codigo_venta);

    //Metodo CREATE una venta
    public VentaDTO saveVenta(VentaDTO ventaDto);

    //Metodo UPDATE una venta
    public VentaDTO  updateVenta(Long codigo_venta, VentaDTO ventaDto);

    //Metodo DELETE una venta
    public void deleteVenta(Long codigo_venta);

    // Sumatoria de monto y cantidad de ventas de un día
    ResumenVentasDiaDTO getResumenPorDia(LocalDate fechaVenta);

    // Venta con el monto más alto (con datos del cliente)
    VentaDestacadaDTO getVentaConMayorMonto();



}
