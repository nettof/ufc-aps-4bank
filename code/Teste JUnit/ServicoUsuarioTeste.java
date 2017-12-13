package br.com.fourbank.test;

import org.junit.Test;

import br.com.fourbank.service.ServicoTitulo;
import br.com.fourbank.service.ServicoUsuario;
import br.com.fourbank.util.cliente.Cliente;
import br.com.fourbank.util.cliente.Conta;
import br.com.fourbank.util.titulo.Titulo;

import static org.junit.Assert.*;

import java.util.Date;

public class ServicoUsuarioTeste {

	@Test
	public void singletonTest() {
		ServicoUsuario a, b;
		a = ServicoUsuario.getInstance();
		b = ServicoUsuario.getInstance();

		assertEquals(a, b);
	}

	@Test
	public void alterarTituloTest() {
		 Cliente c1 = new Cliente("Jose", "98323829", new Date(10102010), 1, "123");
	     Cliente c2 = new Cliente("Wilson", "483829", new Date(10102010), 2, "123");
		 ServicoUsuario.cadastrarUsuario(c1);
		 ServicoUsuario.cadastrarUsuario(c2);
		 
		 Titulo titulo = new Titulo(1,"Titulo 1", 600);
		 ServicoTitulo.addTitulo(titulo);
		 ServicoTitulo.setInteressadoListener(1, ServicoUsuario.getConta(c1.getId()));
		 ServicoTitulo.setInteressadoListener(1, ServicoUsuario.getConta(c2.getId()));
		 
		 ServicoTitulo.alterarTitulo(1, 300);
		 assertNotEquals(titulo.getValor(), ServicoTitulo.getTitulo(1));
	}
	
	@Test
	public void depositoTest() {
		ServicoUsuario.cadastrarUsuario(new Cliente("Natan", "037.407.353.84", new Date(), 12389, "n123"));
		Cliente c1 = ServicoUsuario.autenticar("Natan", "n123");
		Conta c = ServicoUsuario.getConta(c1.getId());
	    float saldoAnterior = c.getSaldo();
		ServicoUsuario.realizarDeposito(c1, 100);
		assertNotEquals(c.getSaldo(), saldoAnterior);
	}
	
	@Test
	public void saqueTest() {
		ServicoUsuario.cadastrarUsuario(new Cliente("Icaro", "037.407.353.84", new Date(), 12389, "n123"));
		Cliente c1 = ServicoUsuario.autenticar("Icaro", "n123");
		Conta c = ServicoUsuario.getConta(c1.getId());
	    float saldoAnterior = c.getSaldo();
		ServicoUsuario.realizarSaque(c1, 10);
		if(c.getSaldo() < 10) {
			assertEquals(c.getSaldo(), saldoAnterior, 0);
		} else assertNotEquals(c.getSaldo(), saldoAnterior, 0);
	}
	
	@Test
	public void transferenciaTest() {
		ServicoUsuario.cadastrarUsuario(new Cliente("Natan", "037.407.353.84", new Date(), 12389, "n123"));
		Cliente c1 = ServicoUsuario.autenticar("Natan", "n123");
		Conta c = ServicoUsuario.getConta(c1.getId());
	    float saldoAnterior = c.getSaldo();
	    ServicoUsuario.realizarDeposito(c1, 2000);
		ServicoUsuario.realizarTransferencia(c1, 920390, 400);
		if(c.getSaldo() < 400) {
			assertEquals(c.getSaldo(), saldoAnterior, 0);
		} else assertNotEquals(c.getSaldo(), saldoAnterior, 0);
	}
	
	@Test
	public void saqueCodigoTest() {
		Cliente c1 = new Cliente("Jose", "037.407.353.84", new Date(0), 12389, "i123");
		
		ServicoUsuario.cadastrarUsuario(c1);
		
		Cliente cli = ServicoUsuario.autenticar("Jose", "i123");
		
		ServicoUsuario.realizarDeposito(cli, 1000);
		Conta c = ServicoUsuario.getConta(cli.getId());
		float valorAntes = c.getSaldo();
		int codigo = ServicoUsuario.geraCodigoSaque(cli, 500);
		ServicoUsuario.realizarSaqueCodigo(cli, codigo);
		
		assertNotEquals(valorAntes, ServicoUsuario.getConta(cli.getId()).getSaldo(),0);
	}
}
