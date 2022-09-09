package br.com.bb.jayloja.service;

import java.util.List;

import br.com.bb.jayloja.dto.ClienteDto;
import br.com.bb.jayloja.models.Cliente;

public interface ClienteService {
	public List<Cliente> listarTodosClientes();
	public void novoCliente(Cliente cliente);
	public void atualizarCliente(ClienteDto clienteDto);
	public void removerCliente(long id);
	public List<Cliente> encontrarPorSexo(String sexo);
}
