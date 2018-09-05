import java.util.Scanner;
public class Atm
{
	private Scanner sc=new Scanner(System.in);
	private Dispensador miDispensador;
	private Usuario misUsuarios[];

	public Atm()
	{
		miDispensador=new Dispensador();
		misUsuarios=new Usuario[3];
		misUsuarios[0]=new Usuario("00000", "00000", 0);
		misUsuarios[1]=new Usuario("11111", "11111", 0);
		misUsuarios[2]=new Usuario("22222", "22222", 0);
	}

	public int buscaNumeroCuenta()
	{
		int existe=-1;
		String numeroCuenta=sc.nextLine();
		for(int i=0; i<misUsuarios.length; i++)
		{
			if(misUsuarios[i].getNumeroCuenta().equals(numeroCuenta))
				existe=i;
		}
		return existe;
	}

	public boolean checaNip(int index)
	{
		String nip=sc.nextLine();
		return misUsuarios[index].checaNip(nip);
	}

	public int menuPrincipal()
	{
		int op=sc.nextInt();
		sc.nextLine();
		return op;
	}

	public void mostrarSaldo(int index)
	{
		System.out.println("Tu saldo es de: $"+misUsuarios[index].getSaldo());
	}

	public void retiro(int index)
	{
		System.out.println("Retiraste");
	}

	public void deposito(int index)
	{
		System.out.println("Depositaste");
	}
}