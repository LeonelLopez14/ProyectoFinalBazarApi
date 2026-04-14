package com.castagno.dev.bazar_api.service;

import com.castagno.dev.bazar_api.dto.ClienteDTO;
import com.castagno.dev.bazar_api.exception.NotFoundException;
import com.castagno.dev.bazar_api.mapper.Mapper;
import com.castagno.dev.bazar_api.model.Cliente;
import com.castagno.dev.bazar_api.repository.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService implements IClienteService {

    @Autowired
    private IClienteRepository clienteRepository;

    @Override
    public List<ClienteDTO> getClientes() {
        return clienteRepository.findAll().stream().map(Mapper::toDTO).toList();
    }

    @Override
    public ClienteDTO findCliente(Long id_cliente) {
        Cliente cliente = clienteRepository.findById(id_cliente)
                .orElseThrow(() -> new NotFoundException("No existe un cliente con el id: " + id_cliente));

        return Mapper.toDTO(cliente);
    }

    @Override
    public ClienteDTO saveCliente(ClienteDTO clienteDto) {
        Cliente cliente = new Cliente();
        cliente.setNombre(clienteDto.getNombre());
        cliente.setApellido(clienteDto.getApellido());
        cliente.setDni(clienteDto.getDni());

        return Mapper.toDTO(clienteRepository.save(cliente));
    }

    @Override
    public ClienteDTO updateCliente(Long id_cliente, ClienteDTO clienteDto) {

        Cliente cliente = clienteRepository.findById(id_cliente)
                .orElseThrow(() -> new NotFoundException("No existe un cliente con el id: " + id_cliente));
        cliente.setNombre(clienteDto.getNombre());
        cliente.setApellido(clienteDto.getApellido());
        cliente.setDni(clienteDto.getDni());
        return Mapper.toDTO(clienteRepository.save(cliente));
    }

    @Override
    public void deleteCliente(Long id_cliente) {

        //checkeo si existe el id en BD
        if (!clienteRepository.existsById(id_cliente)) {
            throw new NotFoundException("Clientre no encontrado");
        }
        clienteRepository.deleteById(id_cliente);
    }
}
