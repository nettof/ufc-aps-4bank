package br.com.fourbank.util;

import br.com.fourbank.util.cliente.Conta;
import br.com.fourbank.util.movimento.Movimento;

public class Saque extends Movimento implements Transacao{
	private Conta conta;
	private float valor;
	
	public Saque(Conta conta, float valor) {
		this.conta = conta;
		this.valor = valor;
	}
	
	public Saque(String descricao, float valor) {
		this.setDescricao(descricao);
		this.setValor(valor);
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public float getValorSaque() {
		return valor;
	}

	public void setValorSaque(float valor) {
		this.valor = valor;
	}

	@Override
	public void transacao() {
		conta.setSaldo(conta.getSaldo() - valor);
	}
}