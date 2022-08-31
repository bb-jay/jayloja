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
	public boolean novoCliente(ClienteDto clienteDto) {
		Cliente cliente = new Cliente(
				clienteDto.getId(),
				clienteDto.getNome(),
				clienteDto.getSobrenome(),
				clienteDto.getSexo(),
				clienteDto.getCpf());
		try {
			clienteDao.save(cliente);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean atualizarCliente(Cliente cliente) {
		try {
			clienteDao.save(cliente);
			return true;
		} catch (Exception e) {
			return false;
		}
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
