public class Billetes
{
	private int valor;
	private int cantidad;

	public Billetes(int valor, int cantidad)
	{
		this.valor=valor;
		this.cantidad=cantidad;
	}

	public int getValor()
	{
		return this.valor;
	}

	public int getCantidad()
	{
		return this.cantidad;
	}

	public int getDineroTotal()
	{
		return this.valor*this.cantidad;
	}

	public void aumentaCantidad(int c)
	{
		this.cantidad+=c;
	}
}