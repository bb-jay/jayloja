package br.com.bb.jayloja.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bb.jayloja.dao.ProdutoDao;
import br.com.bb.jayloja.dto.ProdutoDto;
import br.com.bb.jayloja.exceptions.ProdutoNaoCadastradoException;
import br.com.bb.jayloja.models.Produto;
import br.com.bb.jayloja.service.ProdutoService;

@Service
public class ProdutoServiceImpl implements ProdutoService {

	@Autowired
	ProdutoDao produtoDao;

	@Override
	public void criaProduto(Produto produto) {
		produtoDao.save(produto);
	}

	@Override
	public Produto retornaProdutoPorId(long id) {
		try {
			return produtoDao.findById(id).get();
		} catch (NoSuchElementException e) {
			throw new ProdutoNaoCadastradoException(e);
		}
	}

	@Override
	public void deletaProduto(long id) {
		Optional<Produto> produtoOpt = produtoDao.findById(id);
		if (produtoOpt.isEmpty()) {
			throw new ProdutoNaoCadastradoException();
		}
		Produto registroProduto = produtoOpt.get();
		registroProduto.setRemovido(true);
		produtoDao.save(registroProduto);
	}

	@Override
	public void atualizaProduto(ProdutoDto produtoDto) {
		Produto produtoOriginal = produtoDao.getReferenceById(produtoDto.getId());
		if (produtoOriginal == null) {
			throw new ProdutoNaoCadastradoException();
		}
		Produto produtoAtualizado = atualizaCampos(produtoOriginal, produtoDto);
		produtoDao.save(produtoAtualizado);
	}

	private Produto atualizaCampos(Produto original, ProdutoDto alteracoes) {
		Produto produtoAtualizado = new Produto();
		produtoAtualizado.setId(alteracoes.getId());
		produtoAtualizado.setPreco(alteracoes.getPreco() != null ? alteracoes.getPreco() : original.getPreco());
		produtoAtualizado.setNome(alteracoes.getNome() != null ? alteracoes.getNome() : original.getNome());
		produtoAtualizado
				.setDescricao(alteracoes.getDescricao() != null ? alteracoes.getDescricao() : original.getDescricao());
		return produtoAtualizado;
	}

	@Override
	public List<Produto> listarProdutosAtivos() {
		return produtoDao.findAllByRemovido(false);
	}

	@Override
	public List<Produto> listarTodosProdutos() {
		return produtoDao.findAll();
	}

	@Override
	public List<Produto> listarProdutosRemovidos() {
		return produtoDao.findAllByRemovido(true);
	}

}
