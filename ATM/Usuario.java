public class Usuario
{
	private String numeroCuenta, nip;
	private int saldo;

	public Usuario(String numeroCuenta, String nip, int saldo)
	{
		this.numeroCuenta=numeroCuenta;
		this.nip=nip;
		this.saldo=saldo;
	}

	public boolean checaNip(String nip)
	{
		boolean nipCorrecto=false;
		if(this.nip.equals(nip))
			nipCorrecto=true;
		return nipCorrecto;
	}

	public String getNumeroCuenta()
	{
		return this.numeroCuenta;
	}

	public int getSaldo()
	{
		return this.saldo;
	}
}