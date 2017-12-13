package br.com.fourbank.util;

import java.util.ArrayList;
import java.util.List;

public class Titulo {
    private int id;
	private String nome;
	private double valor;
	private List<TituloListener> listeners = new ArrayList<>();
	
	public Titulo(int id, String nome, double valor) {
	   this.id = id;
	   this.nome = nome;
	   this.valor = valor;
	}

	public void addListener(TituloListener listener) {
		listeners.add(listener);
	}

	public void dispararAlteracao() {
		for(TituloListener t: listeners) {
			t.notificar();
		}
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
		dispararAlteracao();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}