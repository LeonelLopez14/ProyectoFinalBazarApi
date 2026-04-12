package com.castagno.dev.bazar_api.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClienteDTO {

    private Long id_cliente;
    private String nombre;
    private String apellido;
    private String dni;

}
