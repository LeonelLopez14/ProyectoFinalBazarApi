package com.castagno.dev.bazar_api.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codigo_producto;
    private String nombre;
    private String marca;
    private double precio;
    private double cantidadDisponible;

    @ManyToOne
    @JoinColumn (name = "venta_FK")
    private Venta venta;

}
