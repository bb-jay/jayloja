package br.com.bb.jayloja.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cliente")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {
	public static final Cliente CADASTRO_REMOVIDO = new Cliente(-1, "CLIENTE REMOVIDO", "CLIENTE REMOVIDO", "CLIENTE REMOVIDO", "CLIENTE REMOVIDO");
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
}
