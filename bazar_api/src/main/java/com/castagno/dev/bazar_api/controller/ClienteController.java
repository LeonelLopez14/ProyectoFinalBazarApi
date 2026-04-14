package com.castagno.dev.bazar_api.controller;

import com.castagno.dev.bazar_api.dto.ClienteDTO;
import com.castagno.dev.bazar_api.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private IClienteService clienteService;

    // GET /api/clientes/traer
    @GetMapping ("/traer")
    public ResponseEntity<List<ClienteDTO>> getClientes() {
        return ResponseEntity.ok(clienteService.getClientes());
    }

    // GET /api/clientes/traer/{id}
    @GetMapping("/traer/{id}")
    public ResponseEntity<ClienteDTO> getCliente(@PathVariable Long id) {
        return ResponseEntity.ok(clienteService.findCliente(id));
    }

    // POST /api/clientes/crear
    @PostMapping ("/crear")
    public ResponseEntity<ClienteDTO> saveCliente(@RequestBody ClienteDTO clienteDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.saveCliente(clienteDTO));
    }

    // PUT /api/clientes/actualizar/{id}
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<ClienteDTO> updateCliente(@PathVariable Long id,
                                                    @RequestBody ClienteDTO clienteDTO) {
        return ResponseEntity.ok(clienteService.updateCliente(id, clienteDTO));
    }

    // DELETE /api/clientes/borrar/{id}
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable Long id) {
        clienteService.deleteCliente(id);
        return ResponseEntity.noContent().build();
    }

}
