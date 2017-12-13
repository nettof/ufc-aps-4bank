package br.com.fourbank.util;

import java.util.Date;

public class Cliente extends Pessoa {
	
	private String senha;
	private int id;

	public Cliente(String nome, String cnpj, int id, String senha) {
		super(nome, cnpj);
		this.id = id;
		this.senha = senha;
	}

	public Cliente(String nome, String cpf, Date nasc, int id, String senha) {
		super(nome, cpf, nasc);
		this.id = id;
		this.senha = senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getSenha() {
		return senha;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}