package juegoadivina;

import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.event.WindowEvent;
import javax.swing.JTextField;

public class Juegoadivina extends JFrame implements ActionListener {

    int numero;
    JButton boton1,boton2,boton3,boton4,boton5,boton6,boton7,boton8,boton9,boton10,boton11,boton12;
    int contador = 0;
    String n = JOptionPane.showInputDialog("Ingrese Nombre ");

    public Juegoadivina() {

        Random Aleatorio = new Random();
        numero = Aleatorio.nextInt(10) + 1;
        setLayout(new GridLayout(4, 4));
        setTitle(" Sony Entertainment ");

//       setUndecorated(true);
        boton1= new JButton ("1");
        boton2= new JButton ("2");
        boton3= new JButton ("3");
        boton4= new JButton ("4");
        boton5= new JButton ("5");
        boton6= new JButton ("6");
        boton7= new JButton ("7");
        boton8= new JButton ("8");
        boton9= new JButton ("9");
        boton10= new JButton ("0");
        boton11= new JButton ("nuevo");
        boton12= new JButton ("cerrar");
        
        
        //agregar
        add(boton1);
        boton1.addActionListener(this);
        boton1.setEnabled(false);
        add(boton2);
        boton2.addActionListener(this);
        boton2.setEnabled(false);
        add(boton3);
        boton3.addActionListener(this);
        boton3.setEnabled(false);
        add(boton4);
        boton4.addActionListener(this);
        boton4.setEnabled(false);
        add(boton5);
        boton5.addActionListener(this);
        boton5.setEnabled(false);
        add(boton6);
        boton6.addActionListener(this);
        boton6.setEnabled(false);
        add(boton7);
        boton7.addActionListener(this);
        boton7.setEnabled(false);
        add(boton8);
        boton8.addActionListener(this);
        boton8.setEnabled(false);
        add(boton9);
        boton9.addActionListener(this);
        boton9.setEnabled(false);
        add(boton10);
        boton10.addActionListener(this);
        boton10.setEnabled(false);
        add(boton11);
        boton11.addActionListener(this);
        boton11.setEnabled(true);
        boton11.setBackground(Color.RED);
        add(boton12);
        boton12.addActionListener(this);
        boton12.setEnabled(true);
        boton12.setBackground(Color.RED);

        setSize(300, 450);
        setBackground(Color.red);
//        getContentPane().setBackground(Color.blue);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Juegoadivina();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(boton1)) {
            if (numero == 1) {
                boton1.setBackground(Color.blue);
                JOptionPane.showMessageDialog(null, "ERES EL GANADOR ERES UN DURO " + n);
                contador = 0;
                boton1.setEnabled(false);
                boton2.setEnabled(false);
                boton3.setEnabled(false);
                boton4.setEnabled(false);
                boton5.setEnabled(false);
                boton6.setEnabled(false);
                boton7.setEnabled(false);
                boton8.setEnabled(false);
                boton9.setEnabled(false);
                boton10.setEnabled(false);
                boton11.setEnabled(true);
                boton12.setEnabled(true);
            } else {
                ++contador;
                 JOptionPane.showMessageDialog(null, "Muertes " + contador);
                if (contador == 4) {
                 boton1.setEnabled(false);
                boton2.setEnabled(false);
                boton3.setEnabled(false);
                boton4.setEnabled(false);
                boton5.setEnabled(false);
                boton6.setEnabled(false);
                boton7.setEnabled(false);
                boton8.setEnabled(false);
                boton9.setEnabled(false);
                boton10.setEnabled(false);
                boton11.setEnabled(true);
                boton12.setEnabled(true);
                    JOptionPane.showMessageDialog(null, "HAS PERDIDO  " + n);
                    contador = 0;
                }
            }
        }
        if (e.getSource().equals(boton2)) {
            if (numero == 2) {
                boton2.setBackground(Color.blue);
               JOptionPane.showMessageDialog(null, "ERES EL GANADOR ERES UN DURO " + n);
                contador = 0;
                boton1.setEnabled(false);
                boton2.setEnabled(false);
                boton3.setEnabled(false);
                boton4.setEnabled(false);
                boton5.setEnabled(false);
                boton6.setEnabled(false);
                boton7.setEnabled(false);
                boton8.setEnabled(false);
                boton9.setEnabled(false);
                boton10.setEnabled(false);
                boton11.setEnabled(true);
                boton12.setEnabled(true);
            } else {
                ++contador;
                 JOptionPane.showMessageDialog(null, "Muertes " + contador);
                if (contador == 4) {
                   boton1.setEnabled(false);
                boton2.setEnabled(false);
                boton3.setEnabled(false);
                boton4.setEnabled(false);
                boton5.setEnabled(false);
                boton6.setEnabled(false);
                boton7.setEnabled(false);
                boton8.setEnabled(false);
                boton9.setEnabled(false);
                boton10.setEnabled(false);
                boton11.setEnabled(true);
                boton12.setEnabled(true);
                    JOptionPane.showMessageDialog(null, "HAS PERDIDO  " + n);
                    contador = 0;
                }
            }
        }

