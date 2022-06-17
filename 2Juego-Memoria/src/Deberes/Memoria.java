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
 * @author Laboratorio 5 PC01
 */
public class Memoria extends JFrame implements ActionListener{
    BufferedImage img = null;
    ImageIcon star;
    JButton a = null;
    JButton b = null;
    JPanel panel, back_panel;
    JFrame lvl_panel;
    Vector letras;
    String[][] letras_array;
    JButton[][] btn_array;
    Random aleatorio = new Random();
    JLayeredPane jlpanel;
    JLabel bglabel;
    JLabel trylabel;
    int contador = 0;
    int evaluador;
    String filename, name;
    
    public Memoria(){
        jlpanel = new JLayeredPane();
        back_panel = new JPanel(new FlowLayout());
        leerImagen();
        addComponentListener(new ComponentListener() {

            @Override
            public void componentResized(ComponentEvent e) {
                //throw new UnsupportedOperationException("Not supported yet.");
                //resizeImage(img, getWidth(), getHeight());
                bglabel.setIcon(null);
                bglabel.setBounds(0, 0, getWidth(), getHeight());
                bglabel.setIcon(new ImageIcon(resizeImage(img, getWidth(), getHeight())));
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

            private Image resizeImage(BufferedImage img, int x, int y) {
                BufferedImage newimg = new BufferedImage(x, y, BufferedImage.TYPE_INT_RGB);
                Graphics2D g2 = newimg.createGraphics();
                g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                g2.drawImage(img, 0, 0, x, y, null);
                g2.dispose();
                return newimg;
            }
        });
        JMenuBar menubar = new JMenuBar();
        JMenu menu_file = new JMenu("Partida");
        JMenuItem nuevo = new JMenuItem("Nuevo Juego");
        JMenuItem salir = new JMenuItem("SALIR");
        menu_file.add(nuevo);
        menu_file.add(salir);
        menubar.add(menu_file);
        setJMenuBar(menubar);
        setLayout(null);
        setTitle("JUEGO DE MEMORIA");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700, 600);
        setResizable(false);
        setLocationRelativeTo(null);
        jlpanel.setSize(getWidth(), getHeight());
        jlpanel.setVisible(true);
        bglabel = new JLabel();
        bglabel.setBounds(0, 0, getWidth(), getHeight());
        //bglabel.setSize(img.getWidth(), img.getHeight());
        bglabel.setIcon(new ImageIcon(img));
        bglabel.setVisible(true);
        trylabel = new JLabel("Intentos: "+contador, 2);
        trylabel.setFont(new Font("Verdana", Font.ITALIC, 18));
        back_panel.add(bglabel);
        back_panel.setVisible(true);
        back_panel.addComponentListener(new ComponentListener() {

            @Override
            public void componentResized(ComponentEvent e) {
                //throw new UnsupportedOperationException("Not supported yet.");
                back_panel.setBounds(0, 0, getWidth(), getHeight());
                //JOptionPane.showMessageDialog(null, "Se movio el jlabel");
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
        jlpanel.add(back_panel, JLayeredPane.FRAME_CONTENT_LAYER);
        //trylabel.setBounds(0, 680, 80, 20);
        trylabel.setVisible(false);
        jlpanel.add(trylabel, JLayeredPane.PALETTE_LAYER);
        jlpanel.setVisible(true);
        jlpanel.setLayout(new FlowLayout());
        getContentPane().add(jlpanel);
        setVisible(true);
        //add(back_panel);
        salir.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Gracias por jugar");
                System.exit(0);
            }
        });
        nuevo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                trylabel.setVisible(false);
                contador = 0;
                name = JOptionPane.showInputDialog(null, "Ingrese su nombre: ").toUpperCase();
                if (name.equals("")) {
                    name = "Usuario".toUpperCase();
                }
                setTitle("JUEGO DE MEMORIA. Bienvenido: "+name);
                if(panel != null) {
                    panel.removeAll();
                    jlpanel.remove(panel);
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
    public final void leerImagen(){

        try {
            img = ImageIO.read(new File("fondo.JPG"));
        } catch (IOException ex) {
            System.out.println("No se pudo leer la imagen" +ex);
        }
    }
    public void filling_array(final int base){
        trylabel.setVisible(true);
        evaluador = base * (base/2);
        filename = "icons/"+base+"/";
        star = new ImageIcon(filename+"/star.png");
        letras = new Vector();
        panel = new JPanel(new GridLayout(base, base, 4, 4));
        panel.addComponentListener(new ComponentListener() {

            @Override
            public void componentResized(ComponentEvent e) {
                int x = 0, y = 0, pixel = 0;
                switch(base){
                    case 2:{
                        x = 200;
                        y = 170;
                        pixel = 170;
                    }break;
                    case 4:{
                         x = 150;
                         y = 120;
                         pixel = 100;
                    }break;
                    case 6:{
                        x = 100;
                        y = 100;
                        pixel = 80;
                    }break;
                }
                trylabel.setBounds(x-20, y-20, 140, 20);
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
        //panel.setLocation(200, 200);
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
                                        contador++;
                                        trylabel.setText("Intentos: "+contador);
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
                        }
                    }
                });
            }
        }
        panel.setVisible(true);
        panel.setOpaque(false);
        panel.setBounds(100, 100, getWidth(), getHeight());
        jlpanel.add(panel, JLayeredPane.DEFAULT_LAYER);
        validate();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
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
    public static void main(String[] args) {
        Memoria memoria = new Memoria();
    }
}
/*
 * PARA EVITAR EL FLASH EN EL PROGRAMA SE TIENE QUE DESACTIVAR TODOS LOS
 * "COMPONENTRESIZED" DE CADA ADDCOMPONENTLISTENER
 */