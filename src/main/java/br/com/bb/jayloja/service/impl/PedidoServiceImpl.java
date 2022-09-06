package br.com.bb.jayloja.service.impl;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bb.jayloja.dao.ClienteDao;
import br.com.bb.jayloja.dao.PedidoDao;
import br.com.bb.jayloja.dao.ProdutoDao;
import br.com.bb.jayloja.dto.PedidoDto;
import br.com.bb.jayloja.exceptions.ClienteNaoCadastradoException;
import br.com.bb.jayloja.exceptions.ProdutoNaoCadastradoException;
import br.com.bb.jayloja.models.Cliente;
import br.com.bb.jayloja.models.Pedido;
import br.com.bb.jayloja.models.Produto;
import br.com.bb.jayloja.service.PedidoService;

@Service
public class PedidoServiceImpl implements PedidoService {
	@Autowired
	PedidoDao pedidoDao;
	@Autowired
	ProdutoDao produtoDao;
	@Autowired
	ClienteDao clienteDao;

	@Override
	public List<PedidoDto> listaPedidos() {
		return completaPedido(pedidoDao.findAll());
	}

	private List<PedidoDto> completaPedido(Collection<Pedido> pedidos) {
		return pedidos.stream()
				.map(pedido -> completaPedido(pedido))
				.collect(Collectors.toList());
	}

	private PedidoDto completaPedido(Pedido pedido) throws ProdutoNaoCadastradoException, ClienteNaoCadastradoException {
		Optional<Produto> produtoOpt = produtoDao.findById(pedido.getIdProduto());
		Optional<Cliente> clienteOpt = clienteDao.findById(pedido.getIdCliente());
		if (produtoOpt.isEmpty()) {
			throw new ProdutoNaoCadastradoException();
		}
		if (clienteOpt.isEmpty()) {
			throw new ClienteNaoCadastradoException();
		}
		return new PedidoDto(
				pedido.getId(),
				clienteOpt.get(),
				produtoOpt.get(),
				pedido.getData(),
				pedido.getDesconto(),
				pedido.isCancelado());
	}
}
