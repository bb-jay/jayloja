package br.com.bb.jayloja.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "cliente")
@Data
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column
	private String nome;
	@Column
	private String sobrenome;
	@Column
	private String sexo;
	@Column
	private String cpf;
	@Column
	private String email;
	@Column
	private String senha;
}
