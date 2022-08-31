package br.com.bb.jayloja.service.impl;

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
		try {
			Produto produto = new Produto(
					produtoDto.getId(),
					produtoDto.getNome(),
					produtoDto.getPreco(),
					produtoDto.getDescricao());
			produtoDao.save(produto);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
