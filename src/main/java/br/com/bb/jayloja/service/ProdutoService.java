package br.com.bb.jayloja.service;

import java.util.List;

import br.com.bb.jayloja.dto.ProdutoDto;
import br.com.bb.jayloja.models.Produto;

public interface ProdutoService {
	void criaProduto(Produto produto);
	Produto retornaProdutoPorId(long id);
	void deletaProduto(long id);
	void atualizaProduto(ProdutoDto produtoDto);
	List<Produto> listarProdutosAtivos();
	List<Produto> listarTodosProdutos();
	List<Produto> listarProdutosRemovidos();
}
