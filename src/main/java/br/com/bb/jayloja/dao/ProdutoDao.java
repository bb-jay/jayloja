package br.com.bb.jayloja.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bb.jayloja.models.Produto;

public interface ProdutoDao extends JpaRepository<Produto, Long> {
}
