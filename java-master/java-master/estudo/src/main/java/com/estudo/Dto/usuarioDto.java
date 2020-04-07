package com.estudo.Dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class usuarioDto {

	public usuarioDto(String nome, int idade, String login, String senha) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.login = login;
		this.senha = senha;
	}

	public usuarioDto() {
		super();
	}

	@Id
	@GeneratedValue
	private Long id;

	private String nome;

	private int idade;

	private String login;

	private String senha;

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return this.nome;
	}

	public int getIdade() {
		return this.idade;
	}

	public String getLogin() {
		return this.login;
	}

	public String getSenha() {
		return this.senha;
	}

	public Long getId() {
		return id;
	}

}
