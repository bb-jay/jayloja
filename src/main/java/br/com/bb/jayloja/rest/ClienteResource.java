package br.com.bb.jayloja.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.bb.jayloja.dto.ClienteDto;
import br.com.bb.jayloja.models.Cliente;
import br.com.bb.jayloja.service.ClienteService;

@RestController
public class ClienteResource {

	@Autowired
	ClienteService service;

	@RequestMapping(path = "/cliente", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Cliente>> listarTodosClientes() {
		return ResponseEntity.ok(service.listarTodosClientes());
	}

	@RequestMapping(path="/cliente", method = RequestMethod.POST)
	public ResponseEntity<String> novoCliente(@RequestBody Cliente cliente) {
		boolean sucesso = service.novoCliente(cliente);

		if (sucesso) {
			return new ResponseEntity<>("Cliente cadastrado com sucesso!", HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>("Houve um erro", HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(path="/cliente", method = RequestMethod.PUT)
	public ResponseEntity<String> atualizarCliente(@RequestBody ClienteDto clienteDto) {
		boolean sucesso = service.atualizarCliente(clienteDto);

		if (sucesso) {
			return new ResponseEntity<>("Cliente atualizado com sucesso!", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Houve um erro", HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(path="/cliente/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deletarCliente(@PathVariable long id) {
		boolean sucesso = service.removerCliente(id);

		if (sucesso) {
			return new ResponseEntity<>("Cliente removido com sucesso!", HttpStatus.GONE);
		} else {
			return new ResponseEntity<>("Houve um erro", HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(path="/cliente/sexo/{sexo}", method = RequestMethod.GET)
	public ResponseEntity<List<Cliente>> encotrarPorSexo(@PathVariable String sexo) {
		return ResponseEntity.ok(service.encontrarPorSexo(sexo));
	}

}
