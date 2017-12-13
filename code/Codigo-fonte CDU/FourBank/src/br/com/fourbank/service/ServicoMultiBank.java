package br.com.fourbank.service;

import br.com.fourbank.repositorio.RepositorioMultiBank;
import br.com.fourbank.util.Transacao;

public class ServicoMultiBank {
    private static ServicoMultiBank servicoMultiBank;
    private static RepositorioMultiBank repositorioMultiBank = new RepositorioMultiBank();
    private static int codigo = 2357;
    
    public static synchronized ServicoMultiBank getInstance(){
		if(servicoMultiBank == null) servicoMultiBank = new ServicoMultiBank();
		return servicoMultiBank;
	}
    
    public static int geraCodigoSaque(Transacao transacao) {
    	repositorioMultiBank.add(codigo, transacao);
    	int codigoInsert = codigo;
    	codigo++;
    	return codigoInsert;
    }
    
    public static void realizarTransacao(int codigo) {
    	Transacao t = repositorioMultiBank.getTransacao(codigo);
    	if(t != null) {
    		t.transacao();
        	repositorioMultiBank.delete(codigo);
    	}
    }
    
}
