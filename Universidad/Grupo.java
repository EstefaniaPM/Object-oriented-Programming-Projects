public class Grupo
{
	private String nombre;
	private Profesor titular;
	private Alumno[] lista;
	private int noAlumnos;
	/**
	Constructor vacio
	*/
	public Grupo()
	{
		this.nombre="Grupo default";
		this.titular=new Profesor();
		this.lista=new Alumno[5];
		this.noAlumnos=0;
	}
	/**
	Constructor parametrizado
	@param 	n 		Nombre de la clase
	@param 	cupo 	Cupo de la clase
	*/
	public Grupo(String n, int cupo)
	{
		this.nombre=n;
		this.titular=new Profesor();
		this.lista=new Alumno[cupo];
		this.noAlumnos=0;
	}
	/**
	Modifica el profesor de la clase
	@param 	p 	Nuevo profesor
	*/
	public void setProfesor(Profesor p)
	{
		this.titular=p;
	}
	/**
	Obtiene  el profesor de la clase
	@return Los datos del profesor de la clase
	*/
	public Profesor getProfesor()
	{
		return this.titular;
	}
	/**
	Agrega un nuevo alumno a la clase
	@param 	a 	Nuevo alumno
	*/
	public boolean addAlumno(Alumno a)
	{
		if(noAlumnos>=this.lista.length)
			return false;
		else
		{
			this.lista[noAlumnos]=a;
			this.noAlumnos++;
			return true;
		}
	}
	/**
	Representación impresa del grupo
	@return Cadena de texto que representa al grupo
	*/
	public String toString()
	{
		String res="";
		res=res+"==============================================\n";
		res=res+"    "+this.nombre+"\n";
		res=res+"    Profesor: "+this.titular.toString()+"\n";
		res=res+"    Poblacion: "+this.noAlumnos+"\n";
		res=res+"==============================================\n";
		for(int i=0; i<this.noAlumnos; i++)
		{
			res=res+"    "+this.lista[i].toString()+"\n";
		}
		res=res+"==============================================\n";
		return res;
	}
	/**
	Obtiene si aun queda cupo en el grupo
	@return Boolean que representa si el grupo tiene cupo (true) o no (false)
	*/
	public boolean tieneCupo()
	{
		return this.noAlumnos<this.lista.length;
	}
}