package com.castagno.dev.bazar_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codigo_venta;
    private LocalDate fechaVenta;
    private Double total;

    @OneToMany(mappedBy = "venta", fetch = FetchType.LAZY)
    private List<Producto> listaProductos = new ArrayList<>();;

    @OneToOne
    @JoinColumn(name = "id_cliente_FK",
                referencedColumnName = "id_cliente")
    private Cliente unCliente;

}
