package br.com.fourbank.repositorio;

import java.util.HashMap;
import java.util.Map;

import br.com.fourbank.util.Transacao;

public class RepositorioMultiBank {
	
	private Map<Integer, Transacao> hm = new HashMap<Integer, Transacao>();
	
	public void add(int codigo, Transacao transacao){
		hm.put(codigo, transacao);
	}
	
	public boolean containsK(int codigo){
		return hm.containsKey(codigo);
	}
	
	public Transacao getTransacao(int codigo){
		if(containsK(codigo)) {
			return hm.get(codigo);
		}
		return null;
	}
	
	public void delete(int codigo){
		hm.remove(codigo);
	}
	
}