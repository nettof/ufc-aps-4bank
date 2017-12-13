package br.com.fourbank.service;

import br.com.fourbank.repositorio.RepositorioTitulo;
import br.com.fourbank.util.Titulo;
import br.com.fourbank.util.TituloListener;

public class ServicoTitulo {

	private static ServicoTitulo servicoTitulo;
	private static RepositorioTitulo repositorioTitulo = new RepositorioTitulo();
	
	public static synchronized ServicoTitulo getInstance(){
		if(servicoTitulo == null) servicoTitulo = new ServicoTitulo();
		return servicoTitulo;
	}
	
	public static void addTitulo(Titulo titulo){
		repositorioTitulo.setTitulo(titulo);
	}
	
	public static void setInteressadoListener(int idTitulo, TituloListener tl){
		if(repositorioTitulo.existeTitulo(idTitulo)) {
		    Titulo titulo = repositorioTitulo.getTitulo(idTitulo);
		    if(titulo != null) {
		    	titulo.addListener(tl);
		    	repositorioTitulo.alterarTitulo(idTitulo, titulo);
		    }
		}
	}
	
	public static void alterarTitulo(int idTitulo, float valor) {
		if(repositorioTitulo.existeTitulo(idTitulo)) {
		    Titulo titulo = repositorioTitulo.getTitulo(idTitulo);
		    if(titulo != null) {
		    	titulo.setValor(valor);
		    	repositorioTitulo.alterarTitulo(idTitulo, titulo);
		    }
		}
	}
	
	public static Titulo getTitulo(int id) {
		return repositorioTitulo.getTitulo(id);
	}
}
