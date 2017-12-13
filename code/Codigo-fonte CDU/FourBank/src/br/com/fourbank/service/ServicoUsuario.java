package br.com.fourbank.service;

import br.com.fourbank.repositorio.RepositorioCliente;
import br.com.fourbank.repositorio.RepositorioConta;
import br.com.fourbank.util.Cliente;
import br.com.fourbank.util.Conta;
import br.com.fourbank.util.Deposito;
import br.com.fourbank.util.Movimento;
import br.com.fourbank.util.Saque;
import br.com.fourbank.util.TipoMovimentar;
import br.com.fourbank.util.Transacao;
import br.com.fourbank.util.Transferencia;

public class ServicoUsuario {
	
	private static ServicoUsuario servicoUsuario;
	private static RepositorioCliente repositorioCliente = new RepositorioCliente();
	private static RepositorioConta repositorioConta = new RepositorioConta();
	
	public static Cliente autenticar(String login, String senha) {
		Cliente c = repositorioCliente.getClientePorLogin(login);
		if (c != null && c.getSenha().equals(senha))
			return c;
		else
			return null;
	}
	
	public static Conta getConta(int id) {
		return repositorioConta.getConta(id);
	}
	
	public static void cadastrarUsuario(Cliente c) {
		repositorioCliente.add(c);
		Conta co = new Conta();
		co.setNumConta(c.getId());
		co.setCliente(c);
		co.setSaldo(0);
		repositorioConta.add(c.getId(), co);
	}
	
	public static synchronized ServicoUsuario getInstance(){
		if(servicoUsuario == null) servicoUsuario = new ServicoUsuario();
		return servicoUsuario;
	}
	
	public static void realizarSaque(Cliente c, float valor) {
		if(repositorioCliente.existeCliente(c)) {
			Conta conta = repositorioConta.getConta(c.getId());
			if(conta == null) return;
			if(conta.getSaldo() < valor) {
				System.out.println("Valor de saque superior ao seu saldo");
				return;
			}
			Transacao t = new Saque(conta, valor);
			t.transacao();
			repositorioConta.update(c.getId(), conta);
			conta.addMovimento(TipoMovimentar.SAQUE, "Realização de saque", valor);
			System.out.println("Saque realizado!");
		}
	}
	
	public static int geraCodigoSaque(Cliente c, float valor) {
		if(repositorioCliente.existeCliente(c)) {
			Conta conta = repositorioConta.getConta(c.getId());
			if(conta == null) return 0;
			if(conta.getSaldo() < valor) {
				System.out.println("Valor de saque superior ao seu saldo");
				return 0;
			}
			Transacao t = new Saque(conta, valor);
			return ServicoMultiBank.geraCodigoSaque(t);
		}
		return 0;
	}
	
	public static void realizarSaqueCodigo(Cliente c, int codigo) {
		if(repositorioCliente.existeCliente(c)) {
			Conta conta = repositorioConta.getConta(c.getId());
			if(conta == null) return;
			float valorAntes = conta.getSaldo();
			ServicoMultiBank.realizarTransacao(codigo);
			repositorioConta.update(c.getId(), conta);
			conta.addMovimento(TipoMovimentar.SAQUE, "Realização de saque", valorAntes - conta.getSaldo());
			System.out.println("Saque realizado!");
		}
	}
	
	public static void realizarDeposito(Cliente c, float valor) {
		if(repositorioCliente.existeCliente(c)) {
			Conta conta = repositorioConta.getConta(c.getId());
			if(conta == null) return;
			Transacao t = new Deposito(conta, valor);
			t.transacao();
			repositorioConta.update(c.getId(), conta);
			conta.addMovimento(TipoMovimentar.DEPOSITO, "Realização de depósito", valor);
			System.out.println("Depósito realizado!");
		}
	}
	
	public static void realizarTransferencia(Cliente c, int numContaDestino, float valor) {
		if(repositorioCliente.existeCliente(c)) {
			Conta conta = repositorioConta.getConta(c.getId());
			if(conta == null) return;
			if(conta.getSaldo() < valor) {
				System.out.println("Valor de transferencia superior ao seu saldo");
				return;
			}
			Conta contaDestino = new Conta();
			contaDestino.setNumConta(numContaDestino);
			Transacao t = new Transferencia(conta, contaDestino, valor);
			t.transacao();
			repositorioConta.update(c.getId(), conta);
			if(repositorioConta.existeConta(contaDestino))
				repositorioConta.update(contaDestino.getNumConta(), contaDestino);
			conta.addMovimento(TipoMovimentar.TRANSFERENCIA, "Realização de transferencia", valor);
			System.out.println("Transferência realizada!");
		}
	}
	
	public static void emitirExtrato(Cliente c) {
		if(repositorioCliente.existeCliente(c)) {
			Conta conta = repositorioConta.getConta(c.getId());
			if(conta == null) return;
			System.out.println("\t-Extrato-");
			System.out.println("Nome: " + c.getNome() + "\nNumero da conta: "+conta.getNumConta()+"\n");
			for(Movimento m: conta.getMovimento()) {
				System.out.println(m.getDescricao() + "\t" + m.getValor());
			}
			System.out.println("Saldo: "+conta.getSaldo());
		}
	}

}