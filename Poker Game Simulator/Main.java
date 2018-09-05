import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main{

    public static Mazo d;
    public static Jugador j1, j2, j3;
    public static JPanel bottom, top, middle, right, turn;
    public static JButton dButton;
    public static JFrame frame;
    public static int contador=0;
    public static int contador2=0;
    public static int turno=0;
    public static int turnoFinal=0;
    public static JLabel esTuTurno;

    public static void main(String[] args) 
    {
        d=new Mazo();
        d.shuffle();
        
        j1=new Jugador();
        j2=new Jugador();
        j3=new Jugador();        

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createGUI();
            }
        });
    }

    public static void createGUI()
    {

        //Create and set up the window.
        frame = new JFrame("");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,600);
        frame.getContentPane().setLayout(null);

        top=new JPanel();
        top.setLayout(null);
        top.setBackground(new Color(155, 9, 9));
        top.setBounds(0,0,600,200);

        frame.getContentPane().add(top);

        middle=new JPanel();
        middle.setLayout(null);
        middle.setBackground(new Color(181, 7, 7));
        middle.setBounds(0,200,600,200);

        frame.getContentPane().add(middle);

        bottom=new JPanel();
        bottom.setLayout(null);
        bottom.setBackground(new Color(216, 6, 6));
        bottom.setBounds(0,400,600,200);

        frame.getContentPane().add(bottom);

        right=new JPanel();
        right.setLayout(null);
        right.setBackground(new Color(127, 2, 2));
        right.setBounds(600,0,200,300);

        turn= new JPanel();
        turn.setLayout(null);
        turn.setBackground(new Color(127, 2, 2));
        turn.setBounds(600,300,200,300);
        frame.getContentPane().add(turn);

        JLabel dLabel=new JLabel("Mazo");
        dLabel.setFont(new Font("Arial", Font.PLAIN, 22));
        dLabel.setForeground(new Color(255, 255, 255));
        dLabel.setBounds(50,50,100,22);
        right.add(dLabel);

        dButton=new JButton(d.count()+"");
        dButton.setFont(new Font ("Arial", Font.BOLD, 55));
        dButton.setBounds(50,80,100,100);
        dButton.addActionListener(new DeckListener());
        right.add(dButton);

        frame.getContentPane().add(right);

        //Display the window.
        frame.setVisible(true);
    }

    public static class DeckListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
                if(contador==0)
                {
                    String jugador1 = JOptionPane.showInputDialog("Dame el nombre del primer jugador:");
                    String jugador2 = JOptionPane.showInputDialog("Dame el nombre del segundo jugador:");
                    String jugador3 = JOptionPane.showInputDialog("Dame el nombre del tercer jugador:");
                    j1.setNombre(jugador1);
                    j2.setNombre(jugador2);
                    j3.setNombre(jugador3);            
                    contador++;
                }

                if(!j1.fullHand())
                   j1.addCarta(d.pop());
                if(!j2.fullHand())
                   j2.addCarta(d.pop());
                if(!j3.fullHand())
                   j3.addCarta(d.pop());  
                else
                {
                        int noCartas=j1.count();
                        Object[] opt=new Object[noCartas];
                        for(int i=1; i <= noCartas; i++)
                            opt[i-1]=""+i;
                        Object selection = JOptionPane.showInputDialog(null, "Que carta desea cambiar", "Cambiar una Carta", JOptionPane.QUESTION_MESSAGE, null, opt, null);
                        int pos = Integer.parseInt((String) selection) -1;

                        switch(turno)
                        {
                                case 0:
                                        turn.removeAll();                                       
                                        j1.addCarta(d.pop(), pos);
                                        d.pop();
                                        esTuTurno=new JLabel (j2.getNombre()+" es tu turno");
                                        esTuTurno.setFont(new Font("Arial",Font.PLAIN,20));
                                        esTuTurno.setForeground(new Color(255, 255, 255));
                                        esTuTurno.setBounds(25,25,175,20);
                                        turn.add(esTuTurno);
                                        turno++;
                                break;

                                case 1:
                                        turn.removeAll();                                 
                                        j2.addCarta(d.pop(), pos);
                                        d.pop();
                                        esTuTurno=new JLabel (j3.getNombre()+" es tu turno");
                                        esTuTurno.setFont(new Font("Arial",Font.PLAIN,20));
                                        esTuTurno.setForeground(new Color(255, 255, 255));
                                        esTuTurno.setBounds(25,25,175,20);
                                        turn.add(esTuTurno);
                                        turno++;
                                break;

                                case 2:
                                        turn.removeAll();
                                        j3.addCarta(d.pop(), pos);
                                        d.pop();
                                        esTuTurno=new JLabel (j1.getNombre()+" es tu turno");
                                        esTuTurno.setFont(new Font("Arial",Font.PLAIN,20));
                                        esTuTurno.setForeground(new Color(255, 255, 255));
                                        esTuTurno.setBounds(25,25,175,20);
                                        turn.add(esTuTurno);                              
                                        turno=0;
                                break;
                        }
                }

                dButton.setText(d.count()+""); 
                top.removeAll();
                middle.removeAll();
                bottom.removeAll();

                JPanel x=j1.toGUI(100);
                int[] constants = j1.getGUIConstants(100);
                x.setBounds(5,5, constants[2], 100);
                top.add(x);

                JLabel nom=new JLabel(j1.getNombre());
                nom.setFont(new Font("Arial", Font.PLAIN, 20));
                nom.setForeground(new Color(255, 255, 255));
                nom.setBounds(5, 120, constants[2], 20);
                top.add(nom);

                if(j1.fullHand())
                {
                    int v = j1.condicionesVictoria();
                    JLabel mg = new JLabel("Mano ganadora: " + j1.victoriaToString(v));
                    mg.setFont(new Font("Arial", Font.ITALIC,16));
                    mg.setForeground(new Color(255, 255, 255));
                    mg.setBounds(5,160,300,16);
                    top.add(mg);

                    JLabel mg1 = new JLabel("Carta Alta: " + j1.cartaAlta());
                    mg1.setFont(new Font("Arial", Font.ITALIC,16));
                    mg1.setForeground(new Color(255, 255, 255));
                    mg1.setBounds(305,160,300,16);
                    top.add(mg1);
                }

                JPanel x2=j2.toGUI(100);
                int[] constants2 = j2.getGUIConstants(100);
                x2.setBounds(5,5, constants2[2], 100);
                middle.add(x2);

                JLabel nom2=new JLabel(j2.getNombre());
                nom2.setFont(new Font("Arial", Font.PLAIN, 20));
                nom2.setForeground(new Color(255, 255, 255));
                nom2.setBounds(5, 120, constants[2], 20);
                middle.add(nom2);

                if(j2.fullHand())
                {
                    int v2 = j2.condicionesVictoria();
                    JLabel mg2 = new JLabel("Mano ganadora: " + j2.victoriaToString(v2));
                    mg2.setFont(new Font("Arial", Font.ITALIC,16));
                    mg2.setForeground(new Color(255, 255, 255));
                    mg2.setBounds(5,160,490,16);
                    middle.add(mg2);

                    JLabel mg22 = new JLabel("Carta Alta: " + j2.cartaAlta());
                    mg22.setFont(new Font("Arial", Font.ITALIC,16));
                    mg22.setForeground(new Color(255, 255, 255));
                    mg22.setBounds(305,160,300,16);
                    middle.add(mg22);
                }

                JPanel x3=j3.toGUI(100);
                int[] constants3 = j3.getGUIConstants(100);
                x3.setBounds(5,5, constants3[2], 100);
                bottom.add(x3);

                JLabel nom3=new JLabel(j3.getNombre());
                nom3.setFont(new Font("Arial", Font.PLAIN, 20));
                nom3.setForeground(new Color(255, 255, 255));
                nom3.setBounds(5, 120, constants[2], 20);
                bottom.add(nom3);

                if(j3.fullHand())
                {
                    int v3 = j3.condicionesVictoria();
                    JLabel mg3 = new JLabel("Mano ganadora: " + j3.victoriaToString(v3));
                    mg3.setFont(new Font("Arial", Font.ITALIC,16));
                    mg3.setForeground(new Color(255, 255, 255));
                    mg3.setBounds(5,160,490,16);
                    bottom.add(mg3);

                    JLabel mg33 = new JLabel("Carta Alta: " + j3.cartaAlta());
                    mg33.setFont(new Font("Arial", Font.ITALIC,16));
                    mg33.setForeground(new Color(255, 255, 255));
                    mg33.setBounds(305,160,300,16);
                    bottom.add(mg33);
                }

                

                frame.revalidate();
                frame.repaint();

                if(turnoFinal==10)
                {
                        int v=j1.getMano().condicionesVictoria();
                        int v2=j2.getMano().condicionesVictoria();
                        int v3=j3.getMano().condicionesVictoria();
                        if (v>v2 && v>v3)
                            JOptionPane.showMessageDialog(null, j1.getNombre()+" ha ganado con "+j1.getMano().victoriaToString(v));
                        else
                        {
                            if( v2>v && v2>v3)
                                JOptionPane.showMessageDialog(null, j2.getNombre()+" ha ganado con "+j2.getMano().victoriaToString(v2));
                            else
                                JOptionPane.showMessageDialog(null, j3.getNombre()+" ha ganado con "+j3.getMano().victoriaToString(v3));
                        }
                        System.exit(0);
                }
                turnoFinal++;
        }
    }
}