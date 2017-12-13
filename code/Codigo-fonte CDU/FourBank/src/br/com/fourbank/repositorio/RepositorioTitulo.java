package br.com.fourbank.repositorio;

import java.util.HashMap;
import java.util.Map;

import br.com.fourbank.util.titulo.Titulo;

public class RepositorioTitulo {
   
	private Map<Integer, Titulo> list = new HashMap<Integer, Titulo>();

	public void setTitulo(Titulo titulo){
		list.put(titulo.getId(), titulo);
	}
	
	public boolean existeTitulo(int id) {
		if(list.containsKey(id)) return true;
		return false;
	}
	
	public Titulo getTitulo(int id) {
		return list.get(id);
	}
	
	public void alterarTitulo(int idTitulo, Titulo titulo){
		list.put(idTitulo, titulo);
	}
}
