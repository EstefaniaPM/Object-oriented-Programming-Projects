//Estefania Pitol Martinez A01551688
public class Granjero{
	private String nombre, estado;

	public Granjero(String nombre){
		this.nombre=nombre;
		estado="flojeando";
	}
	public Animal cambia_estado(String nuevo_estado, Animal animal){
		if(nuevo_estado.equalsIgnoreCase("alimentando")){
			estado="alimentando";
			animal.cambia_estado("comiendo");
		}
		else{
			estado="limpiando";
			animal.cambia_estado("siendo limpiados por el granjero");
		}
		return animal;	
	}
	public String getNombre(){
		return nombre;
	}
	public String getEstado(){
		return estado;
	}
}