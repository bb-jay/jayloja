package br.com.bb.jayloja.service;

import java.util.List;

import br.com.bb.jayloja.dto.ClienteDto;
import br.com.bb.jayloja.models.Cliente;

public interface ClienteService {
	public List<Cliente> listarTodosClientes();
	public boolean novoCliente(Cliente cliente);
	public boolean atualizarCliente(ClienteDto clienteDto);
	public boolean removerCliente(long id);
	public List<Cliente> encontrarPorSexo(String sexo);
}
