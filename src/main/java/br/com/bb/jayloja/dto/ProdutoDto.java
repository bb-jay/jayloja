package br.com.bb.jayloja.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProdutoDto {
	private long id;
	private String nome;
	private Long preco;
	private String descricao;
}
