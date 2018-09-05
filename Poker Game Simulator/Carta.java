import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import java.awt.event.*;
/**
Clase que modela una carta para el juego Poker con un palo y un numero
@author JEHR
*/
public class Carta
{
	public static final int PALO_DIAMANTE=0;
	public static final int PALO_TREBOL=1;
	public static final int PALO_CORAZON=2;
	public static final int PALO_ESPADA=3;

	public static final int FIGURA_AS=1;
	public static final int FIGURA_JOTA=11;
	public static final int FIGURA_REINA=12;
	public static final int FIGURA_REY=13;

	private int palo, figura;
	/**
	Constructor vacio
	Se inicia una carta vacia como As de Diamantes
	*/
	public Carta()
	{
		this.palo=0;
		this.figura=1;
	}
	/**
	Constructor parametrizado
	@param 	p 	Palo de la carta
	@param 	f 	Figura
	*/
	public Carta(int p, int f) throws NoSuchCardException
	{
		if(p<0||p>3)
			throw new NoSuchCardException("Palo incorrecto "+p);
		if(f<1||f>13)
			throw new NoSuchCardException("Figura incorrecto "+f);
		this.palo=p;
		this.figura=f;
	}
	/**
	Accesor para palo
	@return Palo de la carta
	*/
	public int getPalo()
	{
		return this.palo;
	}
	/**
	Accesor para figura
	@return Figura de la carta
	*/
	public int getFigura()
	{
		return this.figura;
	}
	/**
	Mutador para palo
	@param 	p 	Nuevo palo de la carta
	*/
	public void setPalo(int p) throws NoSuchCardException
	{
		if(p<0||p>3)
			throw new NoSuchCardException("Palo incorrecto "+p);
		this.palo=p;
	}
	/**
	Mutador para figura
	@param 	f 	Nueva figura de la carta
	*/
	public void setFigura(int f) throws NoSuchCardException
	{
		if(f<1||f>13)
			throw new NoSuchCardException("Figura incorrecto "+f);
		this.figura=f;
	}
	/**
	Genera una copia de la carta
	@return Nueva carta
	*/
	public Carta clone()
	{
		return new Carta(this.palo, this.figura);
	}
/**
Stringify
@return Version de la carta como cadena de texto
*/

	public String toString(){
		String ret = this.figura + "";
		switch (this.figura){
			case FIGURA_JOTA:
				ret="J ";
				break;
			case FIGURA_REINA:
				ret="Q ";
				break;
			case FIGURA_REY:
				ret="K ";
				break;
			case FIGURA_AS:
				ret="A ";
				break;
		}
		switch (this.palo){
			case PALO_DIAMANTE:
				ret=ret + "Diamantes";
				break;
			case PALO_ESPADA:
				ret=ret + "Espadas";
				break;
			case PALO_CORAZON:
				ret=ret + "Corazones";
				break;
			case PALO_TREBOL:
				ret=ret + "Treboles";
				break;
		}
		return ret;
	}

/**
Compara dos cartas. Identifica la de mayor valor (carta alta)
@return -1 si la carta es menor a la carta parametro , 0 si son iguales , 1 si es mayor
@param c Carta con la cual se va a comparar
*/
	public int compareToAs(Carta c){
		if (this.palo==c.getPalo() && this.figura==c.getFigura())
			return 0;
		else if(this.figura!=FIGURA_AS && this.figura>c.getFigura() && c.getFigura()!=FIGURA_AS
		||
		this.figura==FIGURA_AS && c.getFigura() != FIGURA_AS
		||
		this.figura==c.getFigura() && this.palo>c.getPalo())
			return 1;
		else 
			return -1;
	}

/**
Compara dos cartas entre si
@return 0 si son iguales, 1 si la carta comparada es mayor, -1 si la carta comparada es menor
*/
	public int compareTo(Carta c){
		if (this.palo==c.getPalo() && this.figura==c.getFigura())
			return 0;
		else if(this.figura>c.getFigura() 
		||
		this.figura==c.getFigura() && this.palo>c.getPalo())
			return 1;
		else 
			return -1;
	}
	/**
	Determina si dos cartas son iguales o no
	@return 	<em>true</em> si son iguales o <em>false</em> si son diferentes
	@param 	c 	Carta contra la cual se va a comparar
	*/
	public boolean equals(Carta c)
	{
		return compareTo(c)==0;
	}
/**
Vuelve tu carta un panel (imagen)
@return JPanel que representa la carta
@param h altura de la carta
@param w ancho de la carta
*/
	public JPanel toGUI(int w, int h)
	{
		JPanel c=new JPanel();
		c.setSize(w, h);
		c.setBackground(Color.WHITE);
		c.setLayout(null);

		String img="";
		Color clr=new Color(0,0,0);
		switch(this.palo)
		{
		  case PALO_DIAMANTE: img="diamond.png"; clr = new Color(255,0,0); break;
		  case PALO_TREBOL: img="club.png"; break;
		  case PALO_CORAZON: img="hearts.png"; clr = new Color(255,0,0); break;
		  case PALO_ESPADA: img="spades.png"; break;
		}
		int wPadding=(int)Math.round(w*0.1);
		int hPadding=(int)Math.round(h*0.1);
		int pWidth=(int)Math.round(w*0.2);
		int pHeight=(int)Math.round(w*0.2);
		int fWidth=(int)Math.round(w*0.4);
		int fHeight=(int)Math.round(w*0.4);
		int fSize=(int)Math.round(h*0.2);
		try
		{
			BufferedImage myPicture=resize(ImageIO.read(new File(img)), pWidth, pHeight);
			JLabel picLabel=new JLabel(new ImageIcon(myPicture));
			picLabel.setBounds(wPadding, hPadding, pWidth, pHeight);
			c.add(picLabel);
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
		String ret=this.figura+"";
		switch (this.figura)
		{
			case FIGURA_JOTA: ret="J"; break;
			case FIGURA_REINA: ret="Q"; break;
			case FIGURA_REY: ret="K"; break;
			case FIGURA_AS: ret="A"; break;
		}
		JLabel figura = new JLabel(ret);
		figura.setBounds(wPadding+pWidth, hPadding+pHeight, fWidth, fHeight);
		figura.setForeground(clr);
		figura.setFont(new Font("Arial", Font.PLAIN, fSize));
		c.add(figura);
		return c;
	}

/**
Regresa la carta con mayor valor de otro color
@return JPanel que representa la carta
@param h altura de la carta
@param w ancho de la carta
*/
	public JPanel toCartaAlta(int w, int h)
	{
		JPanel carta=this.toGUI(w, h);
		carta.setBackground(new Color(255, 254, 196));
		return carta;
	}
/**
Regresa la imagen del palo de la carta ya con el tamaño deseado
@return imagen lista para ser usada
@param img 	imagen que se desea editar
@param newW nuevo ancho que se le quiere poner a la imagen
@param newH nueva altura que se le quiere poner a la imagen
*/
	public BufferedImage resize(BufferedImage img, int newW, int newH)
	{
		Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
		BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);

		Graphics2D g2d = dimg.createGraphics();
		g2d.drawImage(tmp, 0, 0, null);
		g2d.dispose();

		return dimg;
	}
}