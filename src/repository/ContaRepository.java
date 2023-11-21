package repository;

import contas.CurrentAccount;
public interface ContaRepository {
	//metodos de CRUD
	
	public void procurarPorNumero(int numero);
	public void listarTodos();
	public void cadastrar(CurrentAccount conta);
	public void atualizar(CurrentAccount conta);
	public void deletar(int numero);
	
	public void saca(int numero,float valor);
	public void deposita(int numero,float valor);
	public void transferir(int numeroOrigem,int numeroDestino,float valor);
}
