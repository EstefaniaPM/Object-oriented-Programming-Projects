/**
Esta clase controla los ejemplos propios de un identificador (matrícula y nomina)
@author JEHR
*/
public class Id
{
	private int sufijo, prefijo;
	private boolean tipo; //false=alumno, true=profesor
	private int campus;//0=Puebla, 1=Antartida
	public static final int CAMPUS_PUEBLA=0;
	private int[] PREFIJOS_PUEBLA=new int[10];
	private int PUEBLA_INDEX=3;
	private int PUEBLA_LAST=183;
	public static final int CAMPUS_ANTARTIDA=174;
	public static final boolean TIPO_ALUMNO=false;
	public static final boolean TIPO_PROFESOR=true;
	/**
	Constructor vacio
	*/
	public Id()
	{
		this.sufijo=0;
		this.prefijo=0;
		this.tipo=false;
		setPrefijos();
	}
	/**
	Constructor parametrizado
	@param 	t 	Tipo de id
	@param 	c 	Campus (consultar constantes de clase)
	*/
	public Id(boolean t, int c)
	{
		this.tipo=t;
		this.campus=c;
	}
    /**
    Modifica el prefijo del ID
    */
    public void setPrefijos()
    {
      	this.PREFIJOS_PUEBLA[0]=109;
		this.PREFIJOS_PUEBLA[1]=132;
		this.PREFIJOS_PUEBLA[2]=173;
    }
	/**
	Modifica el prefijo de matricula del alumno
	@param	p	Nuevo prefijo, entero a 4 posiciones
	*/
	public void setPrefijo(int p)
	{
		this.prefijo = p;
	}
	/**
	Obtiene el prefijo de matricula del alumno	
	@return	Valor entero que representa la carrera del alumno
	*/
	public int getPrefijo()
	{
		return this.prefijo;
	}
    /**
    Modifica el campus del ID
    @param c Nuevo campus
    */
    public void setCampus(int c)
    {
      this.campus=c;
    }
    /**
    Obtiene el campus del ID
    @return Numero que representa al campus
    */
    public int getCampus()
    {
      return this.campus;
    }  
    /**
	Genera la siguiente matricula correspondiente al campus
    */
    public void getNext()
    {
    	switch(this.campus)
    	{
    		case 0://Puebla
    			if(this.PUEBLA_LAST==9999)
    			{
    				this.PUEBLA_LAST=0;
    				this.PUEBLA_INDEX++;
    			}
    			this.prefijo=this.PREFIJOS_PUEBLA[this.PUEBLA_INDEX-1];
    			this.sufijo=++this.PUEBLA_LAST;
    			break;
    	}
    }
    /**
    Modifica el sufijo del ID
    @param s Nuevo sufijo, entero de 4 digitos
    */
    public void setSufijo(int s)
    {
      this.sufijo=s;
    }
    /**
    Obtiene el sufijo del ID
    @return Sufijo
    */
    public int getSufijo()
    {
      return this.sufijo;
    }
    /**
    Modifica el tipo del ID
    @param t Nuevo tipo
    */
    public void setTipo(boolean t)
    {
      this.tipo=t;
    }
    /**
    Obtiene el tipo del ID
    @return Boolean que representa el tipo de persona
    */
    public boolean getTipo()
    {
      return this.tipo;
    }
	/**
	Modifica el ID
	@param	p	Prefijo del campus (4 numeros max)
	@param	s	Sufijo consecutivo del alumno (4 numeros max)
	@param 	t 	Tipo de persona
	*/
    public void setId(int p, int s, boolean t)
    {
		this.prefijo=p;
		this.sufijo=s;
		this.tipo=t;
	}
    /**
	Completa un numero entero para cierta cantidad de caracteres
	@param 	num 	Numero a completar
	@param 	lenght 	Longitud final de la cadena de texto
	@param	c 		Caracter de mascara
	*/
	private String LPad(int num, int length, char c)
	{
		if(num<=0)
		{
	        String s="";
	        for(int i=0; i<length; i++)
	        s+=c;
	        return s;
    	}
		int numLength=(int)Math.ceil(Math.log10(num));
		if(numLength>=length)
			return num+"";
		else
		{
			String s=num+"";
			for(int i=numLength; i<length; i++)
			{
				s=c+s;
			}
			return s;
		}
	}
	/**
	Compara dos objetos de la clase Id
	@param 	i 	Id contra la que se quiere comparar
	@return		Devuelve <em>true</em> si los Id coinciden en prefijo, sufijo y tipo, y <em>false</em> si no coinciden
	*/
	public boolean equals(Id i)
	{
		return 
        	this.prefijo == i.getPrefijo() &&
			this.sufijo == i.getSufijo() &&
			this.tipo == i.getTipo();
	}
	/**
	Regresa la matrícula del estudiante
	@return	Cadena de texto que representa la matricula
	*/
	public String toString(){
		return (this.tipo ? "L" : "A") + LPad(this.prefijo,4,'0') + LPad(this.sufijo, 4, '0');
	}
	/**
	Crea una copia del ID y la devuelve como objeto
	@return Copia del ID actual
	*/
	public Id clone()
	{
		Id i=new Id();
		i.setPrefijo(this.prefijo);
		i.setSufijo(this.sufijo);
		i.setCampus(this.campus);
		i.setTipo(this.tipo);
		return i;
	}
    /**
	Busca la matricula de los datos elegidos
	@param 	campus 	Campus de la matricula
	@param 	tipo 	Tipo de persona alumno/profesor
	@param	sufijo 	Sufijo de la matricula que se desea encontrar
	@return String que representa la matricula solicitada
	*/
	public String buscarMatricula(int campus, boolean tipo, int sufijo){
		int prefijo = 0;
		switch(campus){
			case Id.CAMPUS_PUEBLA:
				prefijo = this.PREFIJOS_PUEBLA[this.PUEBLA_INDEX-1];
				break;
		
		}
		return (tipo ? "L" : "A") + LPad(prefijo,4,'0') + LPad(sufijo, 4, '0');
	}
    /**
	Busca la matricula de los datos elegidos
	@param 	campus 	Campus de la matricula
	@param 	tipo 	Tipo de persona alumno/profesor
	@param	sufijo 	Sufijo de la matricula que se desea encontrar
	@param 	retro 	Indica la antiguedad de la matricula que quieres obtener
	@return String que representa la matricula solicitada
	*/
	public String buscarMatricula(int campus, boolean tipo, int sufijo, int retro){
		int max = 0;
		switch(campus){
			case Id.CAMPUS_PUEBLA:
				max = this.PUEBLA_INDEX;
			break;
		}
		if(retro < 0){
			System.out.println("Error: retro debe ser positivo");
			return "";
		}
		else if(retro >= max){
			System.out.println("Error: Fuera del limite, el campus solo tiene " + max + " prefijos");
			return "";
		}
		else if(retro == 0){
			System.out.println("Warning: Podria considerar usar el metodo sin el valor retroactivo");
		}
		int prefijo = 0;
		switch(campus){
			case Id.CAMPUS_PUEBLA:
				prefijo = this.PREFIJOS_PUEBLA[this.PUEBLA_INDEX-1-retro];
				break;
		
		}
		return (tipo ? "L" : "A") + LPad(prefijo,4,'0') + LPad(sufijo, 4, '0');
	}
}