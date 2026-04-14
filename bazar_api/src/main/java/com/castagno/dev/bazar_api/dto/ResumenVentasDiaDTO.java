package com.castagno.dev.bazar_api.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResumenVentasDiaDTO {

    private LocalDate fecha;
    private long cantidadVentas;
    private double montoTotal;
}