        if (e.getSource().equals(boton3)) {
            if (numero == 3) {
                boton3.setBackground(Color.blue);
                JOptionPane.showMessageDialog(null, "ERES EL GANADOR ERES UN DURO " + n);
                contador = 0;
                boton1.setEnabled(false);
                boton2.setEnabled(false);
                boton3.setEnabled(false);
                boton4.setEnabled(false);
                boton5.setEnabled(false);
                boton6.setEnabled(false);
                boton7.setEnabled(false);
                boton8.setEnabled(false);
                boton9.setEnabled(false);
                boton10.setEnabled(false);
                boton11.setEnabled(true);
                boton12.setEnabled(true);
            } else {
                ++contador;
                 JOptionPane.showMessageDialog(null, "Muertes " + contador);
                if (contador == 4) {
                boton1.setEnabled(false);
                boton2.setEnabled(false);
                boton3.setEnabled(false);
                boton4.setEnabled(false);
                boton5.setEnabled(false);
                boton6.setEnabled(false);
                boton7.setEnabled(false);
                boton8.setEnabled(false);
                boton9.setEnabled(false);
                boton10.setEnabled(false);
                boton11.setEnabled(true);
                boton12.setEnabled(true);
                    JOptionPane.showMessageDialog(null, "HAS PERDIDO  " + n);
                    contador = 0;
                }
            }
        }

        if (e.getSource().equals(boton4)) {
            if (numero == 4) {
                boton4.setBackground(Color.blue);
               JOptionPane.showMessageDialog(null, "ERES EL GANADOR ERES UN DURO " + n);
                contador = 0;
               boton1.setEnabled(false);
                boton2.setEnabled(false);
                boton3.setEnabled(false);
                boton4.setEnabled(false);
                boton5.setEnabled(false);
                boton6.setEnabled(false);
                boton7.setEnabled(false);
                boton8.setEnabled(false);
                boton9.setEnabled(false);
                boton10.setEnabled(false);
                boton11.setEnabled(true);
                boton12.setEnabled(true);
            } else {
                ++contador;
                 JOptionPane.showMessageDialog(null, "Muertes " + contador);
                if (contador == 4) {
                boton1.setEnabled(false);
                boton2.setEnabled(false);
                boton3.setEnabled(false);
                boton4.setEnabled(false);
                boton5.setEnabled(false);
                boton6.setEnabled(false);
                boton7.setEnabled(false);
                boton8.setEnabled(false);
                boton9.setEnabled(false);
                boton10.setEnabled(false);
                boton11.setEnabled(true);
                boton12.setEnabled(true);
                    JOptionPane.showMessageDialog(null, "HAS PERDIDO  " + n);
                    contador = 0;
                }
            }
        }

        if (e.getSource().equals(boton5)) {
            if (numero == 5) {
                boton5.setBackground(Color.blue);
               JOptionPane.showMessageDialog(null, "ERES EL GANADOR ERES UN DURO " + n);
                contador = 0;
                boton1.setEnabled(false);
                boton2.setEnabled(false);
                boton3.setEnabled(false);
                boton4.setEnabled(false);
                boton5.setEnabled(false);
                boton6.setEnabled(false);
                boton7.setEnabled(false);
                boton8.setEnabled(false);
                boton9.setEnabled(false);
                boton10.setEnabled(false);
                boton11.setEnabled(true);
                boton12.setEnabled(true);
            } else {
                ++contador;
                 JOptionPane.showMessageDialog(null, "Muertes " + contador);
                if (contador == 4) {
                    boton1.setEnabled(false);
                boton2.setEnabled(false);
                boton3.setEnabled(false);
                boton4.setEnabled(false);
                boton5.setEnabled(false);
                boton6.setEnabled(false);
                boton7.setEnabled(false);
                boton8.setEnabled(false);
                boton9.setEnabled(false);
                boton10.setEnabled(false);
                boton11.setEnabled(true);
                boton12.setEnabled(true);
                    JOptionPane.showMessageDialog(null, "HAS PERDIDO  " + n);
                    contador = 0;
                }
            }
        }

