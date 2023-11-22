package conta_bancaria.repository;

import conta_bancaria.model.Conta;
import conta_bancaria.model.CurrentAccount;
public interface ContaRepository {
	//metodos de CRUD
	
	public void procurarPorNumero(int numero);
	public void listarTodos();
	public void cadastrar(Conta conta);
	public void atualizar(Conta conta);
	public void deletar(int numero);
	
	public void saca(int numero,float valor);
	public void deposita(int numero,float valor);
	public void transferir(int numeroOrigem,int numeroDestino,float valor);
}
