//Estefania Pitol Martinez A01551688
import java.util.*;
public class Main{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);

		System.out.println("Cuantos tipos de animales se podran tener en la granja?");
		int tipos=sc.nextInt();
		System.out.println("Con cuantos pesos se inicia la granja");
		int dinero=sc.nextInt();
		
		Granja miGranja=new Granja(tipos, dinero);

		int op;

		do{
			System.out.println("MENU");
			System.out.println("1. Contratar un granjero");
			System.out.println("2. Despedir un granjero");
			System.out.println("3. Comprar animal(es)");
			System.out.println("4. Vender animal(es)");
			System.out.println("5. Alimentar animales");
			System.out.println("6. Limpiar animales");
			System.out.println("7. Mostrar estado de la granja");
			System.out.println("8. Ver mi capital");
			System.out.println("9. Extender la granja");
			System.out.println("0. Salir");
			op=sc.nextInt();
			switch(op){
				case 1:
				if(miGranja.getGranjero()==null){
					System.out.println("Nombre del granjero:");
					sc.nextLine();
					String nombre=sc.nextLine();
					miGranja.contrataGranjero(nombre);
				}
				else{
					System.out.println("Seguro que quieres despedir a "+miGranja.getGranjero().getNombre()+"?");
					sc.nextLine();
					if(sc.nextLine().equalsIgnoreCase("si")){
						miGranja.despideGranjero();
						System.out.println("Nombre del nuevo granjero:");
						String nombre=sc.nextLine();
						miGranja.contrataGranjero(nombre);
					}
					else
						System.out.println("Tu granjero sigue siendo "+miGranja.getGranjero().getNombre());
				}
				break;
				case 2:
				if(miGranja.getGranjero()==null)
					System.out.println("No has contratado ningun granjero");
				else{
					System.out.println("Seguro que quieres despedir a "+miGranja.getGranjero().getNombre()+"?");
					sc.nextLine();
					if(sc.nextLine().equalsIgnoreCase("si"))
						miGranja.despideGranjero();
					else
						System.out.println("Tu granjero sigue siendo "+miGranja.getGranjero().getNombre());
				}
				System.out.println("Recuerda que tienes "+miGranja.animalesTotales()+" animales en total");
				break;
				case 3:
				System.out.println("Que tipo de animal quieres comprar?");
				sc.nextLine();
				String tipo=sc.nextLine();
				if(miGranja.buscarAnimal(tipo)>=0){
					System.out.println("Cuantos quieres comprar?");
					int cuantos=sc.nextInt();
					if(miGranja.revisaDinero(cuantos, miGranja.buscarAnimal(tipo))==true)
						miGranja.incrementaAnimales(cuantos, miGranja.buscarAnimal(tipo));
					else 
						System.out.println("No tienes suficiente dinero");
				}
				else{
					if(miGranja.getMisAnimales()>=miGranja.getTipos())
						System.out.println("Necesitas extender tu granja");
					else{
						String nombre=tipo;
						System.out.println("Cual sera su precio de compra?");
						int pcompra=sc.nextInt();
						System.out.println("Cual sera su precio de venta?");
						int pventa=sc.nextInt();
						System.out.println("Escribe sus alias separandolas con comas:");
						sc.nextLine();
						String alias=sc.nextLine();
						miGranja.aniadeAnimal(nombre, pcompra, pventa, alias);
						System.out.println("Cuantos quieres comprar?");
						int cuantos=sc.nextInt();
						if(miGranja.revisaDinero(cuantos, miGranja.buscarAnimal(nombre))==true)
							miGranja.incrementaAnimales(cuantos, miGranja.buscarAnimal(nombre));
						else 
							System.out.println("No tienes suficiente dinero");
					}
				}
				break;
				case 4:
				if(miGranja.getAnimales().isEmpty())
					System.out.println("No tienes animales");
				else{
					System.out.println("Que animal quieres vender?");
					sc.nextLine();
					String animal=sc.nextLine();
					if(miGranja.buscarAnimal(animal)>=0){
						System.out.println("Cuantos quieres vender?");
						int cuantos=sc.nextInt();
						if(miGranja.revisaAnimales(cuantos, miGranja.buscarAnimal(animal))==true){
							miGranja.decrementaAnimales(cuantos, miGranja.buscarAnimal(animal));
							miGranja.removeAnimal(miGranja.buscarAnimal(animal));
						}
						else
							System.out.println("No tienes suficientes animales");
					}
					else
						System.out.println("No tienes animal con ese nombre o alias");
				}
				break;
				case 5:
				if(miGranja.getGranjero()==null)
					System.out.println("No tienes granjero");
				else{
					if(miGranja.getAnimales().isEmpty())
						System.out.println("No tienes animales");
					else{
						System.out.println("Cuantos animales quieres alimentar?");
						int n=sc.nextInt();
						System.out.println("Enlista los animales que quieres alimentar:");
						sc.nextLine();
						for(int i=0; i<n; i++){
							String animalito=sc.nextLine();
							if(miGranja.buscarAnimal(animalito)>=0)
								miGranja.cambiaEstadoAnimal(miGranja.buscarAnimal(animalito), "alimentando");
							else
								System.out.println("No se encontraron animales");
						}
					}
				}
				break;
				case 6:
				if(miGranja.getGranjero()==null)
					System.out.println("No tienes granjero");
				else{
					if(miGranja.getAnimales().isEmpty())
						System.out.println("No tienes animales");
					else{
						System.out.println("Cuantos animales quieres limpiar?");
						int nn=sc.nextInt();
						System.out.println("Enlista los animales que quieres limpiar:");
						sc.nextLine();
						for(int i=0; i<nn; i++){
							String animalito=sc.nextLine();
							if(miGranja.buscarAnimal(animalito)>=0)
								miGranja.cambiaEstadoAnimal(miGranja.buscarAnimal(animalito), "limpiando");
							else
								System.out.println("No se encontraron animales");
						}
					}
				}
				break;
				case 7:
				System.out.println(miGranja);
				break;
				case 8:
				System.out.println("Tienes "+miGranja.getDinero()+" pesos");
				break;
				case 9:
				System.out.println("Cuanto dinero quieres agregar?");
				int aumenta=sc.nextInt();
				miGranja.aumentaDinero(aumenta);
				System.out.println("Cuantos tipos de animales mas quieres poder tener?");
				int incrementa=sc.nextInt();
				miGranja.aumentaTipos(incrementa);
				break;
			}
		}while(op!=0);
	}
}