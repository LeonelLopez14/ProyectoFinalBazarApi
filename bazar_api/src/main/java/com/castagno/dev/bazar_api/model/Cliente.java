package com.castagno.dev.bazar_api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_cliente;
    private String nombre;
    private String apellido;
    private String dni;

    public Cliente() {
    }

    public Cliente(String dni, String apellido, String nombre, Long id_cliente) {
        this.dni = dni;
        this.apellido = apellido;
        this.nombre = nombre;
        this.id_cliente = id_cliente;
    }
}
