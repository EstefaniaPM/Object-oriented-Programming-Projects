public class Mazo
{
	private Carta[] cartas;
	private int noCartas;
	/**
	Constructor vacio
	Construye un mazo con 52 cartas, 13 de cada palo
	*/
	public Mazo()
	{
		int pos=0;
		this.cartas=new Carta[52];

		for(int i=Carta.PALO_DIAMANTE; i<=Carta.PALO_ESPADA; i++)
			for(int j=Carta.FIGURA_AS; j<=Carta.FIGURA_REY; j++)
				cartas[pos++]=new Carta(i, j);

		this.noCartas=52;
	}
	/**
	Constructor parametrizado
	@param cs Arreglo de cartas
	*/
	public Mazo(Carta[] cs)
	{
		this.cartas=cs;
		this.noCartas=cs.length;
	}
	/**
	Accesor para cartas del mazo
	@return Arreglo de cartas del mazo
	*/
	public Carta[] getCartas()
	{
		return this.cartas;
	}
	/**
	Accesor para el numero de cartas del mazo
	@return Numero de cartas del mazo
	*/
	public int count()
	{
		return this.noCartas;
	}
	/**
	Shuffling de las cartas en el mazo
	*/
	public void shuffle()
	{
		for(int i=0; i<1000; i++)
		{
			int pos1=(int)Math.floor(Math.random()*this.noCartas);
			int pos2=(int)Math.floor(Math.random()*this.noCartas);
			Carta aux=cartas[pos1];
			cartas[pos1]=cartas[pos2];
			cartas[pos2]=aux;
		}
	}
	/**
	Stringify
	@return Version String del mazo
	*/
	public String toString()
	{
		String ret="";
		for(int i=0; i<this.noCartas; i++)
			ret+=cartas[i].toString()+"\n";
		return ret;
	}
	/**
    Regresa una carta de hasta arriba del mazo
    @return Carta a devolver
	*/
	public Carta pop() throws EmptyMazoException
	{
    	if(this.noCartas==0)
    		throw new EmptyMazoException();
    	this.noCartas--;
    	return this.cartas[this.noCartas];
	}
	/**
    Regresa un conjunto de cartas de hasta arriba del mazo
    @param n Cantidad de cartas a devolver
    @return Areglo de cartas revueltas
	*/
	public Carta[] pop(int n) throws EmptyMazoException
	{
    	if(n>this.noCartas)
    		throw new EmptyMazoException();
    	Carta[] aux=new Carta[n];
    	for(int i=0; i<n; i++)
    		aux[i]=this.cartas[this.noCartas-1-i];
    	this.noCartas-=n;
    	return aux;
	}
	public void push(Carta c)throws FullDeckException
	{
		if (this.noCartas==this.cartas.length)
			throw new FullDeckException();
		this.cartas[this.noCartas++]=c;
	}
}