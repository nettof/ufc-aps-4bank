package br.com.fourbank.util;

import br.com.fourbank.util.cliente.Conta;
import br.com.fourbank.util.movimento.Movimento;

public class Deposito extends Movimento implements Transacao{
    private Conta conta;
    private float valor;
    
    public Deposito(Conta conta, float valor) {
    	this.conta = conta;
    	this.valor = valor;
    }
    
    public Deposito(String descricao, float valor) {
    	this.setDescricao(descricao);
    	this.setValor(valor);
    }
	
    public Conta getConta() {
		return conta;
	}
	
    public void setConta(Conta conta) {
		this.conta = conta;
	}
	
    public float getValor() {
		return valor;
	}
	
    public void setValor(float valor) {
		this.valor = valor;
	}

	@Override
	public void transacao() {
		conta.setSaldo(conta.getSaldo() +  valor);
	}
    
}
