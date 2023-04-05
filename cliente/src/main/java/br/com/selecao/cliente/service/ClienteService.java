package br.com.selecao.cliente.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.selecao.cliente.ClienteRepository.ClienteRepository;
import br.com.selecao.cliente.entity.Cliente;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    
    public Cliente salvar(Cliente cliente){
            return clienteRepository.save(cliente);
    }
   
    
    public List<Cliente> listaCliente(){
        return clienteRepository.findAll();
    }
    
    public Optional<Cliente> buscarPorId(Long id){
        return clienteRepository.findById(id);
    }
}
