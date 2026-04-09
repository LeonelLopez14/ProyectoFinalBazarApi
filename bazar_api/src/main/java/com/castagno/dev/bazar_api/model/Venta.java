package com.castagno.dev.bazar_api.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter @Setter
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codigo_venta;
    private LocalDate fecha_venta;
    private Double total;

    @OneToMany(mappedBy = "venta", fetch = FetchType.LAZY)
    private List<Producto> listaProductos;

    @OneToOne
    @JoinColumn(name = "id_cliente_FK",
                referencedColumnName = "id_cliente")
    private Cliente unCliente;

}
