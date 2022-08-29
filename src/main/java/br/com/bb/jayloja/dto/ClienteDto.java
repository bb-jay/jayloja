package br.com.bb.jayloja.dto;

public class ClienteDto {
	private long id;
	private String nome;
	private String sobrenome;
	private String sexo;
	private String cpf;

	public long getId() {
		return id;
	}

	public ClienteDto setId(long id) {
		this.id = id;
		return this;
	}

	public String getNome() {
		return nome;
	}

	public ClienteDto setNome(String nome) {
		this.nome = nome;
		return this;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public ClienteDto setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
		return this;
	}

	public String getSexo() {
		return sexo;
	}

	public ClienteDto setSexo(String sexo) {
		this.sexo = sexo;
		return this;
	}

	public String getCpf() {
		return cpf;
	}

	public ClienteDto setCpf(String cpf) {
		this.cpf = cpf;
		return this;
	}

	public ClienteDto(long id, String nome, String sobrenome, String sexo, String cpf) {
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.sexo = sexo;
		this.cpf = cpf;
	}

	public ClienteDto() {
	}
}
