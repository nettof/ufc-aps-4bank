package br.com.fourbank.util;

import br.com.fourbank.util.cliente.Conta;
import br.com.fourbank.util.movimento.Movimento;

public class Transferencia extends Movimento implements Transacao{
    private Conta contaOrig, contaDest;
    private float valor;
    
    public Transferencia(Conta contaOrig, Conta contaDest, float valor) {
    	this.contaOrig = contaOrig;
    	this.contaDest = contaDest;
    	this.valor = valor;
    }
    
    public Transferencia(String descricao, float valor) {
    	this.setDescricao(descricao);
    	this.setValor(valor);
    }
	
    public Conta getContaOrig() {
		return contaOrig;
	}
	public void setContaOrig(Conta contaOrig) {
		this.contaOrig = contaOrig;
	}
	public Conta getContaDest() {
		return contaDest;
	}
	public void setContaDest(Conta contaDest) {
		this.contaDest = contaDest;
	}
	public float getValorTransferencia() {
		return valor;
	}
	public void setValorTransferencia(float valor) {
		this.valor = valor;
	}

	@Override
	public void transacao() {
		contaOrig.setSaldo(contaOrig.getSaldo() - valor);
		contaDest.setSaldo(contaDest.getSaldo() + valor);
	}	
}
