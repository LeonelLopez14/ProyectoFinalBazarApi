package com.castagno.dev.bazar_api.service;

import com.castagno.dev.bazar_api.dto.ClienteDTO;
import java.util.List;

public interface IClienteService {
    //Metodo READ todos los clientes
    public List<ClienteDTO> getClientes();

    //metodo READ un cliente por id
    public ClienteDTO findCliente(Long id_cliente);

    //Metodo CREATE un cliente
    public ClienteDTO saveCliente(ClienteDTO clienteDto);

    //Metodo UPDATE un cliente
    public ClienteDTO updateCliente(Long id_cliente, ClienteDTO clienteDto);

    //Metodo DELETE un cliente
    public void deleteCliente(Long id_cliente);
}
