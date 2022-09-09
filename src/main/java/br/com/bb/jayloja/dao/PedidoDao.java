package br.com.bb.jayloja.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bb.jayloja.models.Pedido;

public interface PedidoDao extends JpaRepository<Pedido, Long> {
	List<Pedido> findAllByIdCliente(long idCliente);
	List<Pedido> findAllByIdProduto(long idProduto);
	List<Pedido> findByData(LocalDateTime data);
	List<Pedido> findAllByCancelado(boolean cancelado);
}
