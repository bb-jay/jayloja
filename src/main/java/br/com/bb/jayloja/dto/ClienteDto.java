package br.com.bb.jayloja.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ClienteDto {
	private long id;
	private String nome;
	private String sobrenome;
	private String sexo;
	private String cpf;
}
