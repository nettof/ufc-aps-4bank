package br.com.fourbank.adapter;

import br.com.fourbank.util.cliente.Conta;

public interface TransacaoAdapter {
     public void transferencia(Conta orig, Conta destino, float valor);
}
