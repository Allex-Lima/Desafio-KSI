package br.com.selecao.cliente.ClienteRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.selecao.cliente.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
