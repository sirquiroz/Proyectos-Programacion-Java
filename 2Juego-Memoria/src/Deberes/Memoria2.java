/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Deberes;


import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.swing.*;
/**
 *
 * @author DataFourDesicion
 */
public class Memoria2 extends JFrame implements ActionListener{
    
    BufferedImage img = null;
    ImageIcon star;
    JButton a = null;//APUNTA AL PRIMER BOTON
    JButton b = null;//APUNTA AL SEGUNDO BOTON
    JPanel panel;//PANEL: TIENE LOS JBUTTON[][]. BACK_PANEL: BACKGROUND DE LA APLICACION
    JFrame lvl_panel;//ELEGIR NIVEL DE DIFICULTAD
    Vector letras;//ALMACENA EL VECTOR LETRAS
    String[][] letras_array;//MAPA INTERNO DEL JUEGO MEMORIA
    JButton[][] btn_array;//ARRAY DE BOTONES
    Random aleatorio = new Random();//GENERA NUMEROS ALEATORIOS
    JLabel bglabel;//LABEL QUE TIENE EL BACKGROUND
    JLabel trylabel,counter = new JLabel();//LABEL QUE ALMACENA EL NUMERO DE INTENTOS
    int contador = 0;//CUENTA LOS INTENTOS
    int evaluador,min=0;//VERIFICA SI EL JUEGO TERMINA
    String filename, name;//NOMBRE DE ARCHIVO DEL ICONO, NOMBRE DE USUARIO
    Timer t;
    private long t1;
    
