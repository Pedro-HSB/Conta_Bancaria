package conta_bancaria.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import conta_bancaria.model.Conta;
import conta_bancaria.model.CurrentAccount;
import conta_bancaria.repository.ContaRepository;

public class ContaController implements ContaRepository {

	private ArrayList<Conta> listaContas = new ArrayList<Conta>();

	int numero = 0;

	@Override
	public void procurarPorNumero(int numero) {

		Optional<Conta> conta = buscarNaCollection(numero);

		if (conta.isPresent())
			conta.get().visualizar();
		else
			System.out.println("A Conta número: " + numero + " não foi encontrada!");
	}
	
	
	public void procurarPorNome(String nome) {
		List<Conta> listaNomes = listaContas.stream()
				.filter(c->c.getTitular().equalsIgnoreCase(nome))
				.collect(Collectors.toList());
		
		for(var conta:listaNomes)
			conta.visualizar();
	}

	@Override
	public void listarTodos() {
		for (var conta : listaContas) {
			conta.visualizar();
		}

	}

	public void cadastrar(Conta conta) {
		listaContas.add(conta);
		System.out.println(" a conta " + conta.getNumero() + " foi criada com sucesso");

	}

	public void atualizar(Conta conta) {
		// TODO Auto-generated method stub
		Optional<Conta> buscaConta = buscarNaCollection(conta.getNumero());

		if (buscaConta.isPresent())
			if (listaContas.remove(buscaConta.get()) == true)
				System.out.println("A Conta numero: " + numero + " foi excluída com sucesso!");
			else
				System.out.println("A Conta número: " + numero + " não foi encontrada!");
	}

	@Override
	public void deletar(int numero) {

		Optional<Conta> conta = buscarNaCollection(numero);

		if (conta.isPresent())
			if (listaContas.remove(conta.get()) == true)
				System.out.println("A Conta numero: " + numero + " foi excluída com sucesso!");
			else
				System.out.println("A Conta número: " + numero + " não foi encontrada!");

	}

	@Override
	public void saca(int numero, float valor) {
		// TODO Auto-generated method stub
		Optional<Conta> conta = buscarNaCollection(numero);

		if (conta.isPresent())
			if (conta.get().sacar(valor) == true)
				System.out.println("o saque na conta: " + numero + " foi efetuado com sucesso!");
			else
				System.out.println("A Conta número: " + numero + " não foi encontrada!");
	}

	@Override
	public void deposita(int numero, float valor) {
		// TODO Auto-generated method stub
		Optional<Conta> conta = buscarNaCollection(numero);

		if (conta.isPresent()) {
			conta.get().depositar(valor);
			System.out.println("o deposito na conta: " + numero + " foi efetuado com sucesso!");
		}
	}

	@Override
	public void transferir(int numeroOrigem, int numeroDestino, float valor) {
		// TODO Auto-generated method stub
		Optional<Conta> contaOrigem = buscarNaCollection(numeroOrigem);
		Optional<Conta> contaDestino = buscarNaCollection(numeroDestino);

		if (contaOrigem.isPresent() && contaDestino.isPresent())
			if (contaOrigem.get().sacar(valor) == true) {
				contaDestino.get().depositar(valor);
				System.out.println("a transferir foi efetuado com sucesso!");
			} else
				System.out.println("A Conta número: " + numero + " não foi encontrada!");
	}

	public int gerarNumero() {
		return ++numero;
	}

	public Optional<Conta> buscarNaCollection(int numero) {

		for (var conta : listaContas) {
			if (conta.getNumero() == numero)
				return Optional.of(conta);
		}

		return Optional.empty();
	}

}
