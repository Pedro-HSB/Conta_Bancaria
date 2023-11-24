package conta_bancaria.model;

public class CurrentAccount extends Conta {

	private float limite;

	public CurrentAccount(int numero, int agencia, int tipo, String titular, float saldo, float limite) {
		super(numero, agencia, tipo, titular, saldo);

		this.limite = limite;
	}

	public float getLimite() {
		if (this.getSaldo() < 0)
			return this.limite - Math.abs(this.getSaldo());

		return limite;
	}

	public void setLimite(int limite) {
		this.limite = limite;
	}

	@Override
	public boolean sacar(float valor) {
		if (this.getSaldo() + this.getLimite() < valor) {
			System.out.println("\n Saldo insuficiente");
			return false;
		}
		if (this.getLimite() < valor) {
			System.out.println("\n limite insuficiente");
			return false;
		}
		this.setSaldo(this.getSaldo() - valor);
		System.out.println("\n Valor Sacado com sucesso");
		return true;

	}

	@Override
	public void visualizar() {
		super.visualizar();
		System.out.println("Limite da conta: " + this.getLimite());
	}
}
