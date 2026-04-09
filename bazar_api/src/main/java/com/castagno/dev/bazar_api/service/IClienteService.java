package com.castagno.dev.bazar_api.service;

import com.castagno.dev.bazar_api.model.Cliente;
import java.util.List;

public interface IClienteService {
    //Metodo READ todos los clientes
    public List<Cliente> getClientes();

    //metodo READ un cliente por id
    public Cliente findCliente(Long id_cliente);

    //Metodo CREATE un cliente
    public void saveCliente(Cliente cliente);

    //Metodo UPDATE un cliente
    public void updateCliente(Cliente cliente);

    //Metodo DELETE un cliente
    public void deleteCliente(Long id_cliente);
}
