package br.com.fourbank.adapter;

import br.com.fourbank.util.Conta;

public class BancoBradescoAdapter extends BancoBradesco implements TransacaoAdapter{

	@Override
	public void transferencia(Conta orig, Conta destino, float valor) {
		transferenciaBBradesco(orig, destino, valor);
		orig.setSaldo(orig.getSaldo() - valor);
		System.out.println("Transferencia realizada!");
	}

}
