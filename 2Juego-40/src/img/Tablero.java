package Juego;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Rectangle2D;
import java.util.LinkedList;
import java.util.Random;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Tablero extends JFrame implements ActionListener, MouseListener, MouseMotionListener {

    
    
    private Carta CartaSist=null;
    private Carta CartaSelected=null;
    
    
    private static final int CARTA_DIAMETER_X = 50; // dimensiones de la cartas
    private static final int CARTA_DIAMETER_Y = 70;// dimensiones de la cartas
    private Rectangle2D EspacioCarta=new Rectangle2D.Double((this.getWidth())/2,(this.getHeight())/2,CARTA_DIAMETER_X, CARTA_DIAMETER_Y);
    
    private JButton baraja = new JButton("Barajar");
    private JButton monto1 = new JButton("   ");
    private JButton monto2 = new JButton("   ");
    private JButton bpuntos1 = new JButton(" ");
    private JButton bpuntos2 = new JButton(" ");
    private JLabel lc = new JLabel("Computador");
    private JLabel lcompu = new JLabel();
    private JLabel fondo = new JLabel();
    
    LinkedList<Carta> SCartas = new <Carta> LinkedList();//lista enlazada
     AudioClip musica;
    JLabel l1, l2;
    Vector cartas = new Vector();
    Random aleatorio = new Random();
    String naipe;
    String ruta = System.getProperty("user.dir"); //para elegir imagenes dentro del proyecto
    int c = 0, click = 0;
    JPanel p1;
    //--- instance variables
    /** Ball coords.  Changed by mouse listeners.  Used by paintComponent. */
    private int _ballX     = 0;   // x coord - set from drag
    private int _ballY     = 0;   // y coord - set from drag
    private JLabel carta = new JLabel();
    /** Position in ball of mouse press to make dragging look better. */
    private int _dragFromX = 0;    // pressed this far inside ball's
    private int _dragFromY = 0;    // bounding box.
    
   
    private boolean _canDrag  = false;
     private String Nombre;
    public void Get_nombre(String nom){// ENCAPSULAMIENTO
       this.Nombre= nom;
        l2.setText(this.Nombre);
    }
    
    public Tablero(Registro form) {
        baraja(); //para que se creen todas las rutas cuando se abra el formulario
        setLayout(null);

        setTitle("Juego 40");
        setSize(1140, 720);
        baraja = new JButton("Barajar");
//        b1 = new JButton();
//        //b1.setIcon(new ImageIcon(ruta + "/img/CARTAS.png"));
//        b2 = new JButton();
//        b2.setIcon(new ImageIcon(ruta + "/img/CARTAS.png"));
//        b3 = new JButton();
//        b3.setIcon(new ImageIcon(ruta + "/img/CARTAS.png"));
//        b4 = new JButton();
//        b4.setIcon(new ImageIcon(ruta + "/img/CARTAS.png"));
//        b5 = new JButton();
//        b5.setIcon(new ImageIcon(ruta + "/img/CARTAS.png"));
//        b6 = new JButton();
//        b6.setIcon(new ImageIcon(ruta + "/img/CARTAS.png"));
//        b7 = new JButton();
//        b7.setIcon(new ImageIcon(ruta + "/img/CARTAS.png"));
//        b8 = new JButton();
//        b8.setIcon(new ImageIcon(ruta + "/img/CARTAS.png")); 
//        b9 = new JButton();
//        b9.setIcon(new ImageIcon(ruta + "/img/CARTAS.png"));
//        b10 = new JButton();
//        b10.setIcon(new ImageIcon(ruta + "/img/CARTAS.png"));
      
       
        
        bpuntos1 = new JButton("Ptos: ");
        bpuntos1.setBackground(Color.yellow);
        bpuntos2 = new JButton("Ptos: ");
        bpuntos2.setBackground(Color.yellow);
        
        monto1 = new JButton("  ");
        monto2 = new JButton("   ");       
                              
       l1 = new JLabel();//aqui ira la imagen
       l1.setIcon(new ImageIcon(ruta + form.imagen));
       l1.setBounds(50, 580, 100, 80);
       l1.setForeground(Color.red);
       
       l2 = new JLabel(this.Nombre);
       l2.setBounds(200, 600, 100, 30);
       l2.setForeground(Color.white);
       
        
//        b1.setBounds(425, 10, 50, 70);
//        b2.setBounds(480, 10, 50, 70);
//        b3.setBounds(535, 10, 50, 70);
//        b4.setBounds(590, 10, 50, 70);
//        b5.setBounds(645, 10, 50, 70);
//        
//        b6.setBounds(425, 590, 50, 70);
//        b7.setBounds(480, 590, 50, 70);
//        b8.setBounds(535, 590, 50, 70);
//        b9.setBounds(590, 590, 50, 70);
//        b10.setBounds(645,590, 50, 70);
//        
        lc = new JLabel("Computador");
        lc.setBounds(200, 10, 100, 30);
        lc.setForeground(Color.white);

        lcompu = new JLabel(); // imagen del computador
        lcompu.setBounds(190, 50, 100, 80);
        lcompu.setIcon(new ImageIcon("/img/computador.jpg"));

        
        bpuntos1.setBounds(800, 15, 50, 30);
        bpuntos2.setBounds(800, 625, 50, 30);
        
        monto1.setBounds(900, 15, 90, 30);
        monto2.setBounds(900, 625, 90, 30);
        
        baraja.setBounds(720, 320, 90, 35);
        
        add(lc);
        add(lcompu);
        add(monto2);     
        add(monto1);
        add(bpuntos2);
        add(bpuntos1);
        add(l1);
        add(l2);
//        add(b1);
//        add(b2);
//        add(b3);
//        add(b4);
//        add(b5);
//        add(b6);
//        add(b7);
//        add(b8);
//        add(b9);
//        add(b10);
    baraja.addActionListener(this); //CUANDO HAGA CLICK EN BARAJA
        add(baraja);
        add(carta);
        add(fondo);
        
        
        form.music = Applet.newAudioClip(getClass().getResource("/img/apolo.wav"));
        movimiento();
        setVisible(true);
        this.setFocusCycleRoot(true);
        form.music.stop();
        form.music.play();
        form.music.loop();
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
      

    }
 public void movimiento(){
//    b6.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
//            public void mouseDragged(java.awt.event.MouseEvent evt) {
//                bMovimiento(evt);
//            }
//           
//        });
//    b7.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
//            public void mouseDragged(java.awt.event.MouseEvent evt) {
//                bMovimiento(evt);
//            }
//           
//        });
//    b8.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
//            public void mouseDragged(java.awt.event.MouseEvent evt) {
//                bMovimiento(evt);
//            }
//           
//        });
//    b9.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
//            public void mouseDragged(java.awt.event.MouseEvent evt) {
//                bMovimiento(evt);
//            }
//           
//        });
//    b10.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
//            public void mouseDragged(java.awt.event.MouseEvent evt) {
//                bMovimiento(evt);
//            }
//           
//        });
//    b1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
//            public void mouseDragged(java.awt.event.MouseEvent evt) {
//                bMovimiento(evt);
//            }
//           
//        });
//    b2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
//            public void mouseDragged(java.awt.event.MouseEvent evt) {
//                bMovimiento(evt);
//            }
//           
//        });
//    b3.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
//            public void mouseDragged(java.awt.event.MouseEvent evt) {
//                bMovimiento(evt);
//            }
//           
//        });
//    b4.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
//            public void mouseDragged(java.awt.event.MouseEvent evt) {
//                bMovimiento(evt);
//            }
//           
//        });
//    b5.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
//            public void mouseDragged(java.awt.event.MouseEvent evt) {
//                bMovimiento(evt);
//            }
//           
//        });
}
 

private void bMovimiento(java.awt.event.MouseEvent evt) {

//b6.setBounds(evt.getX(), evt.getY(), b6.getWidth(), b6.getHeight());
//b7 = (JButton) evt.getSource();
//b7.setBounds(evt.getX(), evt.getY(), b7.getWidth(), b7.getHeight());
//b8 = (JButton) evt.getSource();
//b8.setBounds(evt.getX(), evt.getY(), b8.getWidth(), b8.getHeight());
//b9 = (JButton) evt.getSource();
//b9.setBounds(evt.getX(), evt.getY(), b9.getWidth(), b9.getHeight());
//b10 = (JButton) evt.getSource();
//b10.setBounds(evt.getX(), evt.getY(), b10.getWidth(), b10.getHeight());
//b1 = (JButton) evt.getSource();
//b1.setBounds(evt.getX(), evt.getY(), b1.getWidth(), b1.getHeight());
//b2 = (JButton) evt.getSource();
//b2.setBounds(evt.getX(), evt.getY(), b2.getWidth(), b2.getHeight());
//b3 = (JButton) evt.getSource();
//b3.setBounds(evt.getX(), evt.getY(), b3.getWidth(), b3.getHeight());
//b4 = (JButton) evt.getSource();
//b4.setBounds(evt.getX(), evt.getY(), b4.getWidth(), b4.getHeight());
//b5 = (JButton) evt.getSource();
//b5.setBounds(evt.getX(), evt.getY(), b5.getWidth(), b5.getHeight());
}
 



    public void baraja() { //donde se encontrarán la ruta de todas las cartas
        cartas.add("/img/A-C-N.png");
        cartas.add("/img/A-C-R.png");
        cartas.add("/img/A-D-R.png");
        cartas.add("/img/A-T-N.png");
        cartas.add("/img/2-C-N.png");
        cartas.add("/img/2-C-R.png");
        cartas.add("/img/2-D-R.png");
        cartas.add("/img/2-T-N.png");
        cartas.add("/img/3-C-N.png");
        cartas.add("/img/3-C-R.png");
        cartas.add("/img/3-D-R.png");
        cartas.add("/img/3-T-N.png");
        cartas.add("/img/4-C-N.png");
        cartas.add("/img/4-C-R.png");
        cartas.add("/img/4-D-R.png");
        cartas.add("/img/4-T-N.png");
        cartas.add("/img/5-C-N.png");
        cartas.add("/img/5-C-R.png");
        cartas.add("/img/5-D-R.png");
        cartas.add("/img/5-T-N.png");
        cartas.add("/img/6-C-N.png");
        cartas.add("/img/6-C-R.png");
        cartas.add("/img/6-D-R.png");
        cartas.add("/img/6-T-N.png");
        cartas.add("/img/7-C-N.png");
        cartas.add("/img/7-C-R.png");
        cartas.add("/img/7-D-R.png");
        cartas.add("/img/7-T-N.png");
        cartas.add("/img/J-C-N.png");
        cartas.add("/img/J-C-R.png");
        cartas.add("/img/J-D-R.png");
        cartas.add("/img/J-T-N.png");
        cartas.add("/img/Q-C-N.png");
        cartas.add("/img/Q-C-R.png");
        cartas.add("/img/Q-D-R.png");
        cartas.add("/img/Q-T-N.png");
        cartas.add("/img/K-C-N.png");
        cartas.add("/img/K-C-R.png");
        cartas.add("/img/K-D-R.png");
        cartas.add("/img/K-T-N.png");
        
    }
private void coordenadasIniciales() {

        for(Carta c : this.SCartas) {
            c.setBounds(c.x,c.y,c.tamx,c.tamy);
        }
            
    }
   public void actionPerformed(ActionEvent e) {
       
       
       
/*
//        if (e.getSource().equals(baraja)) {
//            click++;
//            while (c != 10) {
//                int n = aleatorio.nextInt(cartas.size()); //un aleatorio de las cartas que existen
//                naipe = cartas.elementAt(n).toString(); //cogiendo la dirección de la carta que se encuentra en el vector
//                cartas.remove(n);
//                switch (c) {
//                    case 0:
//                        b1.setIcon(new ImageIcon(ruta + naipe));
//                        c++;
//                        break;
//                    case 1:
//                        b2.setIcon(new ImageIcon(ruta + naipe));
//                        c++;
//                        break;
//                    case 2:
//                        b3.setIcon(new ImageIcon(ruta + naipe));
//                        c++;
//                        break;
//                    case 3:
//                        b4.setIcon(new ImageIcon(ruta + naipe));
//                        c++;
//                        break;
//                    case 4:
//                        b5.setIcon(new ImageIcon(ruta + naipe));
//                        c++;
//                        break;
//                    case 5:
//                        b6.setIcon(new ImageIcon(ruta + naipe));
//                        c++;
//                        break;
//                    case 6:
//                        b7.setIcon(new ImageIcon(ruta + naipe));
//
//                        c++;
//                        break;
//                    case 7:
//                        b8.setIcon(new ImageIcon(ruta + naipe));
//                        c++;
//                        break;
//                    case 8:
//                        b9.setIcon(new ImageIcon(ruta + naipe));
//                        c++;
//                        break;
//                    case 9:
//                        b10.setIcon(new ImageIcon(ruta + naipe));
//                        c++;
//                        break;
//                }
//            }
//            if (click == 4) //para cuando termine las cartas
//            {
//                baraja.setEnabled(false);
//            }
//            c = 0; //para empezar una nueva ronda de cartas
//        }
*/
    }
    
    
 
    public void paintComponent(Graphics g) { //movimiento de carta en X,Y
   
      
        
        carta.setBounds(_ballX, _ballY, CARTA_DIAMETER_X, CARTA_DIAMETER_Y);
    }
    @Override
    public void mouseClicked(MouseEvent e) {
     
    }

    @Override
    public void mousePressed(MouseEvent e) {
        {

    }
        
//      int x = e.getX();   //Devuelven la posición x,y del mouse
//        int y = e.getY();   
//        
//        if (x >= _ballX && x <= (_ballX + CARTA_DIAMETER_X)
//                && y >= _ballY && y <= (_ballY + CARTA_DIAMETER_Y)) {
//            _canDrag = true;
//            _dragFromX = x - _ballX;  
//            _dragFromY = y - _ballY;  
//        } else {
//            _canDrag = false;
//        }
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }
    

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseExited(MouseEvent e) {
     _canDrag= false;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        
        
        //    if (_canDrag) {   
//            _ballX = e.getX() - _dragFromX;
//            _ballY = e.getY() - _dragFromY;
//            
//            _ballX = Math.max(_ballX, 0);
//            _ballX = Math.min(_ballX, getWidth() - CARTA_DIAMETER_X);
//           
//            _ballY = Math.max(_ballY, 0);
//            _ballY = Math.min(_ballY, getHeight() - CARTA_DIAMETER_Y);
//            
//            this.repaint(); 
//        }
    }

    @Override
    public void mouseMoved(MouseEvent e) { // Se activa cuando se produce un movimiento del mouse
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
