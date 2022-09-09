package br.com.bb.jayloja.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="produto")
@Data
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column
	private String nome;
	@Column
	private Long preco;
	@Column
	private String descricao;
	@Column
	private boolean removido;
}
