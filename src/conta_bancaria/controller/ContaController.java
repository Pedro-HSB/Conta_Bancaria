package conta_bancaria.controller;

import java.util.ArrayList;

import conta_bancaria.model.Conta;
import conta_bancaria.model.CurrentAccount;
import conta_bancaria.repository.ContaRepository;

public class ContaController implements ContaRepository {

	private ArrayList<Conta> listaContas = new ArrayList<Conta>();

	int numero = 0;

	@Override
	public void procurarPorNumero(int numero) {

		var conta = buscarNaCollection(numero);

		if (conta != null)
			conta.visualizar();
		else
			System.out.println("A Conta número: " + numero + " não foi encontrada!");
	}

	@Override
	public void listarTodos() {
		for (var conta : listaContas) {
			conta.visualizar();
		}

	}

	public void cadastrar(Conta conta) {
		listaContas.add(conta);
		System.out.println("a conta " + conta.getNumero() + " foi criada com sucesso");

	}

	public void atualizar(Conta conta) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deletar(int numero) {

		var conta = buscarNaCollection(numero);

		if (conta != null)
			if (listaContas.remove(conta) == true)
				System.out.println("A Conta numero: " + numero + " foi excluída com sucesso!");
			else
				System.out.println("A Conta número: " + numero + " não foi encontrada!");

	}

	@Override
	public void saca(int numero, float valor) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deposita(int numero, float valor) {
		// TODO Auto-generated method stub

	}

	@Override
	public void transferir(int numeroOrigem, int numeroDestino, float valor) {
		// TODO Auto-generated method stub

	}

	public int gerarNumero() {
		return ++numero;
	}

	public Conta buscarNaCollection(int numero) {

		for (var conta : listaContas) {
			if (conta.getNumero() == numero)
				return conta;
		}

		return null;
	}

}
