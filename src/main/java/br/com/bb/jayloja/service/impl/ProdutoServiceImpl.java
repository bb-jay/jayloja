package br.com.bb.jayloja.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bb.jayloja.dao.ProdutoDao;
import br.com.bb.jayloja.dto.ProdutoDto;
import br.com.bb.jayloja.models.Produto;
import br.com.bb.jayloja.service.ProdutoService;

@Service
public class ProdutoServiceImpl implements ProdutoService {

	@Autowired
	ProdutoDao produtoDao;

	@Override
	public boolean criaProduto(Produto produto) {
		try {
			produtoDao.save(produto);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Optional<Produto> retornaProdutoPorId(long id) {
		return produtoDao.findById(id);
	}

	@Override
	public boolean deletaProduto(long id) {
		try {
			produtoDao.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean atualizaProduto(ProdutoDto produtoDto) {
			Produto produtoOriginal = produtoDao.getReferenceById(produtoDto.getId());
			if (produtoOriginal == null) {
				return false;
			}
			Produto produtoAtualizado = atualizaCampos(produtoOriginal, produtoDto);
			produtoDao.save(produtoAtualizado);
			return true;
	}

	private Produto atualizaCampos(Produto original, ProdutoDto alteracoes) {
		Produto produtoAtualizado = new Produto();
		produtoAtualizado.setId(alteracoes.getId());
		produtoAtualizado.setPreco(alteracoes.getPreco() != null ? alteracoes.getPreco() : original.getPreco());
		produtoAtualizado.setNome(alteracoes.getNome() != null ? alteracoes.getNome() : original.getNome());
		produtoAtualizado.setDescricao(alteracoes.getDescricao() != null ? alteracoes.getDescricao() : original.getDescricao());
		return produtoAtualizado;
	}

	@Override
	public List<Produto> listarProdutosAtivos() {
		return produtoDao.findAllByRemovido(false);
	}

}
