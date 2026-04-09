package com.castagno.dev.bazar_api.service;

import com.castagno.dev.bazar_api.model.Venta;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class VentaService implements IVentaService{

    @Override
    public List<Venta> getVentas() {
        return List.of();
    }

    @Override
    public Venta findVenta(Long codigo_venta) {
        return null;
    }

    @Override
    public void saveVenta(Venta venta) {

    }

    @Override
    public void updateVenta(Venta venta) {

    }

    @Override
    public void deleteVenta(Long codigo_venta) {

    }
}
