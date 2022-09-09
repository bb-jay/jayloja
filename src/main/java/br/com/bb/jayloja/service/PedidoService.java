package br.com.bb.jayloja.service;

import java.util.List;

import br.com.bb.jayloja.dto.PedidoDto;
import br.com.bb.jayloja.models.Pedido;

public interface PedidoService {
	List<PedidoDto> listaTodosPedidos();
	List<PedidoDto> listaPedidosAtivos();
	List<PedidoDto> listaPedidosCancelados();
	PedidoDto listarPedidoPorId(Long id);
	boolean novoPedido(Pedido novoPedido);
	void atualizaPedido(Pedido pedido);
	void cancelaPedido(Long id);
	List<PedidoDto> listaPedidosDoCliente(long id);
	List<PedidoDto> listaPedidosDoProduto(long id);
}
