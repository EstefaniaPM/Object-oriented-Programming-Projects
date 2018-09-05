//Estefania Pitol Martinez A01551688
import java.util.Iterator;
import java.util.ArrayList;
public class Granja{
	private int tipos, dinero;
	private Granjero miGranjero;
	private ArrayList<Animal> misAnimales=new ArrayList<Animal>();

	public Granja(int tipos, int dinero){
		this.tipos=tipos;
		this.dinero=dinero;
		miGranjero=null;
	}
	public int getTipos(){
		return tipos;
	}
	public void aumentaTipos(int incrementa){
		tipos+=incrementa;
	}
	public int getDinero(){
		return dinero;
	}
	public void aumentaDinero(int incrementa){
		dinero+=incrementa;
	}
	public int getMisAnimales(){
		return misAnimales.size();
	}
	public ArrayList getAnimales(){
		return misAnimales;
	}
	public Granjero getGranjero(){
		return miGranjero;
	}
	public void contrataGranjero(String nombre){
		miGranjero=new Granjero(nombre);
	}
	public void despideGranjero(){
		miGranjero=null;
		for(int i=0; i<misAnimales.size(); i++)
			misAnimales.get(i).cambia_estado("en reposo");
	}
	public void incrementaAnimales(int cuantos, int index){
		misAnimales.get(index).incrementa_cantidad_en(cuantos);
		dinero=dinero-(misAnimales.get(index).getPcompra()*cuantos);
	}
	public void decrementaAnimales(int cuantos, int index){
		misAnimales.get(index).incrementa_cantidad_en(-cuantos);
		dinero=dinero+(misAnimales.get(index).getPventa()*cuantos);
	}
	public void aniadeAnimal(String nombre, int pcompra, int pventa, String alias){
		misAnimales.add(new Animal(nombre, pcompra, pventa, alias));
	}
	public boolean revisaAnimales(int cantidad, int index){
		boolean hayAnimales=false;
		if(misAnimales.get(index).getCuantos()>=cantidad)
			hayAnimales=true;
		else hayAnimales=false;
		return hayAnimales;
	}
	public boolean revisaDinero(int cantidad, int index){
		boolean alcanza=false;
		if(dinero>=(misAnimales.get(index).getPcompra()*cantidad))
			alcanza=true;
		else alcanza=false;
		return alcanza;
	}
	public int buscarAnimal(String animal){
		int i;
		for(i=0; i<misAnimales.size(); i++){
			if(misAnimales.get(i).getAlias().toLowerCase().indexOf(animal.toLowerCase())>=0)
				return i;
		}
		return -1;
	}
	public void removeAnimal(int index){
		if(misAnimales.get(index).getCuantos()==0)
			misAnimales.remove(index);
	}
	public void cambiaEstadoAnimal(int index, String estado){
		misAnimales.add(miGranjero.cambia_estado(estado, misAnimales.get(index)));
		misAnimales.remove(index);
	}
	public int animalesTotales(){
		int totales=0;
		for(int i=0; i<misAnimales.size(); i++){
			totales+=misAnimales.get(i).getCuantos();
		}
		return totales;
	}
	public String toString(){
		String texto;
		if(misAnimales.isEmpty())
			texto="No tienes animales\n";
		else{
			texto="Tienes una granja con estos animales:\n";

			if(miGranjero.getEstado().equals("alimentando"))
				for(int i=0; i<misAnimales.size(); i++){
					if(misAnimales.get(i).getEstado().equals("siendo limpiados por el granjero"))
						misAnimales.get(i).cambia_estado("en reposo");
				}
			else
				for(int i=0; i<misAnimales.size(); i++){
					if(misAnimales.get(i).getEstado().equals("comiendo"))
						misAnimales.get(i).cambia_estado("en reposo");
				}
			for(int i=0; i<misAnimales.size(); i++){
				texto+="Tus "+misAnimales.get(i).getNombre()+"s que estan "+misAnimales.get(i).getEstado()+"\n";
			}

		}
			if(miGranjero==null)
				texto+="Y no tienes granjero";
			else{
				String animales=" ";
				if(miGranjero.getEstado().equals("alimentando")){
					for(int i=0; i<misAnimales.size(); i++){
						if(misAnimales.get(i).getEstado().equals("comiendo"))
							animales+=misAnimales.get(i).getNombre()+"s, ";
					}
				}
				else{
					for(int i=0; i<misAnimales.size(); i++){
						if(misAnimales.get(i).getEstado().equals("siendo limpiados por el granjero"))
							animales+=misAnimales.get(i).getNombre()+"s, ";
					}
				}
				texto+="Y tu granjero "+miGranjero.getNombre()+" esta "+miGranjero.getEstado()+animales;
			}

		return texto;
	}
}