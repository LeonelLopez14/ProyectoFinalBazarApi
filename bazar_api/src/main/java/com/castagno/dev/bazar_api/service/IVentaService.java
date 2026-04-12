package com.castagno.dev.bazar_api.service;

import com.castagno.dev.bazar_api.dto.VentaDTO;
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

}
