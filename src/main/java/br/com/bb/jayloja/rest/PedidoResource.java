package br.com.bb.jayloja.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.bb.jayloja.dto.PedidoDto;
import br.com.bb.jayloja.service.PedidoService;

@RestController
public class PedidoResource {
	@Autowired
	PedidoService service;

	@RequestMapping(path = "/pedido", method = RequestMethod.GET)
	public ResponseEntity<List<PedidoDto>> listarPedidos() {
		return ResponseEntity.ok(service.listaPedidos());
	}
}
