package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Cliente;
import com.example.demo.services.ClienteServices;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteServices ss;

    @PostMapping("/savecliente")
    public Cliente createCliente(@RequestBody Cliente cliente) {

        return ss.saveCliente(cliente);
    }

    @GetMapping("/allcliente")
    public List<Cliente> getAllCliente() {

        return ss.getAllCliente();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable Long id) {
        Cliente cliente = ss.getClienteById(id);

        return ResponseEntity.ok(cliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> updateCliente(@PathVariable Long id, @RequestBody Cliente clienteUpdated) {
        Cliente cliente = ss.getClienteById(id);

        cliente.setNome(clienteUpdated.getNome());
        cliente.setCpf(clienteUpdated.getCpf());
        cliente.setEndereco(clienteUpdated.getEndereco());
        cliente.setTelefone(clienteUpdated.getTelefone());
        cliente.setLoguin(clienteUpdated.getLoguin());
        cliente.setSenha(clienteUpdated.getSenha());

        ss.saveCliente(cliente);

        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/{id}")
    public void deleteCliente(@PathVariable Long id) {
        ss.deleteById(id);
    }

}
