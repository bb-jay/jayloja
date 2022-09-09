package br.com.bb.jayloja.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bb.jayloja.models.Produto;

public interface ProdutoDao extends JpaRepository<Produto, Long> {

	List<Produto> findAllByRemovido(boolean removido);
}
