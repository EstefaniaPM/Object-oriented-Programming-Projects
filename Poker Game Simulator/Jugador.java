import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
Clase que modela una carta para el juego Poker con un palo y un numero
@author JEHR
*/
public class Jugador
{
  private String nombre;
  private Mano miMano;

  /**
    Constructor vacio
  */
  public Jugador()
  {
    this.nombre="";
    this.miMano=new Mano();
  }
  /**
    Cosntructor parametrizado
    @param n Nombre del jugador
    @param m Mano del jugador
  */
  public Jugador(String n)
  {
    this.nombre = n;
    this.miMano=new Mano();
  }
  /**
    Mutadores de la clase jugador
    @param n Nuevo nombre del judador
  */
  public void setNombre(String n)
  {
    this.nombre = n;
  }
  /**
    Accesores de la clase jugador
    @return Mano de la clase
  */
  public Mano getMano()
  {
    return this.miMano;
  }
/**
Regresa el nombre del jugador
@return nombre del jugador
*/
  public String getNombre()
  {
    return this.nombre;
  }
  /**
    Stringify
    @return Version String del jugador
  */
  public String toString()
  {
    return "El nombre del judador es: "+this.nombre+"\n"+"Tiene una mano de: " + this.miMano.toString();
  }
  /**
    Agregar nueva carta a la mano
    @param c Nueva carta para la mano
  */
    public void addCarta(Carta c)
    {
      miMano.addCarta(c);
    }
  /**
    Agrega una nueva carta en una posicion en especifico
    @param c Nueva carata a Agregar
    @param pos Posicion en la que se agrega la carta
  */
    public void addCarta(Carta c, int pos)
    {
      miMano.addCarta(c, pos);
    }
/**
Te dice las medidas de la carta
@return arreglo con las medidas correspondientes
*/
  public int[] getGUIConstants(int h)
  {
    return miMano.getGUIConstants(h);
  }
  /**
Regresa el numero de cartas
@return numero de cartas
*/
  public int count()
  {
    return miMano.count();
  }
/**
Regresa un booleano que indica si la mano esta llena
@return booleano true si esta llena la mano o false si no esta llena
*/
  public boolean fullHand()
  {
    return miMano.fullHand();
  }
   /**
      Determina el tio de mano ganadora que tiene un arreglo de cartas ordenado
      0 - Carta alta
      1 - 1 par
      2- 2 pares
      3 - tercia
      4- escalera
      5 - color
      6 - Full house
      7 - Pokar
      8 - Flor
    */
  public int condicionesVictoria()
  {
    return miMano.condicionesVictoria();
  }
   /**
    Stringify
    @return Version String de la victoria
  */
  public String victoriaToString(int v)
  {
    return miMano.victoriaToString(v);
  }
/**
Vuelve tu carta un panel (imagen)
@return JPanel que representa la mano
@param h altura de la mano (carta)
*/
  public JPanel toGUI(int a)
  {
        int[] constants=miMano.getGUIConstants(a);
        
        int b=a+40;

        JPanel jugador=new JPanel();
        jugador.setLayout(null);
        jugador.setSize(constants[2], b);
        jugador.setOpaque(false);

        JPanel hand=miMano.toGUI(a);
        hand.setBounds(0, 0, constants[2], a);
        jugador.add(hand);

        return jugador;    
  }
    /**
Accesor de carta alta
@return la carta de mayor valor
*/
  public Carta cartaAlta(){
    return this.miMano.cartaAlta();
  }
}