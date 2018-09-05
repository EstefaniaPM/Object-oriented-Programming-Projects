import java.lang.Math;
/**
Clase que describe las caracteristicas particulares de un alumno de universidad
@author JEHR
*/
public class Alumno extends Persona
{
	public final int CARRERA_DEFAULT=-1;
	public final int CARRERA_ITC=0;
	public final int CARRERA_ISD=1;
	public final int CARRERA_LAD=2;
	private int carrera;
	private Id matricula;
	/**
	Constructor vacio
	*/
	public Alumno()
	{
		super();
		this.carrera=this.CARRERA_DEFAULT;
		this.matricula=new Id();
	}
	/**
	Modifica la carrera del alumno
	@param 	c 	Nueva carrera, utilizar las constantes de clase
	*/
	public void setCarrera(int c)
	{
		this.carrera=c;
	}
	/**
	Obtiene la carrera del alumno
	@return Valor entero que representa la carrera del alumno
	*/
	public int getCarrera()
	{
		return this.carrera;
	}
	/**
	Obtiene la matricula del alumno
	@return Objeto que contiene la matricula del alumno
	*/
	public Id getMatricula()
	{
		return this.matricula;
	}
	/**
	Cambia la matrícula del alumno
	@param	i	Objeto que contiene la nueva matricula del alumno
	*/
	public void setMatricula(Id i)
	{
		this.matricula=i;
	}
	/**
	Representación impresa del alumno
	@return Cadena de texto que representa al alumno
	*/
	public String toString()
	{
		return this.matricula.toString()+" "+super.getNombre()+" "+super.getApellidoPaterno()+" "+(super.getApellidoMaterno()!="" ? super.getApellidoMaterno() : "");
	}
	/**
	Compara dos objetos de la clase Alumno
	@param 	a 	Alumno contra el que se quiere comparar
	@return		Devuelve <em>true</em> si los alumnos coinciden en matricula, y <em>false</em> si no coinciden
	*/
	public boolean equals(Alumno a)
	{
		return this.matricula.equals(a.getMatricula());
	}
	/**
	Crea una copia del alumno actual y la devuelve como objetos
	@return Copia del alumno actual
	*/
	public Alumno clone()
	{
		Alumno a=new Alumno();
		a.setNombre(super.getNombre());
		a.setApellidoPaterno(super.getApellidoPaterno());
		a.setApellidoMaterno(super.getApellidoMaterno());
		a.setAnioNac(super.getAnioNac());
		a.setMesNac(super.getMesNac());
		a.setDiaNac(super.getDiaNac());
		a.setGenero(super.getGenero());
		a.setCarrera(this.carrera);
		a.setMatricula(this.matricula);
		return a;
	}
}