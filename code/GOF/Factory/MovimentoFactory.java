package br.com.fourbank.util;

public class MovimentoFactory {
     
	public Movimento getMovimentoFactory(String descricao, float valor, TipoMovimentar tipo) {
		if(tipo.equals(TipoMovimentar.SAQUE)) return new Saque(descricao, valor);
		if(tipo.equals(TipoMovimentar.DEPOSITO)) return new Deposito(descricao, valor);
		if(tipo.equals(TipoMovimentar.TRANSFERENCIA)) return new Transferencia(descricao, valor); 
		return null;
	}
}
