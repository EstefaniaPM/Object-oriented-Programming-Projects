import java.lang.Math;
/**
Clase que describe las caracteristicas particulares de un profesor de universidad
@author JEHR
*/
public class Profesor extends Persona
{
	private int area;
	private Id nomina;
	private String iniciales;
	private String homoclave;
	
	public static final int AREA_SIN_AREA = -1;
	public static final int AREA_CIENCIAS_EXACTAS = 0;
	public static final int AREA_CIENCIAS_SOCIALES = 1;
	public static final int AREA_LINGUISTICA = 2;
	public static final int AREA_ARTES = 3;
	/**
	Constructor vacio
	*/
	public Profesor()
	{
		this.area = -1;
		nomina = new Id();
		iniciales = "";
		homoclave = "";
	}
	/**
	Modifica la area del profesor
	@param 	a 	Nueva area, utilizar las constantes de clase
	*/
	public void setArea(int a)
	{
		this.area=a;
	}
	/**
	Obtiene la area del profesor
	@return Valor entero que representa la area del profesor
	*/
	public int getArea()
	{
		return this.area;
	}
	/**
	Modifica la nomina del profesor
	@param 	i 	Iniciales del profesor
	@param 	h 	Homoclave del profesor
	*/
	public void setRFC(String i, String h)
	{
		this.iniciales=i;
		this.homoclave=h;
	}
	/**
	Regresa la nomina del estudiante
	@return Cadena de texto que representa la nomina
	*/
	public String getRFC()
	{
		return
			this.iniciales + 
			LPad(super.getAnioNac() % 100,2,'0') +
			LPad(super.getMesNac(),2,'0') +
			LPad(super.getDiaNac(),2,'0') +
			this.homoclave;
	}
	/**
	Completa un numero entero para cierta cantidad de caracteres
	@param 	num 	Numero a completar
	@param 	lenght 	Longitud final de la cadena de texto
	@param	c 		Caracter de mascara
	*/
	private String LPad(int num, int length, char c)
	{
		if(num <= 0){
			String s = "";
			for(int i = 0; i < length; i++)
				s = s + c;
			return s;
		}
		int numLength = (int) Math.ceil(Math.log10(num));
		if(numLength >= length)
			return num + "";
		else{
			String s = num + "";
			for(int i = numLength; i < length; i++){
				s = c + s;
			}
			return s;
		}
	}
	/**
	Obtiene la nomina del profesor
	@return Objeto que contiene la nomina del profesor
	*/
	public Id getNomina()
	{
		return this.nomina;
	}
	/**
	Cambia la nomina del profesor
	@param	i	Objeto que contiene la nueva nomina del profesor
	*/
	public void setNomina(Id i)
	{
		this.nomina=i;
	}	
	/**
	Representación impresa del profesor
	@return Cadena de texto que representa al profesor
	*/
	public String toString()
	{
		String s = 
			this.nomina.toString() + " " +
			super.getNombre() + " " + super.getApellidoPaterno();
		if(super.getApellidoMaterno() != "")
			s = s + " " + super.getApellidoMaterno();
		s = s + " (" + this.getRFC() + ")";
		return s;
	}
	/**
	Compara dos objetos de la clase Profesor
	@param 	p 	Profesor contra la que se quiere comparar
	@return		Devuelve <em>true</em> si los profesores coinciden en el RFC y <em>false</em> si no coinciden
	*/
	public boolean equals(Profesor p)
	{
		return this.getRFC().equals(p.getRFC());
	}
}