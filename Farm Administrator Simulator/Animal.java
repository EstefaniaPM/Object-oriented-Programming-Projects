//Estefania Pitol Martinez A01551688
public class Animal{

	private String nombre, estado, alias;
	private int pcompra, pventa, cuantos;

	public Animal(String nombre, int pcompra, int pventa, String alias){
		this.nombre=nombre;
		this.pcompra=pcompra;
		this.pventa=pventa;
		this.alias=alias+", "+nombre;
		cuantos=0;
		estado="en reposo";
	}
	public String getAlias(){
		return alias;
	}
	public int getPcompra(){
		return pcompra;
	}
	public int getPventa(){
		return pventa;
	}
	public int getCuantos(){
		return cuantos;
	}
	public String getEstado(){
		return estado;
	}
	public String getNombre(){
		return nombre;
	}
	public void incrementa_cantidad_en(int n){
		cuantos=cuantos+n;
	}
	public void cambia_estado(String nuevo_estado){
		estado=nuevo_estado;
	}
}