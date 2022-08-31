package br.com.bb.jayloja.dto;

public class ProdutoDto {
	private long id;
	private String nome;
	private long preco;
	private String descricao;

	public long getId() {
		return id;
	}

	public ProdutoDto setId(long id) {
		this.id = id;
		return this;
	}

	public String getNome() {
		return nome;
	}

	public ProdutoDto setNome(String nome) {
		this.nome = nome;
		return this;
	}

	public long getPreco() {
		return preco;
	}

	public ProdutoDto setPreco(long preco) {
		this.preco = preco;
		return this;
	}

	public String getDescricao() {
		return descricao;
	}

	public ProdutoDto setDescricao(String descricao) {
		this.descricao = descricao;
		return this;
	}

	public ProdutoDto(long id, String nome, long preco, String descricao) {
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.descricao = descricao;
	}
	public ProdutoDto(String nome, long preco, String descricao) {
		this.nome = nome;
		this.preco = preco;
		this.descricao = descricao;
	}

	public ProdutoDto() {
	}
}
