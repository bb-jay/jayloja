package br.com.bb.jayloja.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.bb.jayloja.dto.PedidoDto;
import br.com.bb.jayloja.models.Pedido;
import br.com.bb.jayloja.service.PedidoService;

@RestController
public class PedidoResource {
	@Autowired
	PedidoService service;

	@RequestMapping(path = "/pedido", method = RequestMethod.GET)
	public ResponseEntity<List<PedidoDto>> listarPedidosAtivos() {
		return ResponseEntity.ok(service.listaPedidosAtivos());
	}

	@RequestMapping(path = "/pedido/cancelados", method = RequestMethod.GET)
	public ResponseEntity<List<PedidoDto>> listarPedidosCancelados() {
		return ResponseEntity.ok(service.listaPedidosCancelados());
	}

	@RequestMapping(path = "/pedido/todos", method = RequestMethod.GET)
	public ResponseEntity<List<PedidoDto>> listarTodosPedidos() {
		return ResponseEntity.ok(service.listaTodosPedidos());
	}

	@RequestMapping(path = "/pedido", method = RequestMethod.POST)
	public ResponseEntity<String> novoPedido(@RequestBody Pedido novoPedido) {
		service.novoPedido(novoPedido);
		return new ResponseEntity<>("Pedido realizado com sucesso", HttpStatus.CREATED);
	}

	@RequestMapping(path = "/pedido/{id}", method = RequestMethod.GET)
	public ResponseEntity<PedidoDto> listarPedidoPorId(@PathVariable long id) {
		return ResponseEntity.ok(service.listarPedidoPorId(id));
	}

	@RequestMapping(path = "/pedido/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> cancelarPedido(@PathVariable long id) {
		service.cancelaPedido(id);
		return new ResponseEntity<>("Pedido cancelado com sucesso!", HttpStatus.GONE);
	}

	@RequestMapping(path = "/pedido", method = RequestMethod.PUT)
	public ResponseEntity<String> atualizarPedido(@RequestBody Pedido pedido) {
		service.atualizaPedido(pedido);
		return ResponseEntity.ok("Pedido atualizado com sucesso!");
	}

	@RequestMapping(path = "/pedido/cliente/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<PedidoDto>> listarPedidosDoCliente(@PathVariable long id) {
		return ResponseEntity.ok(service.listaPedidosDoCliente(id));
	}

	@RequestMapping(path = "/pedido/produto/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<PedidoDto>> listarPedidosDoProduto(@PathVariable long id) {
		return ResponseEntity.ok(service.listaPedidosDoProduto(id));
	}
}
