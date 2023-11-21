package contas;

public class CurrentAccount extends BankAccount{
	
	private float limite;
	
	public CurrentAccount(int numero, int agencia, String tipo, String titular, float saldo,float limite) {
		super(numero,agencia,tipo,titular,saldo);
		
		this.limite = limite;
	}
	
	public float getLimite() {
		return limite;
	}
	
	public void setLimite(int limite) {
		this.limite = limite;
	}
	
	@Override
	public boolean sacar(float valor) {
		if(this.getSaldo()+this.getLimite()<valor) {
			System.out.println("\n Saldo insuficiente");
			return false;
		}
		if(this.getLimite()<valor) {
			System.out.println("\n limite insuficiente");
			return false;
		}
		this.setSaldo(this.getSaldo()-valor);
		System.out.println("\n Valor Sacado com sucesso");
		return true;
		
	}
}	
