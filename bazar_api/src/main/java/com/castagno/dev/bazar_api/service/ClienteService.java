package com.castagno.dev.bazar_api.service;

import com.castagno.dev.bazar_api.dto.ClienteDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService implements IClienteService {

    @Override
    public List<ClienteDTO> getClientes() {
        return List.of();
    }

    @Override
    public ClienteDTO findCliente(Long id_cliente) {
        return null;
    }

    @Override
    public ClienteDTO saveCliente(ClienteDTO clienteDto) {
        return null;
    }

    @Override
    public ClienteDTO updateCliente(Long id_cliente, ClienteDTO clienteDto) {
        return null;
    }

    @Override
    public void deleteCliente(Long id_cliente) {

    }
}
