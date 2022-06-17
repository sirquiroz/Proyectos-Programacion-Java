package Juego;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Juego40 extends JFrame implements ActionListener {

    JButton b1;
    JButton b3;
    JPanel p1;
    String ruta = System.getProperty("user.dir");//para elegir imagenes dentro del proyecto
    JLabel fondo = new JLabel();
    AudioClip musica;

    public Juego40() {

        p1 = new JPanel();

        b1 = new JButton(" JUGAR ");
        b1.setBounds(830, 200, 90, 30);
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);



        b3 = new JButton("Salir");
        b3.setBounds(830, 400, 90, 30);
        b3.setBackground(Color.black);
        b3.setForeground(Color.white);
        fondo.setSize(800, 700);
        fondo.setIcon(new ImageIcon(ruta + "/img/imagenFondo1.png"));//imagen del fondo


        add(fondo);
        add(b1);

        add(b3);

        b1.addActionListener(this);

        b3.addActionListener(this);
        musica = Applet.newAudioClip(getClass().getResource("/img/sonido.wav"));
        setTitle("Juego 40 ");
        setSize(980, 720);

        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.black);

        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        musica.play();
        musica.loop();
        setLocationRelativeTo(null);

    }

    public static void main(String[] args) {
        Juego40 j = new Juego40();
        j.setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(b1)) { // estamos enlazando con registro
            Registro reg = new Registro(this.musica);
            this.dispose();

        }
        if (e.getSource().equals(b3)) {
            JOptionPane.showMessageDialog(null, "Gracias por jugar 40!");
            System.exit(0);


        }


    }
}
