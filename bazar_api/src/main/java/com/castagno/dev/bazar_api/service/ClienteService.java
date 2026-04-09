package com.castagno.dev.bazar_api.service;

import com.castagno.dev.bazar_api.model.Cliente;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService implements IClienteService {

    @Override
    public void deleteCliente(Long id_cliente) {

    }

    @Override
    public Cliente findCliente(Long id_cliente) {
        return null;
    }

    @Override
    public List<Cliente> getClientes() {
        return List.of();
    }

    @Override
    public void saveCliente(Cliente cliente) {

    }

    @Override
    public void updateCliente(Cliente cliente) {

    }

}
