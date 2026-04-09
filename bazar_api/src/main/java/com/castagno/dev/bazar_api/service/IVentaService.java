package com.castagno.dev.bazar_api.service;

import com.castagno.dev.bazar_api.model.Venta;
import java.util.List;

public interface IVentaService {

    //Metodo READ todas las ventas
    public List<Venta> getVentas();

    //metodo READ una venta por id
    public Venta findVenta(Long codigo_venta);

    //Metodo CREATE una venta
    public void saveVenta(Venta venta);

    //Metodo UPDATE una venta
    public void  updateVenta(Venta venta);

    //Metodo DELETE una venta
    public void deleteVenta(Long codigo_venta);

}
