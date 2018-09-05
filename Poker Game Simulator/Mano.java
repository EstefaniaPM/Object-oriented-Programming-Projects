import javax.swing.*;
import java.awt.*;
/**
  Clase que modela la mano de 5 cartas de un jugador con todas sus rpopiedades
  @author JEHR
  @version 2.0
*/
  public class Mano
  {
    private Carta[] cs;
    private int noCartas;

    public static final int MG_CARTA_ALTA = 0;
    public static final int MG_UN_PAR = 1;
    public static final int MG_DOS_PARES = 2;
    public static final int MG_TERCIA = 3;
    public static final int MG_ESCALERA = 4;
    public static final int MG_COLOR = 5;
    public static final int MG_FULL_HOUSE = 6;
    public static final int MG_POKER = 7;
    public static final int MG_FLOR = 8;
  /**
    Constructor vacio
  */
    public Mano()
    {
      this.cs = new Carta[5];
    }

  /**
  Constructor parametrizado
  @param n Indica el numero de cartas en la mano
  */
  public Mano(int n)
  {
    this.cs = new Carta[n];
  }
  /**
    Constructror parametrizado
    @param cs Arreglo de cartas para la amno
  */
    public Mano(Carta[] cs)
    {
      this.cs = cs;
      this.noCartas = cs.length;
    }
  /**
    Agregar nueva carta a la mano
    @param c Nueva carta para la mano
  */
    public void addCarta(Carta c) throws FullHandException
    {
      if(this.noCartas >= this.cs.length)
        throw new FullHandException();
      this.cs[this.noCartas++] = c;
    }

  /**
    Agrega una nueva carta en una posicion en especifico
    @param c Nueva carata a Agregar
    @param pos Posicion en la que se agrega la carta
  */

    public void addCarta(Carta c, int pos) throws HandIndexOutOfBoundsException{
      if(pos < 0 || pos >= this.cs.length)
        throw new HandIndexOutOfBoundsException ();
      else if (pos > this.noCartas){
        addCarta(c);
      } else {
        this.cs[pos] = c;
      }
    }

  /**
    Stringify
    @return Version String de la mano
  */

    public String toString(){
      String ret = "";
      for(int i = 0; i < this.noCartas; i++){
       ret = ret + this.cs[i] + "\n";
     }
     int v = condicionesVictoria();
     ret = ret + "Juego: " + victoriaToString(v);
     Carta c = cartaAlta();
     ret = ret + "\nCarta alta: " + c.toString();
     return ret;
   }

    /**
      Ordena un arreglo de cartas
      @return Arreglo de cartas ordenadas
    */

      public Carta[] sort(){
        Carta[] ret = this.cs;
        for(int i = 0 ; i < this.noCartas; i++){
          for(int j = i; j < this.noCartas; j++){
            if(ret[j].compareToAs(ret[i]) == -1){
              Carta aux = ret[i];
              ret[i] = ret[j];
              ret[j] = aux;
            }
          }
        }
        return ret;
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

      public int condicionesVictoria(){
        Carta[] sorted = sort();
        int[] repetidos = getRepetidos(sorted);
        int palos = getPalos(sorted);
        int cons = getConsecutivos(sorted);
        int result = MG_CARTA_ALTA;

        if(palos == 1 && cons == 5){
          result = MG_FLOR;
        } else if ( repetidos[3] == 1){
          result = MG_POKER;
        } else if ( repetidos[2] == 1 && repetidos[1] == 1){
          result = MG_FULL_HOUSE;
        } else if ( palos == 1 ){
          result = MG_COLOR;
        } else if ( cons == 5 ){
          result = MG_ESCALERA;
        } else if (repetidos[2] == 1 ){
          result = MG_TERCIA;
        } else if (repetidos[1] == 2){
          result = MG_DOS_PARES;
        } else if(repetidos[1] == 1){
          result = MG_UN_PAR;
        }

        return result;
      }
/**
Calcula la carta alta de una mano
@return Carta alta
*/
  public Carta cartaAlta(){
        Carta res = new Carta();
        Carta[] sorted = sort();
        int[] rep = getRepetidos(sorted);
        int palos = getPalos(sorted);
        int cons = getConsecutivos(sorted);

      if( rep[0] != 5) { //Pokar, Full House, Tercia, Dos Pares, Un Par
        int maxRep = 0;
        for(int i = rep.length - 1; i >= 1; i--){
          if( rep[i] > 0){
            maxRep = i + 1;
            break;
          }
        }

        Carta c = new Carta(Carta.PALO_DIAMANTE, 2);
        Carta c2 = new Carta(Carta.PALO_DIAMANTE, 2);
        int repe = 1;
        int ultimaFigura = -1;
        for(int i = 0; i < sorted.length; i++){
          if( sorted[i].getFigura() == ultimaFigura){
            c = sorted[i];
            repe++;
          } else {
            if( repe == maxRep){
              if( c.compareToAs(c2) == 1)
                c2 = c;
              repe = 1;
              c = new Carta (Carta.PALO_DIAMANTE, 2);
            }
          }
          ultimaFigura = sorted[i].getFigura();
        }
        if(repe == maxRep && c.compareToAs(c2) == 1){
          c2 = c;
          res = c2;
        }
      } else {

        Carta c = new Carta(Carta.PALO_DIAMANTE, 2);
        for(int i = 0; i < sorted.length; i++){
          if(sorted[i].compareToAs(c) == 1)
            c = sorted[i];
        }
        res = c;
      }
      return res;
    }
 /**
    Stringify
    @return Version String de la victoria
  */
    public String victoriaToString(int v){
      String res = "";
      switch(v){
        case MG_CARTA_ALTA: res="Carta alta"; break;
        case MG_UN_PAR: res="Un par"; break;
        case MG_DOS_PARES: res="Dos pares"; break;
        case MG_TERCIA: res="Tercia"; break;
        case MG_ESCALERA: res="Escalera"; break;
        case MG_COLOR: res="Color"; break;
        case MG_FULL_HOUSE: res="Full House"; break;
        case MG_POKER: res="Poker"; break;
        case MG_FLOR: res="Flor"; break;
      }
      return res;
    }
/**
Te dice las cartas que tienes repetidas
@return arreglo
*/
    public int[] getRepetidos(Carta[] cs){

      int[] rep = new int[5];

      int ultimaFigura = -1;
      int count = 1;
      for(int i = 0; i < cs.length; i++){
        if(cs[i].getFigura() == ultimaFigura){
          count++;
        } else {
          if(ultimaFigura != -1)
           rep[count - 1]++;
         ultimaFigura = cs[i].getFigura();
         count = 1;
       }
     }
     rep[count - 1]++;
     return rep;
   }

   /**
Te dice las palos que tienes repetidas
@return numero que representa los palos
*/

   public int getPalos(Carta[] cs){
    int[] palos = new int[4];
    for(int i = 0; i < cs.length; i++){
      palos[cs[i].getPalo()]++;
    }
    int count = 0;
    for( int j = 0; j < palos.length; j++){
      if(palos[j] > 0)
        count++;
    }
    return count;
  }
/**
Accesor para los consecutivos
@return numero que representa los consecutivos
*/
  public int getConsecutivos(Carta[] cs){
    int cons = 0;
    int maxCons = 0;
    int ultimaFigura = -1;
    boolean hayAs = false;
    boolean hayRey = false;

    for( int i = 0; i < cs.length; i++){
      if(cs[i].getFigura() == Carta.FIGURA_AS)
        hayAs = true;
      if(cs[i].getFigura() == Carta.FIGURA_REY)
        hayRey = true;

      if(cs[i].getFigura() == (ultimaFigura + 1))
        cons++;
      else
        cons = 0;

      if(cons > maxCons)
        maxCons = cons;

      ultimaFigura = cs[i].getFigura();
    }

    if(hayRey && hayAs)
      cons++;

    if(cons > maxCons)
      maxCons = cons;

    return maxCons + 1;
  }
/**
Accesor de carta
@return la carta en la posicion solicitada
@param pos  indice de la carta deseada
*/
  public Carta getCarta(int pos){
    return this.cs[pos];
  }

/**
Te dice las medidas de la carta
@return arreglo con las medidas correspondientes
*/

  public int[] getGUIConstants(int h){
    int w = (int) Math.round(h*0.6);
    int padd = 15;
    int totalWidth = (w*this.noCartas) + (padd * (this.noCartas - 1));

    int[] ret = {w, padd, totalWidth};

    return ret;
  }

/**
Vuelve tu mano de cartas un panel (imagen)
@return JPanel que representa la carta
@param h altura de la carta
*/
  public JPanel toGUI(int h){

    int[] constants = getGUIConstants(h);
    int w = constants[0];
    int padd = constants[1];

    JPanel ret = new JPanel();
    ret.setLayout(null);
    ret.setSize(constants[2], h);
    ret.setOpaque(false);

    for(int i = 0; i < this.noCartas; i++)
    {
      Carta c = this.cs[i];
        JPanel j = c.toGUI(w,h);
        j.setBounds(i*(w+padd), 0, w, h);
        ret.add(j);
    }
    return ret;
  }

  /**
Te regresa el ancho que debe tener le panel que contenga la mano
@return numero que representa el ancho
@ param h altura de la carta
*/

  public int getGUIWidth(int h){
    int w = (int) Math.round(h*0.6);
    int padd = 15;
    return (w*this.noCartas) + (padd * (this.noCartas - 1));
  }

/**
Regresa el numero de cartas
@return numero de cartas
*/

  public int count(){
    return this.noCartas;
  }
/**
Regresa un booleano que indica si la mano esta llena
@return booleano true si esta llena la mano o false si no esta llena
*/
  public boolean fullHand(){
    return this.noCartas >= this.cs.length;
  }
}