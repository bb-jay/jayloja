package br.com.bb.jayloja.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bb.jayloja.dao.ClienteDao;
import br.com.bb.jayloja.dto.ClienteDto;
import br.com.bb.jayloja.models.Cliente;
import br.com.bb.jayloja.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	ClienteDao clienteDao;

	@Override
	public List<Cliente> listarTodosClientes() {
		return clienteDao.findAll();
	}

	@Override
	public boolean novoCliente(Cliente cliente) {
		try {
			clienteDao.save(cliente);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean atualizarCliente(ClienteDto clienteDto) {
		Cliente clienteOriginal = clienteDao.getReferenceById(clienteDto.getId());
		if (clienteOriginal == null) {
			return false;
		}
		Cliente clienteAtualizado = atualizaCampos(clienteOriginal, clienteDto);
		try {
			clienteDao.save(clienteAtualizado);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	private Cliente atualizaCampos(Cliente original, ClienteDto alteracoes) {
		Cliente clienteAtualizado = new Cliente();
		clienteAtualizado.setId(alteracoes.getId());
		clienteAtualizado.setNome(alteracoes.getNome() != null ? alteracoes.getNome() : original.getNome());
		clienteAtualizado.setSobrenome(alteracoes.getSobrenome() != null ? alteracoes.getSobrenome() : original.getSobrenome());
		clienteAtualizado.setSexo(alteracoes.getSexo() != null ? alteracoes.getSexo() : original.getSexo());
		clienteAtualizado.setCpf(alteracoes.getCpf() != null ? alteracoes.getCpf() : original.getCpf());
		return clienteAtualizado;
	}

	@Override
	public boolean removerCliente(long id) {
		try {
			clienteDao.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<Cliente> encontrarPorSexo(String sexo) {
		return clienteDao.findAllBySexo(sexo);
	}

}
