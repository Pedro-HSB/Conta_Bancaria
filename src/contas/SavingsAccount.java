package contas;

public class SavingsAccount extends BankAccount{

	private String dt_niver;
	private float niver;
	
	public SavingsAccount(int numero, int agencia, String tipo, String titular, float saldo,String dt_niver) {
		super(numero, agencia, tipo, titular, saldo);
		
		this.dt_niver = dt_niver;
		// TODO Auto-generated constructor stub
	}

	public String getDt_niver() {
		return dt_niver;
	}

	public void setDt_niver(String dt_niver) {
		this.dt_niver = dt_niver;
	}

	public float getNiver() {
		return niver;
	}

	public void setNiver(float niver) {
		this.niver = niver;
	}
	
	public void mesVersario(float niver)
	{
		System.out.println("\n seu saldo agora e: " + (this.getSaldo()*niver));
	}

}
