package br.com.bb.jayloja.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bb.jayloja.dao.ClienteDao;
import br.com.bb.jayloja.dto.ClienteDto;
import br.com.bb.jayloja.exceptions.ClienteNaoCadastradoException;
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
	public void novoCliente(Cliente cliente) {
		clienteDao.save(cliente);
	}

	@Override
	public void atualizarCliente(ClienteDto clienteDto) {
		Cliente clienteOriginal = clienteDao.getReferenceById(clienteDto.getId());
		if (clienteOriginal == null) {
			throw new ClienteNaoCadastradoException();
		}
		Cliente clienteAtualizado = atualizaCampos(clienteOriginal, clienteDto);
		clienteDao.save(clienteAtualizado);
	}

	private Cliente atualizaCampos(Cliente original, ClienteDto alteracoes) {
		Cliente clienteAtualizado = new Cliente();
		clienteAtualizado.setId(alteracoes.getId());
		clienteAtualizado.setNome(alteracoes.getNome() != null ? alteracoes.getNome() : original.getNome());
		clienteAtualizado
				.setSobrenome(alteracoes.getSobrenome() != null ? alteracoes.getSobrenome() : original.getSobrenome());
		clienteAtualizado.setSexo(alteracoes.getSexo() != null ? alteracoes.getSexo() : original.getSexo());
		clienteAtualizado.setCpf(alteracoes.getCpf() != null ? alteracoes.getCpf() : original.getCpf());
		return clienteAtualizado;
	}

	@Override
	public void removerCliente(long id) {
		clienteDao.deleteById(id);
	}

	@Override
	public List<Cliente> encontrarPorSexo(String sexo) {
		return clienteDao.findAllBySexo(sexo);
	}

}
