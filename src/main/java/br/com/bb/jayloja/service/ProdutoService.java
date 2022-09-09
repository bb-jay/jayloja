package br.com.bb.jayloja.service;

import java.util.List;
import java.util.Optional;

import br.com.bb.jayloja.dto.ProdutoDto;
import br.com.bb.jayloja.models.Produto;

public interface ProdutoService {
	boolean criaProduto(Produto produto);
	Optional<Produto> retornaProdutoPorId(long id);
	boolean deletaProduto(long id);
	boolean atualizaProduto(ProdutoDto produtoDto);
	List<Produto> listarProdutosAtivos();
}
