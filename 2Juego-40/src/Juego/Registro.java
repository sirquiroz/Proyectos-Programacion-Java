package Juego;

import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Registro extends JFrame implements ActionListener {

    JButton b1, b2, b3, b4, b5;
    JTextField txt, txt1;
    AudioClip music;
    JLabel l1, l2, l3, l4, l5;
    JComboBox sexo = new JComboBox();
    JComboBox sexo1 = new JComboBox();

    String ruta = System.getProperty("user.dir");//para elegir imagenes dentro del proyecto
    JLabel fondo = new JLabel();
    String c = "Masculino", imagen = "/img/m.jpg";
   public String nombre="";
    public Registro(AudioClip music) {
        this.music=music;
        setLayout(null);
        setTitle("Juego 40");
        setSize(650, 440);
        getContentPane().setBackground(Color.black);

        b1 = new JButton("Iniciar Juego");
        b1.setBounds(460, 150, 130, 30);
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);

        txt = new JTextField();
        txt.setBounds(180, 80, 130, 20);

        txt1 = new JTextField();
        txt1.setBounds(180, 200, 130, 20);
             
        l1 = new JLabel("Nombre del Jugador 1: ");
        l1.setBounds(50, 80, 150, 20);
        l1.setForeground(Color.red);
        
        l2 = new JLabel("Nombre del Jugador 2: ");
        l2.setBounds(50, 200, 150, 20);
        l2.setForeground(Color.red);
        
        l3 = new JLabel("Sexo: ");
        l3.setBounds(145, 120, 80, 20);
        l3.setForeground(Color.red);
        
        l4 = new JLabel("Sexo: ");
        l4.setBounds(145, 230, 80, 20);
        l4.setForeground(Color.red);
                                    
        sexo.addItem("Masculino");
        sexo.addItem("Femenino");
        sexo.setBounds(180, 120, 130, 20);
        sexo.addActionListener(this);
        
        sexo1.addItem("Masculino");
        sexo1.addItem("Femenino");
        sexo1.setBounds(180, 230, 130, 20);
        sexo1.addActionListener(this);
                
        l5 = new JLabel("REGISTRO DE DATOS");
        l5.setBounds(300, 30, 180, 20);
        l5.setFont(new Font("Comic Sans MS", 1, 14));

        fondo.setSize(700, 400);
        fondo.setIcon(new ImageIcon(ruta + "/img/azul.png"));


        add(b1);
        add(l2);
        add(l4);
        add(txt);
        add(txt1);
        add(l1);
        add(l3);
        add(sexo);
        add(sexo1);
        add(l5);
        add(fondo);

        b1.addActionListener(this);
        txt.addActionListener(this);


        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(b1)) {
            if (txt.getText().length() == 0) {
            if (txt1.getText().length() ==0){    
                JOptionPane.showMessageDialog(null, "No ha llenado todos los Campos");
                txt.requestFocus();
                txt1.requestFocus();
                txt1.setText("");
                txt.setText("");
            } }else {
                DragCartasPanel t = new DragCartasPanel(this);
              
                nombre = txt.getText();
                nombre = txt1.getText();
                this.dispose();
            }
        }
        if (e.getSource().equals(sexo)) {
            c = sexo.getSelectedItem().toString();
            System.out.println(c);
            if (c == "Femenino") {
                imagen = "/img/f.jpg";
            }
        }
         if (e.getSource().equals(sexo1)) {
            c = sexo1.getSelectedItem().toString();
            System.out.println(c);
            if (c == "Femenino") {
                imagen = "/img/f.jpg";
            }
        }
    }
}
