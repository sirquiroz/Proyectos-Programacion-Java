
package veintiuno;
import java.applet.*;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Vector;
import javax.swing.*;
import sun.java2d.Disposer;

public class JuegoVeintiuno extends Frame implements ActionListener{

   public Vector imaCartas = new Vector();
   public Vector valorCartas = new Vector();
   JButton b1,b2,b3,b4,Nuevo,Salir,btn1,btn2,btn3,btn4;
    JLabel im1,im2,im3,im4;
   JLabel cartas [] = new JLabel [53];
   int valores[] = new int [53];
   Random aleatorio = new Random();
   int ale, acum1,acum2,acum3,acum4, indice = 8, dx = 260, dy = 220, y = 3, x2=26, x3=20,y2 = 3;
   JLabel reves = new JLabel();

  
   AudioClip moviendocarta, felicitaciones;
public JuegoVeintiuno(){
   
moviendocarta = Applet.newAudioClip(getClass().getResource("/multimedia/atras.WAV"));
felicitaciones = Applet.newAudioClip(getClass().getResource("/multimedia/avanzar.WAV"));
    setTitle("                                               :::::  SUPER BLACK JACK 21  :::::");
    setSize(650, 600);
    setLayout(null);
    setBackground(Color.black);
    setLocationRelativeTo(null);
    setResizable(false);

    b1 = new JButton("► PLAYER 1");
    b1.setBounds(250, 35, 105, 30);
    b1.addActionListener(this);
    add(b1);

    btn1 = new JButton(new ImageIcon(getClass().getResource("s.gif")));
    btn1.setBounds(360, 35, 30, 30);
    btn1.addActionListener(this);
    add(btn1);


    b3 = new JButton("► PLAYER 3");
    b3.setBounds(250, 520, 105, 30);
    b3.addActionListener(this);
    add(b3);

    btn2 = new JButton(new ImageIcon(getClass().getResource("s.gif")));
    btn2.setBounds(360, 520, 30, 30);
    btn2.addActionListener(this);
    add(btn2);


    b2 = new JButton("► PLAYER 2");
    b2.setBounds(455, 340, 105, 30);
    add(b2);
    b2.addActionListener(this);


    btn3 = new JButton(new ImageIcon(getClass().getResource("s.gif")));
    btn3.setBounds(565, 340, 30, 30);
    btn3.addActionListener(this);
    add(btn3);


    
    b4 = new JButton("► PLAYER 4");
    b4.setBounds(15, 340, 105, 30);
    b4.addActionListener(this);
    add(b4);

    btn4 = new JButton(new ImageIcon(getClass().getResource("s.gif")));
    btn4.setBounds(125, 340, 30, 30);
    btn4.addActionListener(this);
    add(btn4);

    
    Nuevo = new JButton("::: NEW GAME :::");
    Nuevo.setBounds(480, 550, 150, 30);
    Nuevo.addActionListener(this);
    add(Nuevo);

    im1=new JLabel();
    im1.setBounds(10,30,250,120);
    im1.setIcon(new ImageIcon(getClass().getResource("s21.png")));
    add(im1);

    im2=new JLabel();
    im2.setBounds(470,30,250,120);
    im2.setIcon(new ImageIcon(getClass().getResource("money.gif")));
    add(im2);

    im3=new JLabel();
    im3.setBounds(10,440,250,120);
    im3.setIcon(new ImageIcon(getClass().getResource("cart.jpg")));
    add(im3);

    im4=new JLabel();
    im4.setBounds(480,400,250,120);
    im4.setIcon(new ImageIcon(getClass().getResource("man.jpg")));
    add(im4);


    reves = new JLabel();
    reves.setBounds(264, 220, 80, 125);
    reves.setIcon(new ImageIcon(getClass().getResource("/trebol/reves.jpg")));
    crearcartas();
    add(reves);

  

    for (int i = 0; i < 52; i++) {
        ale = aleatorio.nextInt(imaCartas.size());
        cartas[i] = new JLabel();
        cartas[i].setIcon((Icon) imaCartas.elementAt(ale));
        cartas[i].setBounds(260, 220, 75, 118);
        add(cartas[i]);
        valores[i]= (Integer)valorCartas.elementAt(ale);
        imaCartas.remove(ale);
        valorCartas.remove(ale);
    }
NuevoJuego();

    
    
setVisible(true);
addWindowListener(new Cerrar_Ventana());
}
public void crearcartas(){
    imaCartas.add(new ImageIcon(getClass().getResource("/corazon/corazones-as-th.gif")));
    imaCartas.add(new ImageIcon(getClass().getResource("/corazon/corazones-2-th.gif")));
    imaCartas.add(new ImageIcon(getClass().getResource("/corazon/corazones-3-th.gif")));
    imaCartas.add(new ImageIcon(getClass().getResource("/corazon/corazones-4-th.gif")));
    imaCartas.add(new ImageIcon(getClass().getResource("/corazon/corazones-5-th.gif")));
    imaCartas.add(new ImageIcon(getClass().getResource("/corazon/corazones-6-th.gif")));
    imaCartas.add(new ImageIcon(getClass().getResource("/corazon/corazones-7-th.gif")));
    imaCartas.add(new ImageIcon(getClass().getResource("/corazon/corazones-8-th.gif")));
    imaCartas.add(new ImageIcon(getClass().getResource("/corazon/corazones-9-th.gif")));
    imaCartas.add(new ImageIcon(getClass().getResource("/corazon/corazones-10-th.gif")));
    imaCartas.add(new ImageIcon(getClass().getResource("/corazon/corazones-jota-th.gif")));
    imaCartas.add(new ImageIcon(getClass().getResource("/corazon/corazones-reina-th.gif")));
    imaCartas.add(new ImageIcon(getClass().getResource("/corazon/corazones-rey-th.gif")));
    imaCartas.add(new ImageIcon(getClass().getResource("/diamantes/diamantes-as-th.gif")));
    imaCartas.add(new ImageIcon(getClass().getResource("/diamantes/diamantes-2-th.gif")));
    imaCartas.add(new ImageIcon(getClass().getResource("/diamantes/diamantes-3-th.gif")));
    imaCartas.add(new ImageIcon(getClass().getResource("/diamantes/diamantes-4-th.gif")));
    imaCartas.add(new ImageIcon(getClass().getResource("/diamantes/diamantes-5-th.gif")));
    imaCartas.add(new ImageIcon(getClass().getResource("/diamantes/diamantes-6-th.gif")));
    imaCartas.add(new ImageIcon(getClass().getResource("/diamantes/diamantes-7-th.gif")));
    imaCartas.add(new ImageIcon(getClass().getResource("/diamantes/diamantes-8-th.gif")));
    imaCartas.add(new ImageIcon(getClass().getResource("/diamantes/diamantes-9-th.gif")));
    imaCartas.add(new ImageIcon(getClass().getResource("/diamantes/diamantes-10-th.gif")));
    imaCartas.add(new ImageIcon(getClass().getResource("/diamantes/diamantes-jota-th.gif")));
    imaCartas.add(new ImageIcon(getClass().getResource("/diamantes/diamantes-reina-th.gif")));
    imaCartas.add(new ImageIcon(getClass().getResource("/diamantes/diamantes-rey-th.gif")));

    imaCartas.add(new ImageIcon(getClass().getResource("/espada/picas-as-th.gif")));
    imaCartas.add(new ImageIcon(getClass().getResource("/espada/picas-2-th.gif")));
    imaCartas.add(new ImageIcon(getClass().getResource("/espada/picas-3-th.gif")));
    imaCartas.add(new ImageIcon(getClass().getResource("/espada/picas-4-th.gif")));
    imaCartas.add(new ImageIcon(getClass().getResource("/espada/picas-5-th.gif")));
    imaCartas.add(new ImageIcon(getClass().getResource("/espada/picas-6-th.gif")));
    imaCartas.add(new ImageIcon(getClass().getResource("/espada/picas-7-th.gif")));
    imaCartas.add(new ImageIcon(getClass().getResource("/espada/picas-8-th.gif")));
    imaCartas.add(new ImageIcon(getClass().getResource("/espada/picas-9-th.gif")));
    imaCartas.add(new ImageIcon(getClass().getResource("/espada/picas-10-th.gif")));
    imaCartas.add(new ImageIcon(getClass().getResource("/espada/picas-jota-th.gif")));
    imaCartas.add(new ImageIcon(getClass().getResource("/espada/picas-reina-th.gif")));
    imaCartas.add(new ImageIcon(getClass().getResource("/espada/picas-rey-th.gif")));

    imaCartas.add(new ImageIcon(getClass().getResource("/trebol/treboles-as-th.gif")));

    imaCartas.add(new ImageIcon(getClass().getResource("/trebol/treboles-2-th.gif")));
    imaCartas.add(new ImageIcon(getClass().getResource("/trebol/treboles-3-th.gif")));
    imaCartas.add(new ImageIcon(getClass().getResource("/trebol/treboles-4-th.gif")));
    imaCartas.add(new ImageIcon(getClass().getResource("/trebol/treboles-5-th.gif")));
    imaCartas.add(new ImageIcon(getClass().getResource("/trebol/treboles-6-th.gif")));
    imaCartas.add(new ImageIcon(getClass().getResource("/trebol/treboles-7-th.gif")));
    imaCartas.add(new ImageIcon(getClass().getResource("/trebol/treboles-8-th.gif")));
    imaCartas.add(new ImageIcon(getClass().getResource("/trebol/treboles-9-th.gif")));
    imaCartas.add(new ImageIcon(getClass().getResource("/trebol/treboles-10-th.gif")));
    imaCartas.add(new ImageIcon(getClass().getResource("/trebol/treboles-jota-th.gif")));
    imaCartas.add(new ImageIcon(getClass().getResource("/trebol/treboles-reina-th.gif")));
    imaCartas.add(new ImageIcon(getClass().getResource("/trebol/treboles-rey-th.gif")));


    valorCartas.add(1);
    valorCartas.add(2);
    valorCartas.add(3);
    valorCartas.add(4);
    valorCartas.add(5);
    valorCartas.add(6);
    valorCartas.add(7);
    valorCartas.add(8);
    valorCartas.add(9);
    valorCartas.add(10);
    valorCartas.add(10);
    valorCartas.add(10);
    valorCartas.add(10);

    valorCartas.add(1);
    valorCartas.add(2);
    valorCartas.add(3);
    valorCartas.add(4);
    valorCartas.add(5);
    valorCartas.add(6);
    valorCartas.add(7);
    valorCartas.add(8);
    valorCartas.add(9);
    valorCartas.add(10);
    valorCartas.add(10);
    valorCartas.add(10);
    valorCartas.add(10);

    valorCartas.add(1);
    valorCartas.add(2);
    valorCartas.add(3);
    valorCartas.add(4);
    valorCartas.add(5);
    valorCartas.add(6);
    valorCartas.add(7);
    valorCartas.add(8);
    valorCartas.add(9);
    valorCartas.add(10);
    valorCartas.add(10);
    valorCartas.add(10);
    valorCartas.add(10);

    valorCartas.add(1);
    valorCartas.add(2);
    valorCartas.add(3);
    valorCartas.add(4);
    valorCartas.add(5);
    valorCartas.add(6);
    valorCartas.add(7);
    valorCartas.add(8);
    valorCartas.add(9);
    valorCartas.add(10);
    valorCartas.add(10);
    valorCartas.add(10);
    valorCartas.add(10);
}

public void NuevoJuego(){


    cartas[0].setBounds(250, 68, 75, 118);
    cartas[1].setBounds(280, 68, 75, 118);
    acum1= valores[0]+valores[1];
    cartas[2].setBounds(450, 220, 75, 118);
    cartas[3].setBounds(480, 220, 75, 118);
    acum2= valores[2]+valores[3];

     cartas[4].setBounds(250, 400, 75, 118);
    cartas[5].setBounds(280, 400, 75, 118);
    acum3= valores[4]+valores[5];

     cartas[6].setBounds(12, 220, 75, 118);
    cartas[7].setBounds(42, 220, 75, 118);
    acum4= valores[6]+valores[7];
}
    public static void main(String[] args) {
        new JuegoVeintiuno();

    }

public void pedirCarta1(){
      Thread hilo = new Thread() {

            @Override
            public void run() {
                try {
                    moviendocarta.play();
    for (int i = 0; i < 16; i++) {
      cartas[indice].setBounds(dx, dy, 75, 118);
     
       

        sleep(30);
        dx = dx + y;
        dy = dy - 10;
        
                    }
     acum1= acum1+valores[indice];
     evaluar(b1, acum1);
    indice = indice +1;
    dx = 260;
    dy = 220;
    y = y + 2;
                   
                    } catch  (Exception e) {
                    System.out.println("" + e);

                }


            }
        };
        hilo.start();
    moviendocarta.stop();

}
public void pedirCarta2(){
      Thread hilo = new Thread() {

            @Override
            public void run() {
                try {
                      moviendocarta.play();
    for (int i = 0; i < x2; i++) {
      cartas[indice].setBounds(dx, dy, 75, 118);



        sleep(30);
        dx = dx + 10;

                    }
     acum2= acum2+valores[indice];
     evaluar(b2, acum2);
    indice = indice +1;
    dx = 260;
    dy = 220;
    x2 = x2 + 2;

                    } catch  (Exception e) {
                    System.out.println("" + e);

                }


            }
        };
        hilo.start();


}
public void pedirCarta4(){
      Thread hilo = new Thread() {

            @Override
            public void run() {
                try {
                      moviendocarta.play();
    for (int i = 0; i < x3; i++) {
      cartas[indice].setBounds(dx, dy, 75, 118);



        sleep(30);
        dx = dx - 10;

                    }
     acum4= acum4+valores[indice];
     evaluar(b4, acum4);
    indice = indice +1;
    dx = 260;
    dy = 220;
    x3 = x3 - 2;

                    } catch  (Exception e) {
                    System.out.println("" + e);

                }


            }
        };
        hilo.start();


}
public void pedirCarta3(){
      Thread hilo = new Thread() {

            @Override
            public void run() {
                try {
                      moviendocarta.play();
    for (int i = 0; i < 19; i++) {
      cartas[indice].setBounds(dx, dy, 75, 118);



        sleep(20);
        dx = dx + y2;
        dy = dy + 10;

                    }
     acum3= acum3+valores[indice];
     evaluar(b3, acum3);
    indice = indice +1;
    dx = 260;
    dy = 220;
    y2 = y2 + 2;

                    } catch  (Exception e) {
                    System.out.println("" + e);

                }


            }
        };
        hilo.start();


}
public void evaluar(JButton b, int x){
    if (x== 21 ){
        JOptionPane.showMessageDialog(null, "FELICITACIONES LOGRATES OBTENER 21");
    }else if (x>21){
        JOptionPane.showMessageDialog(null, "TE PASASTE DE 21... PERDISTE");
        b.setEnabled(false);
    }


}
public void ganador(){
    if (acum1 > 21){
            acum1 = 0;
        } if (acum2 > 21){
            acum2 = 0;
        } if ( acum3 > 21){
            acum3 =0;
        }if(acum4 > 21 ){
            acum4 = 0;}
             felicitaciones.play();
    if (acum1 > acum2 && acum1 > acum3 && acum1 > acum4){
        JOptionPane.showMessageDialog(null, "El Jugador uno es el Ganador");
    } else if (acum2 > acum1 && acum2 > acum3 && acum2 > acum4){
          JOptionPane.showMessageDialog(null, "El Jugador Dos es el Ganador");
    }else if (acum3 > acum1 && acum3 > acum2 && acum3 > acum4){
          JOptionPane.showMessageDialog(null, "El Jugador Tres es el Ganador");
    }else if (acum4 > acum1 && acum4 > acum2 && acum4 > acum3){
          JOptionPane.showMessageDialog(null, "El Jugador Cuarto es el Ganador");
    }else if (acum4 == acum1 && acum4 == acum2 && acum4 == acum3){
          JOptionPane.showMessageDialog(null, "PERDIERON !!!!!!!!!!!!!!");
    }else
              JOptionPane.showMessageDialog(null, "EMPATE");
   
    new JuegoVeintiuno();
}
    public void actionPerformed(ActionEvent e) {
      //  throw new UnsupportedOperationException("Not supported yet.");
        if(e.getSource().equals(b1)){
            pedirCarta1();

            } else if (e.getSource().equals(b2)){
                pedirCarta2();

            }else if (e.getSource().equals(b3)){
                pedirCarta3();
            }else if (e.getSource().equals(b4)){
                pedirCarta4();
            }else if (e.getSource().equals(Nuevo)){
                ganador();
                dispose();
            }else if (e.getSource().equals(btn1)){
                b1.setEnabled(false);
            }else if (e.getSource().equals(btn2)){
                b3.setEnabled(false);
        } else if (e.getSource().equals(btn3)){
                b2.setEnabled(false);
        } else if (e.getSource().equals(btn4)){
                b4.setEnabled(false);
        }

    }
    }


