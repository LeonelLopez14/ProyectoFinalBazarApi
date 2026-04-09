package com.castagno.dev.bazar_api.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codigo_producto;
    private String nombre;
    private String marca;
    private double precio;
    private double cantidad_disponible;

    @ManyToOne
    @JoinColumn (name = "venta_FK")
    private Venta venta;

    public Producto() {
    }

    public Producto(Long codigo_producto, String nombre, String marca, double precio, double cantidad_disponible) {
        this.codigo_producto = codigo_producto;
        this.nombre = nombre;
        this.marca = marca;
        this.precio = precio;
        this.cantidad_disponible = cantidad_disponible;
    }
}
