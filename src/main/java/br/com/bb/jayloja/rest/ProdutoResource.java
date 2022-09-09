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

import br.com.bb.jayloja.dto.ProdutoDto;
import br.com.bb.jayloja.models.Produto;
import br.com.bb.jayloja.restClient.FinanceiroRestClient;
import br.com.bb.jayloja.service.ProdutoService;

@RestController
public class ProdutoResource {

	@Autowired
	ProdutoService service;

	@Autowired
	FinanceiroRestClient financeiroRestClient;

	@RequestMapping(path = "/produto", method = RequestMethod.POST)
	public ResponseEntity<String> criarProduto(@RequestBody Produto produto) {
		service.criaProduto(produto);
		return new ResponseEntity<>("Produto criado com sucesso!", HttpStatus.CREATED);
	}

	@RequestMapping(path = "/produto/{id}", method = RequestMethod.GET)
	public ResponseEntity<Produto> encontraProduto(@PathVariable long id) {
		return ResponseEntity.ok(service.retornaProdutoPorId(id));
	}

	@RequestMapping(path = "/produto/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> apagaProduto(@PathVariable long id) {
		service.deletaProduto(id);
		return new ResponseEntity<>("Produto excluído com sucesso!", HttpStatus.GONE);
	}

	@RequestMapping(path = "/produto", method = RequestMethod.PUT)
	public ResponseEntity<String> atualizaProduto(@RequestBody ProdutoDto produtoDto) {
		service.atualizaProduto(produtoDto);
		return new ResponseEntity<>("Produto atualizado com sucesso!", HttpStatus.OK);
	}

	@RequestMapping(path = "/produto", method = RequestMethod.GET)
	public ResponseEntity<List<Produto>> listaProdutosAtivos() {
		return ResponseEntity.ok(service.listarProdutosAtivos());
	}

	@RequestMapping(path = "/produto/removidos", method = RequestMethod.GET)
	public ResponseEntity<List<Produto>> listaProdutosRemovidos() {
		return ResponseEntity.ok(service.listarProdutosRemovidos());
	}

	@RequestMapping(path = "/produto/todos", method = RequestMethod.GET)
	public ResponseEntity<List<Produto>> listaTodosProdutos() {
		return ResponseEntity.ok(service.listarTodosProdutos());
	}

	@RequestMapping(path = "/produto/categorias", method = RequestMethod.GET)
	public ResponseEntity<List<String>> listaCategorias() {
		return ResponseEntity.ok(financeiroRestClient.findAll());
	}
}
