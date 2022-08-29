package br.com.bb.jayloja.endpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.bb.jayloja.service.HorarioService;

@RestController
public class HelloWorldEndpoint {

	@Autowired
	HorarioService service;

	Logger log = LoggerFactory.getLogger(HelloWorldEndpoint.class);

	@RequestMapping(path = "/hello", method = RequestMethod.GET)
	public ResponseEntity<String> hello() {
		return new ResponseEntity<>("Hello world!", HttpStatus.OK);
	}

	@RequestMapping(path = "/hello/{nome}", method = RequestMethod.GET)
	public ResponseEntity<String> helloComNome(@PathVariable String nome) {
		log.info("dei oi pro " + nome);
		return new ResponseEntity<>("Hello, " + nome + "!", HttpStatus.OK);
	}

	@RequestMapping(path = "/hello/{nome}/horario", method = RequestMethod.GET)
	public ResponseEntity<String> helloComHora(@PathVariable String nome) {
		return new ResponseEntity<>(String.format("Hello, %s! São %s", nome, service.getHorario()), HttpStatus.OK);
	}

}
