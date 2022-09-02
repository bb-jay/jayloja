package br.com.bb.jayloja.restClient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "financeiroRestClient", url = "http://curso.nuvem.f3879710.t99.desenv.bb.com.br")
public interface FinanceiroRestClient {

	@RequestMapping(path = "/hello", method = RequestMethod.GET)
	List<String> findAll();
}
