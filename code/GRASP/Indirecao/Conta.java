package br.com.fourbank.util;

import java.util.ArrayList;
import java.util.List;

public class Conta implements TituloListener {
	private Cliente cliente;
	private int numConta;
	private float saldo;
	private List<Movimento> movimentacao = new ArrayList<>();
	
	public void addMovimento(TipoMovimentar tipo, String descricao, float valor) {
		MovimentoFactory m = new MovimentoFactory();
		movimentacao.add(m.getMovimentoFactory(descricao, valor, tipo));
	}
	
	public List<Movimento> getMovimento() {
		return movimentacao;
	}
	
	public int getNumConta() {
		return numConta;
	}

	public void setNumConta(int numConta) {
		this.numConta = numConta;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	@Override
	public void notificar() {
		System.out.println("Titulo alterado");
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}