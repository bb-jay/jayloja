package br.com.bb.jayloja.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
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

	@RequestMapping(path="/produto", method = RequestMethod.POST)
	public ResponseEntity<String> criarProduto(@RequestBody Produto produto) {
		boolean sucesso = service.criaProduto(produto);
		if (sucesso) {
			return new ResponseEntity<>("Produto criado com sucesso!", HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>("Houve um erro", HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(path="/produto/{id}", method=RequestMethod.GET)
	public ResponseEntity<Produto> encontraProduto(@PathVariable long id) {
		Optional<Produto> optProduto = service.retornaProdutoPorId(id);
		if (optProduto.isPresent()) {
			return ResponseEntity.ok(optProduto.get());
		} else {
			return new ResponseEntity<>(new HttpHeaders(), HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(path="/produto/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<String> apagaProduto(@PathVariable long id) {
		boolean sucesso = service.deletaProduto(id);
		if (sucesso) {
			return new ResponseEntity<>("Produto excluído com sucesso!", HttpStatus.GONE);
		} else {
			return new ResponseEntity<>("Houve um erro", HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(path="/produto", method=RequestMethod.PUT)
	public ResponseEntity<String> atualizaProduto(@RequestBody ProdutoDto produtoDto) {
		boolean sucesso = service.atualizaProduto(produtoDto);
		if (sucesso) {
			return new ResponseEntity<>("Produto atualizado com sucesso!", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Houve um erro", HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(path="/produto/categorias", method = RequestMethod.GET)
	public ResponseEntity<List<String>> listaCategorias() {
		return ResponseEntity.ok(financeiroRestClient.findAll());
	}
}
