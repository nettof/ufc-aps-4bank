package br.com.fourbank.repositorio;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import br.com.fourbank.util.cliente.Cliente;

public class RepositorioCliente {

	private Map<Integer, Cliente> repositorio = new HashMap<>();
	
	public Cliente getClientePorLogin(String login){
		for (Entry<Integer, Cliente> c : repositorio.entrySet()) {
			if(c.getValue().getNome().equals(login))
				return c.getValue();
		}
		return null;
	}
	
	public void add(Cliente c){
		repositorio.put(c.getId(), c);
	}
	
	public boolean existeCliente(Cliente c) {
		if(c == null) return false;
		if(repositorio.containsKey(c.getId())){
			if(c.getSenha().compareTo(repositorio.get(c.getId()).getSenha()) == 0) return true;
			else return false;
		}
		return false;
	}
	
}
