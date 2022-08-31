package br.com.bb.jayloja.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bb.jayloja.models.Cliente;

public interface ClienteDao extends JpaRepository<Cliente, Long> {
	List<Cliente> findAllBySexo(String sexo);
}
