package br.com.bb.jayloja.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "pedido")
@Data
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private Long idCliente;
	@Column
	private Long idProduto;
	@Column
	private LocalDateTime data;
	@Column
	private Long desconto;
	@Column
	private boolean cancelado;
}
