package br.com.fourbank.repositorio;

import java.util.HashMap;
import java.util.Map;

import br.com.fourbank.util.Conta;

public class RepositorioConta {

	private Map<Integer, Conta> repositorio = new HashMap<>();

	public void add(int id, Conta c) {
		repositorio.put(id, c);
	}
	
	public boolean existeConta(Conta c) {
		if(c == null) return false;
		if(repositorio.containsKey(c.getNumConta())){
			return true;
		}
		return false;
	}
	
	public Conta getConta(int num) {
		return repositorio.get(num);
	}
	
	public void update(int num, Conta conta) {
		if(existeConta(conta)) repositorio.put(num, conta);
	}
}
