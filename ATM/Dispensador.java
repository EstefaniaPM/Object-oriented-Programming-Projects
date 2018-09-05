public class Dispensador
{
	private int dineroTotal;
	
	private Billetes b20=new Billetes(20, 0);
	private Billetes b50=new Billetes(50, 0);
	private Billetes b100=new Billetes(100, 0);
	private Billetes b200=new Billetes(200, 0);
	private Billetes b500=new Billetes(500, 0);
	private Billetes b1000=new Billetes(1000, 0);

	public void Dispensador()
	{
		b20.aumentaCantidad(500);
	}

	public int dineroTotal()
	{
		int t=0;

		t+=b20.getDineroTotal();
		t+=b50.getDineroTotal();
		t+=b100.getDineroTotal();
		t+=b200.getDineroTotal();
		t+=b500.getDineroTotal();
		t+=b1000.getDineroTotal();
		
		return t;
	}

	public void nuevoDia()
	{
		b20.aumentaCantidad(500);
	}
}