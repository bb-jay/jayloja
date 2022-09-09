package br.com.bb.jayloja.service.impl;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bb.jayloja.dao.ClienteDao;
import br.com.bb.jayloja.dao.PedidoDao;
import br.com.bb.jayloja.dao.ProdutoDao;
import br.com.bb.jayloja.dto.PedidoDto;
import br.com.bb.jayloja.exceptions.ClienteNaoCadastradoException;
import br.com.bb.jayloja.exceptions.PedidoNaoEncontradoException;
import br.com.bb.jayloja.exceptions.ProdutoIndisponivelException;
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
	public List<PedidoDto> listaPedidosAtivos() {
		return completaPedidoDto(pedidoDao.findAllByCancelado(false));
	}

	@Override
	public List<PedidoDto> listaTodosPedidos() {
		return completaPedidoDto(pedidoDao.findAll());
	}

	@Override
	public List<PedidoDto> listaPedidosCancelados() {
		return completaPedidoDto(pedidoDao.findAllByCancelado(true));
	}

	private List<PedidoDto> completaPedidoDto(Collection<Pedido> pedidos) {
		return pedidos.stream()
				.map(pedido -> completaPedidoDto(pedido))
				.collect(Collectors.toList());
	}

	private PedidoDto completaPedidoDto(Pedido pedido)
			throws ProdutoNaoCadastradoException, ClienteNaoCadastradoException {
		Optional<Produto> produtoOpt = produtoDao.findById(pedido.getIdProduto());
		Optional<Cliente> clienteOpt = clienteDao.findById(pedido.getIdCliente());
		return new PedidoDto(
				pedido.getId(),
				clienteOpt.isPresent() ? clienteOpt.get() : Cliente.CADASTRO_REMOVIDO,
				produtoOpt.isPresent() ? produtoOpt.get() : null,
				pedido.getData(),
				pedido.getDesconto(),
				pedido.isCancelado());
	}

	private void verificaClienteEProduto(Pedido pedido) {
		PedidoDto pedidoDto = completaPedidoDto(pedido);
		if (pedidoDto.getCliente() == Cliente.CADASTRO_REMOVIDO) {
			throw new ClienteNaoCadastradoException();
		}
		if (pedidoDto.getProduto() == null) {
			throw new ProdutoNaoCadastradoException();
		} else if (pedidoDto.getProduto().isRemovido()) {
			throw new ProdutoIndisponivelException();
		}
	}

	@Override
	public void novoPedido(Pedido novoPedido) {
		verificaClienteEProduto(novoPedido);
		novoPedido.setCancelado(false);
		if (novoPedido.getData() == null)
			novoPedido.setData(LocalDateTime.now());
		pedidoDao.save(novoPedido);
	}

	@Override
	public PedidoDto listarPedidoPorId(Long id) {
		try {
			Pedido pedido = pedidoDao.findById(id).get();
			return completaPedidoDto(pedido);
		} catch (NoSuchElementException e) {
			throw new PedidoNaoEncontradoException(e);
		}
	}

	@Override
	public void atualizaPedido(Pedido mudanca) {
		Optional<Pedido> originalOpt = pedidoDao.findById(mudanca.getId());
		if (originalOpt.isEmpty()) {
			throw new PedidoNaoEncontradoException();
		}
		Pedido original = originalOpt.get();

		Pedido atualizado = new Pedido();
		atualizado.setId(original.getId());
		atualizado.setData(mudanca.getData() == null ? original.getData() : mudanca.getData());
		atualizado.setDesconto(mudanca.getDesconto() == null ? original.getDesconto() : mudanca.getDesconto());
		atualizado.setIdCliente(mudanca.getIdCliente() == null ? original.getIdCliente() : mudanca.getIdCliente());
		atualizado.setIdProduto(mudanca.getIdProduto() == null ? original.getIdProduto() : mudanca.getIdProduto());
		atualizado.setCancelado(original.isCancelado());

		pedidoDao.save(atualizado);
	}

	@Override
	public void cancelaPedido(Long id) {
		Optional<Pedido> pedidoOpt = pedidoDao.findById(id);
		if (pedidoOpt.isEmpty()) {
			throw new PedidoNaoEncontradoException();
		}
		Pedido registroPedido = pedidoOpt.get();
		registroPedido.setCancelado(true);
		pedidoDao.save(registroPedido);
	}

	@Override
	public List<PedidoDto> listaPedidosDoCliente(long id) {
		return completaPedidoDto(pedidoDao.findAllByIdCliente(id));
	}

	@Override
	public List<PedidoDto> listaPedidosDoProduto(long id) {
		return completaPedidoDto(pedidoDao.findAllByIdProduto(id));
	}
}
