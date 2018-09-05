/**
Clase que define las caraterísticas generales de una persona
@author		JEHR
@version	1.0
*/
public class Persona
{
	private String nombre, aPaterno, aMaterno;
	private int anioNac, mesNac, diaNac;
	private boolean genero; // false=m, true=f

	/**
	Constructor vacio
	*/
	public Persona()
	{
		this.nombre="";
		this.aPaterno="";
		this.aMaterno="";
		this.anioNac=1900;
		this.mesNac=1;
		this.diaNac=1;
		this.genero=true;
	}
	/**
	Constructor parametrizado
	@param 	n	Nombbre de la persona
	@param 	aPa Apellido paterno de la persona
	@param 	aMa Apellido materni de la persona
	@param 	an 	Anio de nacimiento de la persona
	@param 	m 	Mes de nacimiento de la persona
	@param 	d 	Dia de nacimiento de la persona
	@param 	g 	Genero de la persona
	*/
	public Persona(String n, String aPa, String aMa, int an, int m, int d, boolean g)
	{
		this.nombre=n;
		this.aPaterno=aPa;
		this.aMaterno=aMa;
		this.anioNac=an;
		this.mesNac=m;
		this.diaNac=d;
		this.genero=g;
	}
	/**
	Modifica el nombre de la persona
	@param 	n 	Nuevo nombre de la persona
	*/
	public void setNombre(String n)
	{
		this.nombre=n;
	}
	/**
	Regresa el nombre de la persona
	@return Nombre actual de la persona
	*/
	public String getNombre()
	{
		return this.nombre;
	}
	/**
	Modifica el apellido paterno de la persona
	@param 	aPa		Nuevo apellido paterno de la persona
	*/
	public void setApellidoPaterno(String aPa)
	{
		this.aPaterno=aPa;
	}
	/**
	Regresa el apellido paterno de la persona
	@return Apellido paterno actual de la persona
	*/
	public String getApellidoPaterno()
	{
		return this.aPaterno;
	}
	/**
	Modifica el apellido materno de la persona
	@param 	aMa 	Nuevo apellido materno de la persona
	*/
	public void setApellidoMaterno(String aMa)
	{
		this.aMaterno=aMa;
	}
	/**
	Regresa el apellido materno de la persona
	@return Apellido materno actual de la persona
	*/
	public String getApellidoMaterno()
	{
		return this.aMaterno;
	}
	/**
	Modifica el anio de nacimiento de la persona
	@param 	an 	Nuevo anio de nacimiento de la persona
	*/
	public void setAnioNac(int an)
	{
		this.anioNac=an;
	}
	/**
	Regresa el anio de nacimiento de la persona
	@return Anio de nacimiento actual de la persona
	*/
	public int getAnioNac()
	{
		return this.anioNac;
	}
	/**
	Modifica el mes de nacimiento de la persona
	@param 	m 	Nuevo mes de nacimiento de la persona
	*/
	public void setMesNac(int m)
	{
		this.mesNac=m;
	}
	/**
	Regresa el mes de nacimiento de la persona
	@return Mes de nacimiento actual de la persona
	*/
	public int getMesNac()
	{
		return this.mesNac;
	}
	/**
	Modifica el dia de nacimiento de la persona
	@param 	d 	Nuevo dia de nacimiento de la persona
	*/
	public void setDiaNac(int d)
	{
		this.diaNac=d;
	}
	/**
	Regresa el dia de nacimiento de la persona
	@return Dia de nacimiento actual de la persona
	*/
	public int getDiaNac()
	{
		return this.diaNac;
	}
	/**
	Modifica el genero de la persona
	@param 	g 	Nuevo genero de la persona
	*/
	public void setGenero(boolean g)
	{
		this.genero=g;
	}
	/**
	Regresa el genero de la persona
	@return Genero actual de la persona
	*/
	public boolean getGenero()
	{
		return this.genero;
	}
	/**
	Representación impresa de la persona
	@return Cadena de texto que representa a la persona
	*/
	public String toString()
	{
		return this.nombre+" "+this.aPaterno+" "+(this.aMaterno!="" ? " "+this.aMaterno : "");
	}
	/**
	Compara dos objetos de la clase Persona
	@param 	p 	Persona contra la que se quiere comparar
	@return		Devuelve <em>true</em> si las personas coinciden en nombre, apellido paterno, fecha de nacimiento y genero, y <em>false</em> si no coinciden
	*/
	public boolean equals(Persona p)
	{
		return 
			this.nombre.equals(p.getNombre()) &&
			this.aPaterno.equals(p.getApellidoMaterno()) &&
			this.anioNac==p.getAnioNac() &&
			this.mesNac==p.getMesNac() &&
			this.diaNac==p.getDiaNac() &&
			this.genero==p.getGenero();
	}
	/**
	Crea una copia de la Persona actual y la devuelve como objetos
	@return Copia de la persona actual
	*/
	public Persona clone()
	{
		return new Persona(this.nombre, this.aPaterno, this.aMaterno, this.anioNac, this.mesNac, this.diaNac, this.genero);
	}
}