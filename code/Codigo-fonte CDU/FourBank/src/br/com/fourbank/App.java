package br.com.fourbank;

import java.sql.Date;

import br.com.fourbank.service.ServicoUsuario;
import br.com.fourbank.util.cliente.Cliente;

public class App {

	public static void main(String[] args) {
		Cliente c1 = new Cliente("Icaro", "037.407.353.84", new Date(0), 12389, "i123");
		Cliente c2 = new Cliente("Joao", "037.407.353.84", new Date(0), 13779, "i123");
		
		ServicoUsuario.cadastrarUsuario(c1);
		ServicoUsuario.cadastrarUsuario(c2);
		
		Cliente cli = ServicoUsuario.autenticar("Icaro", "i123");
		
		ServicoUsuario.realizarDeposito(cli, 200);
		ServicoUsuario.realizarSaque(cli, 50);
		ServicoUsuario.realizarTransferencia(cli, 13779, 12);
		ServicoUsuario.realizarDeposito(cli, 1000);
		
		//MULTIBANK - TAA
		int codigo = ServicoUsuario.geraCodigoSaque(cli, 500);
		ServicoUsuario.realizarSaqueCodigo(cli, codigo);
		
		System.out.println("\n");
		ServicoUsuario.emitirExtrato(cli);
		System.out.println("\n");
		ServicoUsuario.emitirExtrato(ServicoUsuario.autenticar("Joao", "i123"));
	}
}
