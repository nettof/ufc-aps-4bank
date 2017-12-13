package br.com.fourbank.util;

import java.util.Date;

public abstract class Pessoa {

	private String nome;
	private String cpf, cnpj;
	private Date nasc;

	public Pessoa(String nome, String cpf, Date nasc) {
		super();
		this.setNome(nome);
		this.setCpf(cpf);
		this.setNasc(nasc);
	}

	public Pessoa(String nome, String cnpj) {
		super();
		this.setNome(nome);
		this.setCnpj(cnpj);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getNasc() {
		return nasc;
	}

	public void setNasc(Date nasc) {
		this.nasc = nasc;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

}