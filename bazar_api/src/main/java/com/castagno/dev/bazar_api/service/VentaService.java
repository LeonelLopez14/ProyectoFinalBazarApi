package com.castagno.dev.bazar_api.service;

import com.castagno.dev.bazar_api.dto.VentaDTO;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VentaService implements IVentaService{


    @Override
    public List<VentaDTO> getVentas() {
        return List.of();
    }

    @Override
    public VentaDTO findVenta(Long codigo_venta) {
        return null;
    }

    @Override
    public VentaDTO saveVenta(VentaDTO ventaDto) {
        return null;
    }

    @Override
    public VentaDTO updateVenta(Long codigo_venta, VentaDTO ventaDto) {
        return null;
    }

    @Override
    public void deleteVenta(Long codigo_venta) {

    }
}