    public Memoria2(){
        leerImagen();
        java.net.URL url = getClass().getResource("/Background/star.png");
        java.awt.Image imagen = getToolkit().getImage(url);
        setIconImage(imagen);
        JMenuBar menubar = new JMenuBar();
        JMenu menu_file = new JMenu("Partida");
        JMenuItem nuevo = new JMenuItem("Nuevo Juego");
        JMenuItem salir = new JMenuItem("SALIR");
         JMenu About = new JMenu("?");
        JMenuItem Acerca = new JMenuItem("Acerca..");
        menu_file.add(nuevo);
        menu_file.add(salir);
        menubar.add(menu_file);
        About.add(Acerca);
        menubar.add(About);
       
        setJMenuBar(menubar);
        setLayout(new FlowLayout());
        setTitle("JUEGO DE MEMORIA");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 610);
        //setResizable(false);
        setLocationRelativeTo(null);
        bglabel = new JLabel();
        bglabel.setBounds(0, 0, getWidth(), getHeight());
        bglabel.setLayout(null);
        bglabel.setIcon(new ImageIcon(img));
        bglabel.setVisible(true);
        trylabel = new JLabel("Intentos: "+contador, 2);
        trylabel.setFont(new Font("Verdana", Font.ITALIC, 18));
        counter.setFont(new Font("Verdana", Font.ITALIC, 18));
        trylabel.setVisible(false);
        add(bglabel);
        setVisible(true);
        salir.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Gracias por jugar");
                System.exit(0);
            }
        });
           Acerca.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Desarrollado por : Bryan Macías \n Vanessa Machado "
                        + "\n Programación 2 "
                        + "\n Universidad Politécnica Salesiana"
                        + "\n Todos Los Derechos Reservados ©  2012", "Acerca", 2);
            }
        });
        nuevo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                counter.setVisible(false);
                counter.setText(null);
                trylabel.setVisible(false);
                contador = 0;
                name = JOptionPane.showInputDialog(null, "Ingrese su nombre: ").toUpperCase();
                if (name.equals("")) {
                    name = "Usuario".toUpperCase();
                }
                setTitle("JUEGO DE MEMORIA. Bienvenido: "+name);
                if(panel != null) {
                    //JOptionPane.showMessageDialog(null, "No es null");
                    panel.removeAll();
                    remove(panel);
                    revalidate();
                    repaint();
                    
                    //jlpanel.remove(panel);
                }
                lvl_panel = new JFrame();
                JButton btn_easy, btn_medium, btn_hard;
                btn_easy = new JButton("FACIL");
                btn_medium = new JButton("MEDIO");
                btn_hard = new JButton("DIFICIL");
                lvl_panel.setLayout(new GridLayout(3, 1, 4, 4));
                lvl_panel.setTitle("DIFICULTAD");
                lvl_panel.setSize(200, 200);
                lvl_panel.setResizable(false);
                lvl_panel.setLocationRelativeTo(null);
                lvl_panel.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                lvl_panel.setVisible(true);
                lvl_panel.add(btn_easy);
                lvl_panel.add(btn_medium);
                lvl_panel.add(btn_hard);
                btn_easy.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        
                        filling_array(2);
                        lvl_panel.dispose();
                    }
                });
                btn_medium.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        filling_array(4);
                        lvl_panel.dispose();
                    }
                });
                btn_hard.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        filling_array(6);
                        lvl_panel.dispose();
                    }
                });
            }
        });
    }
    ActionListener contando = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            int seg = Math.round(System.currentTimeMillis()-t1)/1000;
            if(seg>59){
                min++;
                t1 = System.currentTimeMillis();
            }
            counter.setText(String.valueOf(min)+":"+String.valueOf(seg));
        }
    };
    public void filling_array(final int base){
        t1 = System.currentTimeMillis();
        t = new Timer(2, contando);
        t.start();
        counter.setVisible(true);
        bglabel.add(counter);
        counter.setBounds(0, 800, 90, 50);
        trylabel.setBounds(0, 0, 80, 50);
        trylabel.setVisible(true);
        bglabel.add(trylabel);
        evaluador = base * (base/2);
        filename = "icons/"+base+"/";
        star = new ImageIcon(filename+"/star.png");
        letras = new Vector();
        panel = new JPanel(new GridLayout(base, base, 4, 4));
        letras_array = new String[base][base];
        for (int i = 1; i <= ((base)*(base/2)); i++) {
            letras.add(i+".png");
            letras.add(i+".png");
        }
        for (int i = 0; i < letras_array.length; i++) {
            for (int j = 0; j < letras_array.length; j++) {
                //JOptionPane.showMessageDialog(null, letras.size());
                int n = aleatorio.nextInt(letras.size());
                letras_array[i][j] = letras.elementAt(n).toString();
                //JOptionPane.showMessageDialog(null, letras_array[i][j]);
                letras.remove(n);
            }

        }
        btn_array = new JButton[base][base];
        for (int i = 0; i < btn_array.length; i++) {
            for (int j = 0; j < btn_array.length; j++) {
                btn_array[i][j] = new JButton();
                btn_array[i][j].setIcon(star);
                btn_array[i][j].setVisible(true);
                btn_array[i][j].setEnabled(true);
                btn_array[i][j].setText(null);
                btn_array[i][j].setBackground(new Color(135, 206, 250));
                btn_array[i][j].setSize(2, 2);
                panel.add(btn_array[i][j]);
                btn_array[i][j].addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(a != null && b != null) {
                            flip();
                        }
                        for (int k = 0; k < btn_array.length; k++) {
                            for (int l = 0; l < btn_array[k].length; l++) {
                                if(e.getSource().equals(btn_array[k][l])){
                                    //JOptionPane.showMessageDialog(null, "Entro al evento "+btn_array[k][l].isEnabled());
                                    if(btn_array[k][l].getIcon() != star && btn_array[k][l].isEnabled()){
                                        //JOptionPane.showMessageDialog(null, "Entro y cambio a imagen");
                                        btn_array[k][l].setIcon(null);
                                        btn_array[k][l].setIcon(star);
                                    }
                                    if(btn_array[k][l].getIcon() == star && btn_array[k][l].isEnabled()){
                                        //JOptionPane.showMessageDialog(null, "Entro y cambio a texto");
                                        btn_array[k][l].setIcon(null);
                                        btn_array[k][l].setIcon(new ImageIcon(filename+"/"+letras_array[k][l]));
                                        //btn_array[k][l].setText(letras_array[k][l]);
                                    }
                                    if (a == null) {
                                        //JOptionPane.showMessageDialog(null, "'A' tomo el valor del boton");
                                        a = btn_array[k][l];
                                    }else{
                                        if(b == null){
                                            if (a == btn_array[k][l]) {
                                                //JOptionPane.showMessageDialog(null, "Click en el mismo boton");
                                                flip();
                                                a = null;
                                            }else{
                                                //JOptionPane.showMessageDialog(null, "'B' tomo el valor del boton");
                                                b = btn_array[k][l];
                                            }
                                        }
                                    }
                                    if (a != null && b != null) {
                                        contador++;
                                        trylabel.setText("Intentos: "+contador);
                                        //JOptionPane.showMessageDialog(null, "'A' y 'B' no tienen null");
                                        if (a.getIcon().toString().equals(b.getIcon().toString())) {
                                            //JOptionPane.showMessageDialog(null, "SON IGUALES");
                                            evaluador--;
                                            a.setEnabled(false);
                                            b.setEnabled(false);
                                        }
                                    }
                                }
                                
                            }
                            
                        }
                        if(evaluador == 0){
                            JOptionPane.showMessageDialog(null, "Felicidades "+name+" usted ha terminado el juego en "+contador+" intentos!");
                            t.stop();
                            JOptionPane.showMessageDialog(null, t.isRunning());
                        }
                    }
                });
            }
        }
        panel.setVisible(true);
        panel.setOpaque(false);
        panel.addComponentListener(new ComponentListener() {

            @Override
            public void componentResized(ComponentEvent e) {
                int x = 0, y = 0, pixel = 0;
                switch(base){
                    case 2:{
                        x = 225;
                        y = 100;
                        pixel = 170;
                    }break;
                    case 4:{
                         x = 170;
                         y = 75;
                         pixel = 100;
                    }break;
                    case 6:{
                        x = 125;
                        y = 35;
                        pixel = 80;
                    }break;
                }
                trylabel.setBounds(x, y-30, 140, 20);
                counter.setBounds(x+pixel*base-20, y-30, 140, 20);
                
                panel.setBounds(x, y, pixel*base+(4*(base)), pixel*base+(4*(base)));
                //JOptionPane.showMessageDialog(null, "se movio el grid");
            }

            @Override
            public void componentMoved(ComponentEvent e) {
                //throw new UnsupportedOperationException("Not supported yet.");
            }

            @Override
            public void componentShown(ComponentEvent e) {
                //throw new UnsupportedOperationException("Not supported yet.");
            }

            @Override
            public void componentHidden(ComponentEvent e) {
                //throw new UnsupportedOperationException("Not supported yet.");
            }
        });
        panel.setBounds(100, 100, getWidth(), getHeight());
        bglabel.add(panel);
        //jlpanel.add(panel, JLayeredPane.DEFAULT_LAYER);
        revalidate();
        repaint();
    }
    
    public void flip(){
        for (int i = 0; i < btn_array.length; i++) {
            for (int j = 0; j < btn_array[i].length; j++) {
                if(btn_array[i][j].getIcon() != star && btn_array[i][j].isEnabled()){
                    btn_array[i][j].setIcon(null);
                    btn_array[i][j].setIcon(star);
                }
            }
            
        }
        a=null;b=null;
    }
    
    public final void leerImagen(){

        try {
            img = ImageIO.read(new File("fondo.JPG"));
        } catch (IOException ex) {
            System.out.println("No se pudo leer la imagen" +ex);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
   
}
