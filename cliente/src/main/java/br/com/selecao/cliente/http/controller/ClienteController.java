package br.com.selecao.cliente.http.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import br.com.selecao.cliente.entity.Cliente;
import br.com.selecao.cliente.service.ClienteService;

import java.util.List;

@RestController
@RequestMapping("/cliente")
@CrossOrigin("*")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente salvar(@RequestBody Cliente cliente) {
        return clienteService.salvar(cliente);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Cliente> listaCliente() {
        return clienteService.listaCliente();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Cliente buscarClienteId(@PathVariable("id") Long id) {
        return clienteService.buscarPorId(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente nao encontrado."));
    }

    @GetMapping("/json")
    @ResponseStatus(HttpStatus.OK)
    public String returnoJson() {
        return "{\"accepted_devices\":[\"Google Pixel 2 XL (8.1.0)\"],\"rejected_devices\":[] }";
    }

    
     @PutMapping("/alterar/{id}")
     @ResponseStatus(HttpStatus.NO_CONTENT)
     public void editarCliente(@PathVariable("id") Long id, @RequestBody Cliente
     cliente){
     clienteService.buscarPorId(id)
     .map(clienteBase -> {
     modelMapper.map(cliente, clienteBase);
     clienteService.salvar(clienteBase);
     return Void.TYPE;
     }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
     "Cliente nao encontrado."));
     }
    

    
}
