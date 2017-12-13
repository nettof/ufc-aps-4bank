package br.com.fourbank.adapter;

import br.com.fourbank.util.cliente.Conta;

public class BancoBrasilAdapter extends BancoBrasil implements TransacaoAdapter {

	@Override
	public void transferencia(Conta orig, Conta destino, float valor) {
		transferenciaBBrasil(orig, destino, valor);
		orig.setSaldo(orig.getSaldo() - valor);
		System.out.println("Transferencia realizada!");
	}
   
}
