public class Main
{
	public static void main(String[] args) 
	{
		Atm miAtm=new Atm();

		do
		{
			System.out.println("BIENVENIDO\nIntroduzca su numero de cuenta:");
			int usuario=miAtm.buscaNumeroCuenta();
			if(usuario>=0)
			{
				System.out.println("Introduzca su NIP:");
				if(miAtm.checaNip(usuario)==true)
				{
					int op=0;
					do
					{
						System.out.println("1. Ver saldo\n2. Retirar\n3. Depositar\n4. Salir");
						op=miAtm.menuPrincipal();
						switch(op)
						{
							case 1: miAtm.mostrarSaldo(usuario); break;
							case 2: miAtm.retiro(usuario); break;
							case 3: miAtm.deposito(usuario); break;
							case 4: System.out.println("Vuelva pronto"); break;
							default: System.out.println("Introduzca un numero valido"); break;
						}
					}
					while(op!=4);
				}
				else
					System.out.println("NIP incorrecto");
			}
			else
				System.out.println("No existe ese numero de cuenta.");
		}
		while(miAtm!=null);
	}
}