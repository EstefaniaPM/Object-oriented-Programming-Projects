public class Profesor
{
	private String nombre, apellido;
	private int edad;
	private boolean casado, especialista;

	public Profesor()
	{
		this.nombre="Falta un nombre";
		this.apellido="Falta un apellido";
		this.edad=0;
		this.casado=false;
		this.especialista=false;
	}

	public Profesor(String nombre, String apellido, int edad, boolean casado, boolean especialista)
	{
		this.nombre=nombre;
		this.apellido=apellido;
		this.edad=edad;
		this.casado=casado;
		this.especialista=especialista;
	}

	public void setNombre(String nombre)
	{
		this.nombre=nombre;
	}

	public void setApellido(String apellido)
	{
		this.apellido=apellido;
	}

	public void setEdad(int edad)
	{
		this.edad=edad;
	}

	public void setCasado(boolean casado)
	{
		this.casado=casado;
	}

	public void setEspecialista(boolean especialista)
	{
		this.especialista=especialista;
	}

	public String getNombre()
	{
		return this.nombre;
	}

	public String getApellido()
	{
		return this.apellido;
	}

	public int getEdad()
	{
		return this.edad;
	}

	public boolean getCasado()
	{
		return this.casado;
	}

	public boolean getEspecialista()
	{
		return this.especialista;
	}
}