        if (e.getSource().equals(boton6)) {
            if (numero == 6) {
                boton6.setBackground(Color.blue);
               JOptionPane.showMessageDialog(null, "ERES EL GANADOR ERES UN DURO " + n);
                contador = 0;
                boton1.setEnabled(false);
                boton2.setEnabled(false);
                boton3.setEnabled(false);
                boton4.setEnabled(false);
                boton5.setEnabled(false);
                boton6.setEnabled(false);
                boton7.setEnabled(false);
                boton8.setEnabled(false);
                boton9.setEnabled(false);
                boton10.setEnabled(false);
                boton11.setEnabled(true);
                boton12.setEnabled(true);
            } else {
                ++contador;
             JOptionPane.showMessageDialog(null, "Muertes " + contador);
                if (contador == 4) {
                boton1.setEnabled(false);
                boton2.setEnabled(false);
                boton3.setEnabled(false);
                boton4.setEnabled(false);
                boton5.setEnabled(false);
                boton6.setEnabled(false);
                boton7.setEnabled(false);
                boton8.setEnabled(false);
                boton9.setEnabled(false);
                boton10.setEnabled(false);
                boton11.setEnabled(true);
                boton12.setEnabled(true);
                    JOptionPane.showMessageDialog(null, "HAS PERDIDO  " + n);
                    contador = 0;
                }
            }
        }
        if (e.getSource().equals(boton7)) {
            if (numero == 7) {
                boton7.setBackground(Color.blue);
                JOptionPane.showMessageDialog(null, "ERES EL GANADOR ERES UN DURO " + n);
                contador = 0;
               boton1.setEnabled(false);
                boton2.setEnabled(false);
                boton3.setEnabled(false);
                boton4.setEnabled(false);
                boton5.setEnabled(false);
                boton6.setEnabled(false);
                boton7.setEnabled(false);
                boton8.setEnabled(false);
                boton9.setEnabled(false);
                boton10.setEnabled(false);
                boton11.setEnabled(true);
                boton12.setEnabled(true);
            } else {
                ++contador;
                 JOptionPane.showMessageDialog(null, "Muertes " + contador);
                if (contador == 4) {
                boton1.setEnabled(false);
                boton2.setEnabled(false);
                boton3.setEnabled(false);
                boton4.setEnabled(false);
                boton5.setEnabled(false);
                boton6.setEnabled(false);
                boton7.setEnabled(false);
                boton8.setEnabled(false);
                boton9.setEnabled(false);
                boton10.setEnabled(false);
                boton11.setEnabled(true);
                boton12.setEnabled(true);
                    JOptionPane.showMessageDialog(null, "HAS PERDIDO  " + n);
                    contador = 0;
                }
            }
        }
        if (e.getSource().equals(boton8)) {
            if (numero == 8) {
                boton8.setBackground(Color.blue);
               JOptionPane.showMessageDialog(null, "ERES EL GANADOR ERES UN DURO " + n);
                contador = 0;
                boton1.setEnabled(false);
                boton2.setEnabled(false);
                boton3.setEnabled(false);
                boton4.setEnabled(false);
                boton5.setEnabled(false);
                boton6.setEnabled(false);
                boton7.setEnabled(false);
                boton8.setEnabled(false);
                boton9.setEnabled(false);
                boton10.setEnabled(false);
                boton11.setEnabled(true);
                boton12.setEnabled(true);
            } else {
                ++contador;
                 JOptionPane.showMessageDialog(null, "Muertes " + contador);
                if (contador == 4) {
                   boton1.setEnabled(false);
                boton2.setEnabled(false);
                boton3.setEnabled(false);
                boton4.setEnabled(false);
                boton5.setEnabled(false);
                boton6.setEnabled(false);
                boton7.setEnabled(false);
                boton8.setEnabled(false);
                boton9.setEnabled(false);
                boton10.setEnabled(false);
                boton11.setEnabled(true);
                boton12.setEnabled(true);
                    JOptionPane.showMessageDialog(null, "HAS PERDIDO  " + n);
                    contador = 0;
                }
            }
        }
        if (e.getSource().equals(boton9)) {
            if (numero == 9) {
                boton9.setBackground(Color.blue);
               JOptionPane.showMessageDialog(null, "ERES EL GANADOR ERES UN DURO " + n);
                contador = 0;
               boton1.setEnabled(false);
                boton2.setEnabled(false);
                boton3.setEnabled(false);
                boton4.setEnabled(false);
                boton5.setEnabled(false);
                boton6.setEnabled(false);
                boton7.setEnabled(false);
                boton8.setEnabled(false);
                boton9.setEnabled(false);
                boton10.setEnabled(false);
                boton11.setEnabled(true);
                boton12.setEnabled(true);
            } else {
                ++contador;
                 JOptionPane.showMessageDialog(null, "Muertes " + contador);
                if (contador == 4) {
                boton1.setEnabled(false);
                boton2.setEnabled(false);
                boton3.setEnabled(false);
                boton4.setEnabled(false);
                boton5.setEnabled(false);
                boton6.setEnabled(false);
                boton7.setEnabled(false);
                boton8.setEnabled(false);
                boton9.setEnabled(false);
                boton10.setEnabled(false);
                boton11.setEnabled(true);
                boton12.setEnabled(true);
                    JOptionPane.showMessageDialog(null, "HAS PERDIDO  " + n);
                    contador = 0;
                }
            }
        }
        if (e.getSource().equals(boton10)) {
            if (numero == 10) {
                boton10.setBackground(Color.blue);
                JOptionPane.showMessageDialog(null, "ERES EL GANADOR ERES UN DURO " + n);
                contador = 0;
               boton1.setEnabled(false);
                boton2.setEnabled(false);
                boton3.setEnabled(false);
                boton4.setEnabled(false);
                boton5.setEnabled(false);
                boton6.setEnabled(false);
                boton7.setEnabled(false);
                boton8.setEnabled(false);
                boton9.setEnabled(false);
                boton10.setEnabled(false);
                boton11.setEnabled(true);
                boton12.setEnabled(true);

            } else {
                ++contador;
                JOptionPane.showMessageDialog(null, "Muertes " + contador);
                if (contador == 4) {
                   boton1.setEnabled(false);
                boton2.setEnabled(false);
                boton3.setEnabled(false);
                boton4.setEnabled(false);
                boton5.setEnabled(false);
                boton6.setEnabled(false);
                boton7.setEnabled(false);
                boton8.setEnabled(false);
                boton9.setEnabled(false);
                boton10.setEnabled(false);
                boton11.setEnabled(true);
                boton12.setEnabled(true);
                    JOptionPane.showMessageDialog(null, "HAS PERDIDO  " + n);
                    contador = 0;
                }
            }
        }
        if (e.getSource().equals(boton11)) {
            JOptionPane.showMessageDialog(null, "Estas listo para una nueva partida?");
                boton1.setEnabled(true);
                boton2.setEnabled(true);
                boton3.setEnabled(true);
                boton4.setEnabled(true);
                boton5.setEnabled(true);
                boton6.setEnabled(true);
                boton7.setEnabled(true);
                boton8.setEnabled(true);
                boton9.setEnabled(true);
                boton10.setEnabled(true);
                boton11.setEnabled(false);
                boton12.setEnabled(false);
            boton1.setBackground(Color.white);
            boton2.setBackground(Color.white);
            boton3.setBackground(Color.white);
            boton4.setBackground(Color.white);
            boton5.setBackground(Color.white);
            boton6.setBackground(Color.white);
            boton7.setBackground(Color.white);
            boton8.setBackground(Color.white);
            boton9.setBackground(Color.white);
            boton10.setBackground(Color.white);
        }

        if (e.getSource().equals(boton12)) {
            JOptionPane.showMessageDialog(null, " FIN DEL JUEGO " + n);

            System.exit(0);
        }
    }
}