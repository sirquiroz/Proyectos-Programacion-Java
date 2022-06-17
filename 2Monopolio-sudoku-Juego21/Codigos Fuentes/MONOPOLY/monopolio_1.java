package proyecto;

import java.awt.*;
import javax.swing.*;
import java.applet.Applet;
import java.applet.AudioClip;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.*;

public class monopolio_1 extends Frame implements ActionListener {
   // menu me = new menu();
    JLabel[] lbl = new JLabel[30];
    int x = 10, y = 30;
    JButton btn1, btn2,btnmenu;
    JLabel label1, label2, label3, label4, label5, ficha1, ficha2, dadoAni, f1,f2,titulo1,titulo2;
    Random aleatorio = new Random();
    int dado1, dado2, sumdado = 0, sumdado2 = 0, aux = 10, auxi = 38, dx = 30, dy = 50, dx2 = 30, dy2 = 50, cara = 0, bandera = 0, auxregla5;
    Vector imadado = new Vector();
    AudioClip audio, abrir, avanzar, dado;
    Vector imaventana = new Vector();
    static String jugador1, jugador2;
    boolean band = true;
    int cont1 =0,cont2=0;
    ImageIcon imagen1 = new ImageIcon();
    JPanel panel1, panel2, panel3;
    
    public monopolio_1(){
        ventana();
    }
    public void ventana() {
        //removeAll();
        jugador1 = JOptionPane.showInputDialog(null, "INGRESA EL NUMBRE DE JUGADOR UNO");
        jugador2 = JOptionPane.showInputDialog(null, "INGRESA EL NUMBRE DE JUGADOR DOS");
        audio = Applet.newAudioClip(getClass().getResource("/multimedia/lineas.WAV"));
        abrir = Applet.newAudioClip(getClass().getResource("/multimedia/Setup.WAV"));
        avanzar = Applet.newAudioClip(getClass().getResource("/multimedia/avanzar.WAV"));
        dado = Applet.newAudioClip(getClass().getResource("/multimedia/dado.wav"));
        abrir.play();
        //setVisible(false);
        setSize(1700, 760);
        setTitle("MONOPOLIO");
        setLayout(null);
       // javax.swing.JOptionPane.showMessageDialog(null,"paso...");
        Crear_label();
        // javax.swing.JOptionPane.showMessageDialog(null,"paso...");
        botones_label();
        // javax.swing.JOptionPane.showMessageDialog(null,"paso...");
        Agregar_Label();
       //  javax.swing.JOptionPane.showMessageDialog(null,"paso...");
        setBackground(Color.BLACK);
        setVisible(true);
        // javax.swing.JOptionPane.showMessageDialog(null,"paso...");

        addWindowListener(new CerrarVentana());

    }

    public void Crear_label() {
        llenar_vector_imaventana();
        for (int i = 0; i < 30; i++) {
            lbl[i] = new JLabel();
            lbl[i].setIcon((Icon) imaventana.elementAt(i));
        }


    }

    public void Agregar_Label() {
        for (int i = 0; i < 9; i++) {
            lbl[i].setBounds(x, y, 120, 120);
            x = x + 101;
            add(lbl[i]);

        }

        for (int i = 9; i < 15; i++) {
            lbl[i].setBounds(x, y, 120, 120);
            y = y + 101;
            add(lbl[i]);

        }
        for (int i = 23; i > 14; i--) {
            lbl[i].setBounds(x, y, 120, 120);
            x = x - 101;
            add(lbl[i]);

        }
        for (int i = 29; i > 23; i--) {
            lbl[i].setBounds(x, y, 120, 120);
            y = y - 101;
            add(lbl[i]);

        }
    }

    public void botones_label() {

        panel1 = new JPanel();
        panel1.setBackground(new java.awt.Color(225, 51, 51));
        panel1.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(153, 0, 0)));
        panel1.setLayout(null);
        panel1.setBounds(1020, 50, 250, 200);
        add(panel1);

         panel2 = new JPanel();
        panel2.setBackground(new java.awt.Color(225, 51, 51));
        panel2.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(153, 0, 0)));
        panel2.setLayout(null);
        panel2.setBounds(1020, 300, 250, 200);
        add(panel2);

        titulo2 = new JLabel("" + jugador2);
        titulo2.setFont(new Font("Arial", 3, 24));
        titulo2.setBounds(55, 10, 100, 20);
        panel2.add(titulo2);

        titulo1 = new JLabel(""+jugador1);
        titulo1.setFont(new Font("Arial", 3, 24));
        titulo1.setBounds(55, 10, 100, 20);
        panel1.add(titulo1);

        f2 = new JLabel();
        f2.setIcon(new ImageIcon(getClass().getResource("/cuadros2/p6.png")));
        f2.setBounds(10, 10 , 40, 30);
        f2.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(225, 225,225)));
        panel2.add(f2);

        f1 = new JLabel();
        f1.setIcon(new ImageIcon(getClass().getResource("/cuadros2/p2.png")));
        f1.setBounds(10, 10 , 40, 30);
        f1.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(225, 225,225)));
        panel1.add(f1);

        ficha1 = new JLabel();
        ficha1.setIcon(new ImageIcon(getClass().getResource("/cuadros2/p2.png")));
        ficha1.setBounds(30, 50, 100, 100);
        ficha1.setVisible(true);
        add(ficha1);

        ficha2 = new JLabel();
        ficha2.setIcon(new ImageIcon(getClass().getResource("/cuadros2/p6.png")));
        ficha2.setBounds(30, 50, 70, 50);
        ficha2.setVisible(true);
        add(ficha2);

        btn1 = new JButton(jugador1);
        btn1.setBounds(370, 350, 120, 70);
        btn1.addActionListener(this);

        btn2 = new JButton(jugador2);
        btn2.setBounds(580, 350, 120, 70);
        btn2.addActionListener(this);

        btnmenu = new JButton("NUEVO");
        btnmenu.setBounds(1075, 700, 180, 40);
        btnmenu.addActionListener(this);
//radiodiblu.blobspot.com
        label1 = new JLabel("POSICIÓN: ");
        label1.setOpaque(true);
        label1.setBackground(Color.ORANGE);
        label1.setBounds(40, 80, 150, 30);
        label1.setFont(new Font("Arial", 3, 16));

        label2 = new JLabel("POSICIÓN: ");
        label2.setOpaque(true);
        label2.setBackground(Color.ORANGE);
        label2.setBounds(40, 80, 150, 30);
        label2.setFont(new Font("Arial", 3, 16));

        label3 = new JLabel("ALEATORIO: ");
        label3.setOpaque(true);
        label3.setBackground(Color.ORANGE);
        label3.setBounds(40, 120, 150, 30);
        label3.setFont(new Font("Arial", 3, 16));

        label4 = new JLabel("ALEATORIO: ");
        label4.setOpaque(true);
        label4.setBackground(Color.ORANGE);
        label4.setBounds(40, 120, 150, 30);
        label4.setFont(new Font("Arial", 3, 16));

        label5 = new JLabel();
        label5.setIcon(new ImageIcon(getClass().getResource("/cuadros/a1.png")));
        label5.setBounds(320, 100, 450, 250);



        add(btn1);
        add(btn2);
        add(btnmenu);
        panel1.add(label1);
        panel2.add(label2);
        panel1.add(label3);
        panel2.add(label4);
        add(label5);
            
    }

    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
        if (e.getSource().equals(btn1)) {
            btn1.setEnabled(false);
            dado1 = (aleatorio.nextInt(6)) + 1;
            sumdado = sumdado + dado1;

            label1.setText("POSICIÓN: " + sumdado);
            label3.setText("ALEATORIO: " + dado1);
            bandera = 1;
            dado(dado1, bandera);
            //if((sumdado2 == 2 || sumdado2 == 12 || sumdado2 == 22) && band == true) band=false;
            // else band = true;
            // ficha1(dado1);
            if (sumdado == 5 || sumdado == 18) {
                regla_3_retrocede(1);
            }
            if (sumdado == 12 || sumdado == 21) {
                regla_6_escudo1(1);
            }
            if (sumdado == 9 || sumdado == 24) {
                regla4_regresa_al_inicio(1);
            }
            if (sumdado > 30) {
                regla5_ganador_juego(1);
            }
            if (sumdado == 30) {
                ganador();
            }
            if (sumdado == 27) {
                imagen1 = new ImageIcon(getClass().getResource("/cuadros2/14.gif"));
                JOptionPane.showMessageDialog(null, "Perdiste un turno","REGLA",JOptionPane.PLAIN_MESSAGE,imagen1);
                Regla2_Pierde_Turno(1);
            }
            //btn1.setEnabled(true);
        } else if(e.getSource().equals(btn2)){
            btn2.setEnabled(false);
            dado2 = (aleatorio.nextInt(6)) + 1;
            sumdado2 = sumdado2 + dado2;


            label2.setText("POSICIÓN: " + sumdado2);
            label4.setText("ALEATORIO: " + dado2);
            bandera = 2;
            dado(dado2, bandera);
            if (sumdado2 == 12 || sumdado2 == 21 ) {
                regla_6_escudo1(2);
            }
            if (sumdado2 == 5 || sumdado2 == 18) {
                regla_3_retrocede(2);
            }
            if (sumdado2 == 9 || sumdado2 == 24) {
                regla4_regresa_al_inicio(2);
            }
            if (sumdado2 > 30) {
                regla5_ganador_juego(2);
            }
            if (sumdado2 == 30) {
                ganador();
            }
            if (sumdado2 == 27) {
                imagen1 = new ImageIcon(getClass().getResource("/cuadros2/14.gif"));
                JOptionPane.showMessageDialog(null, "Perdiste un turno","REGLA",JOptionPane.PLAIN_MESSAGE,imagen1);
                Regla2_Pierde_Turno(2);
            }
           
        } else{
           //< menu me = new menu();
            new monopolio_1();
            dispose();
        }


    }

    public void ficha1(final int p) {

        Thread hilo = new Thread() {

            @Override
            public void run() {
                try {

                    avanzar.loop();
                    for (int i = 0; i < p; i++) {
                        if (dx < 831 && dy < 51) {
                            dx = dx + 100;
                            ficha1.setBounds(dx, dy, 50, 50);
                        } else if (dx > 831 && dy < 551) {
                            dy = dy + 100;
                            ficha1.setBounds(dx, dy, 50, 50);
                        } else if (dx > 30 && dy > 649) {
                            dx = dx - 100;
                            ficha1.setBounds(dx, dy, 50, 50);

                        } else {
                            dy = dy - 100;
                            ficha1.setBounds(dx, dy, 50, 50);
                        }


                        sleep(100);

                    }
                    avanzar.stop();
                } catch (Exception e) {
                    System.out.println("" + e);

                }


            }
        };
        hilo.start();
        actualiza_posicion();
        btn2.setEnabled(true);
        btn1.setEnabled(false);
        if (sumdado == 15) {
            Regla1_Gana_Turno(1);
        }
         if (sumdado2 == 27) {
                Regla2_Pierde_Turno(2);}
        //  if((sumdado2 == 2 || sumdado2 == 12 || sumdado2 == 22)&& band == true)Regla2_Pierde_Turno(1);

    }

    public void ficha2(final int p) {

        Thread hilo = new Thread() {

            @Override
            public void run() {
                try {
                    avanzar.loop();
                    for (int i = 0; i < p; i++) {
                        if (dx2 < 831 && dy2 < 51) {
                            dx2 = dx2 + 100;
                            ficha2.setBounds(dx2, dy2, 50, 50);
                        } else if (dx2 > 831 && dy2 < 551) {
                            dy2 = dy2 + 100;
                            ficha2.setBounds(dx2, dy2, 50, 50);
                        } else if (dx2 > 30 && dy2 > 649) {
                            dx2 = dx2 - 100;
                            ficha2.setBounds(dx2, dy2, 50, 50);

                        } else {

                            dy2 = dy2 - 100;
                            ficha2.setBounds(dx2, dy2, 50, 50);
                        }


                        sleep(100);

                    }
                    avanzar.stop();
                } catch (Exception e) {
                    System.out.println("" + e);

                }


            }
        };
        hilo.start();
        actualiza_posicion();
        btn1.setEnabled(true);
        btn2.setEnabled(false);
        if (sumdado2 == 15) {
            Regla1_Gana_Turno(2);
        }
         if (sumdado == 27) {
                Regla2_Pierde_Turno(1);}
        //if((sumdado == 2 || sumdado == 12 || sumdado == 22) && band == true) Regla2_Pierde_Turno(2);

    }

    public void llenar_vector_imaventana() {
        imaventana.add(new ImageIcon(getClass().getResource("/cuadros/go.PNG")));
        imaventana.add(new ImageIcon(getClass().getResource("/cuadros2/1.jpg")));
        imaventana.add(new ImageIcon(getClass().getResource("/cuadros2/1.jpg")));
        imaventana.add(new ImageIcon(getClass().getResource("/cuadros2/2.jpg")));
        imaventana.add(new ImageIcon(getClass().getResource("/cuadros2/2.jpg")));
        imaventana.add(new ImageIcon(getClass().getResource("/cuadros2/m1.png")));
        imaventana.add(new ImageIcon(getClass().getResource("/cuadros2/3.jpg")));
        imaventana.add(new ImageIcon(getClass().getResource("/cuadros2/3.jpg")));
        imaventana.add(new ImageIcon(getClass().getResource("/cuadros2/3.jpg")));
        imaventana.add(new ImageIcon(getClass().getResource("/cuadros2/4.gif")));
        imaventana.add(new ImageIcon(getClass().getResource("/cuadros2/6.jpg")));
        imaventana.add(new ImageIcon(getClass().getResource("/cuadros2/6.jpg")));
        imaventana.add(new ImageIcon(getClass().getResource("/cuadros2/m3.png")));
        imaventana.add(new ImageIcon(getClass().getResource("/cuadros2/6.jpg")));
        imaventana.add(new ImageIcon(getClass().getResource("/cuadros2/6.jpg")));
        imaventana.add(new ImageIcon(getClass().getResource("/cuadros2/7.jpg")));
        imaventana.add(new ImageIcon(getClass().getResource("/cuadros2/7.jpg")));
        imaventana.add(new ImageIcon(getClass().getResource("/cuadros2/m7.png")));
        imaventana.add(new ImageIcon(getClass().getResource("/cuadros2/8.jpg")));
        imaventana.add(new ImageIcon(getClass().getResource("/cuadros2/8.jpg")));
        imaventana.add(new ImageIcon(getClass().getResource("/cuadros2/m4.png")));
        imaventana.add(new ImageIcon(getClass().getResource("/cuadros2/9.jpg")));
        imaventana.add(new ImageIcon(getClass().getResource("/cuadros2/9.jpg")));
        imaventana.add(new ImageIcon(getClass().getResource("/cuadros2/m5.gif")));
        
        imaventana.add(new ImageIcon(getClass().getResource("/cuadros2/10.jpg")));
        imaventana.add(new ImageIcon(getClass().getResource("/cuadros2/10.jpg")));
        imaventana.add(new ImageIcon(getClass().getResource("/cuadros2/14.gif")));
        imaventana.add(new ImageIcon(getClass().getResource("/cuadros2/10.jpg")));
        imaventana.add(new ImageIcon(getClass().getResource("/cuadros2/10.jpg")));
        imaventana.add(new ImageIcon(getClass().getResource("/cuadros2/4.gif")));
        imaventana.add(new ImageIcon(getClass().getResource("/cuadros/24.jpg")));
        imaventana.add(new ImageIcon(getClass().getResource("/cuadros/29.jpg")));
    }

    public void dado(final int x, final int band) {
        imagenDado();
        dadoAni = new JLabel();
        dadoAni.setBounds(180, 400, 155, 180);
        add(dadoAni);


        Thread hilito = new Thread() {

            @Override
            public void run() {

                try {

                    dado.loop();

                    cara = 0;
                    if (x == 1) {
                        cara = 0;
                    } else if (x == 2) {
                        cara = 8;
                    } else if (x == 3) {
                        cara = 6;
                    } else if (x == 4) {
                        cara = 2;
                    } else if (x == 5) {
                        cara = 4;
                    } else if (x == 6) {
                        cara = 12;
                    }
                    for (int i = 0; i <= cara; i++) {

                        dadoAni.setIcon((Icon) imadado.elementAt(i));
                        sleep(70);

                    }

                    dado.stop();
                    for (int i = 0; i < 10; i++) {
                        dadoAni.setIcon((Icon) imadado.elementAt(cara));
                        sleep(100);
                    }

                    for (int i = 0; i < 10; i++) {
                        dadoAni.setIcon(null);
                        sleep(50);
                    }
                    if (band == 1) {
                        ficha1(x);
                    } else {
                        ficha2(x);
                    }
                } catch (Exception e) {
                    System.out.println("" + e);

                }


            }
        };
        hilito.start();

    }

    public void Regla1_Gana_Turno(int ficha) {
        if (ficha == 1) {
             imagen1 = new ImageIcon(getClass().getResource("/cuadros2/m5.gif"));
            JOptionPane.showMessageDialog(null, "EN HORA BUENA HAS GANADO UN TURNO","REGLA",JOptionPane.PLAIN_MESSAGE,imagen1);
            btn1.setEnabled(true);
            btn2.setEnabled(false);
        } else {
             imagen1 = new ImageIcon(getClass().getResource("/cuadros2/m5.gif"));
            JOptionPane.showMessageDialog(null, "EN HORA BUENA HAS GANADO UN TURNO","REGLA",JOptionPane.PLAIN_MESSAGE,imagen1);
            btn1.setEnabled(false);
            btn2.setEnabled(true);
        }
    }

    public void Regla2_Pierde_Turno(int ficha) {
        
        if (ficha == 1) {
          if (sumdado ==27 && cont1 < 2 ){
             btn1.setEnabled(false);
             btn2.setEnabled(true);
             cont1 ++;
           } 

        } else if(ficha == 2) {
          if (sumdado2 ==27 && cont2 < 2 ){
             btn1.setEnabled(true);
             btn2.setEnabled(false);
             cont2 ++;
           } 

    }
    }

    public void regla_3_retrocede(final int ficha) {
        Thread hilo = new Thread() {

            @Override
            public void run() {
                try {

                    if (ficha == 1) {

                        if (sumdado == 5) {
                            sleep(2000);
                            imagen1 = new ImageIcon(getClass().getResource("/cuadros2/m1.png"));
                            JOptionPane.showMessageDialog(null, "JA JA JA......CAISTE EN LA POSICION 5 RETROCEDE TRES ESPACIOS","REGLA",JOptionPane.PLAIN_MESSAGE,imagen1);
                            //ficha1(27);
                            for (int i = 0; i < 3; i++) {
                                if (dx < 831 && dy < 51) {
                                    dx = dx - 100;
                                    ficha1.setBounds(dx, dy, 50, 50);
                                }
                                btn2.setEnabled(true);
                                btn1.setEnabled(false);
                                sleep(50);
                            }
                            sumdado = 2;
                            actualiza_posicion();
                        }
                        if (sumdado == 18) {
                            sleep(2000);
                            imagen1 = new ImageIcon(getClass().getResource("/cuadros2/m4.png"));
                            JOptionPane.showMessageDialog(null, "JA JA JA......CAISTE EN LA POSICION 18 RETROCEDE DOS ESPACIOS","REGLA",JOptionPane.PLAIN_MESSAGE,imagen1);
                            for (int i = 0; i < 2; i++) {
                                if (dx > 30 && dy > 649) {
                                    dx = dx + 100;
                                    ficha1.setBounds(dx, dy, 50, 50);
                                }
                                sleep(50);
                            }
                            btn2.setEnabled(true);
                            btn1.setEnabled(false);
                            sleep(50);
                            sumdado = 16;
                            actualiza_posicion();
                        }

                    }

                    if (ficha == 2) {

                        if (sumdado2 == 5) {
                            sleep(2000);
                            imagen1 = new ImageIcon(getClass().getResource("/cuadros2/m1.png"));
                            JOptionPane.showMessageDialog(null, "JA JA JA......CAISTE EN LA POSICION 5 RETROCEDE TRES ESPACIOS","REGLA",JOptionPane.PLAIN_MESSAGE,imagen1);
                            //ficha1(27);
                            for (int i = 0; i < 3; i++) {
                                if (dx2 < 831 && dy2 < 51) {
                                    dx2 = dx2 - 100;
                                    ficha2.setBounds(dx2, dy2, 50, 50);
                                }

                                sleep(50);
                            }
                            btn2.setEnabled(false);
                            btn1.setEnabled(true);
                            sumdado2 = 2;
                            actualiza_posicion();
                        }
                        if (sumdado2 == 18) {
                            sleep(2000);
                            imagen1 = new ImageIcon(getClass().getResource("/cuadros2/m4.png"));
                            JOptionPane.showMessageDialog(null, "JA JA JA......CAISTE EN LA POSICION 18 RETROCEDE DOS ESPACIOS","REGLA",JOptionPane.PLAIN_MESSAGE,imagen1);
                            for (int i = 0; i < 2; i++) {
                                if (dx2 > 30 && dy2 > 649) {
                                    dx2 = dx2 + 100;
                                    ficha2.setBounds(dx2, dy2, 50, 50);
                                }
                                sleep(50);
                            }

                            btn2.setEnabled(false);
                            btn1.setEnabled(true);
                            sumdado2 = 16;
                            actualiza_posicion();
                        }

                    }

                } catch (Exception e) {
                    System.out.println("" + e);

                }


            }
        };
        hilo.start();
    }

    public void regla4_regresa_al_inicio(final int ficha) {
        Thread hilo = new Thread() {

            @Override
            public void run() {
                try {
                 sleep(2000);
                  imagen1 = new ImageIcon(getClass().getResource("/cuadros2/4.gif"));
        JOptionPane.showMessageDialog(null, "JA JA JA......AVANZA HASTA EL INICIO Y EMPIEZA DESDE 0","REGLA",JOptionPane.PLAIN_MESSAGE,imagen1);
        if (ficha == 1) {
            if (sumdado == 9) {
                ficha1(21);
            }
            if (sumdado == 24) {
                ficha1(6);
            }
            sumdado = 0;
        } else {
            if (sumdado2 == 9) {
                ficha2(21);
            }
            if (sumdado2 == 24) {
                ficha2(6);
            }
            sumdado2 = 0;
        }


        actualiza_posicion();
        } catch (Exception e) {
                    System.out.println("" + e);

                }


            }
        };
        hilo.start();
    }

    public void regla5_ganador_juego(final int ficha) {

        Thread hilo = new Thread() {

            @Override
            public void run() {
                try {
                    if (ficha == 1) {
                        auxregla5 = sumdado - 30;
                        sleep(3000);
                        JOptionPane.showMessageDialog(null, "JA JA JA......TE PASASTES " + auxregla5 + " ESPACIOS REGRESARAS A TU POSICION");
                        for (int i = 0; i < dado1; i++) {
                            if (dx > 30 && dy < 51) {
                                dx = dx - 100;
                                ficha1.setBounds(dx, dy, 50, 50);
                            } else {
                                dy = dy + 100;
                                ficha1.setBounds(dx, dy, 50, 50);
                            }
                            sleep(50);
                        }
                        btn2.setEnabled(true);
                        btn1.setEnabled(false);
                        sumdado = sumdado - dado1;
                        actualiza_posicion();

                    }

                    if (ficha == 2) {
                        auxregla5 = sumdado2 - 30;
                        sleep(3000);
                        JOptionPane.showMessageDialog(null, "JA JA JA......TE PASASTES " + auxregla5 + " ESPACIOS REGRESARAS A TU POSICION");
                        for (int i = 0; i < dado2; i++) {
                            if (dx2 > 30 && dy2 < 51) {
                                dx2 = dx2 - 100;
                                ficha2.setBounds(dx2, dy2, 50, 50);
                            } else {
                                dy2 = dy2 + 100;
                                ficha2.setBounds(dx2, dy2, 50, 50);
                            }
                            sleep(50);
                        }
                        btn1.setEnabled(true);
                        btn2.setEnabled(false);
                        sumdado2 = sumdado2 - dado2;
                        actualiza_posicion();

                    }

                } catch (Exception e) {
                    System.out.println("" + e);

                }


            }
        };
        hilo.start();
    }

    public void regla_6_escudo1(final int ficha) {
        Thread hilo = new Thread() {

            @Override
            public void run() {
                try {
                    sleep(2000);
         imagen1 = new ImageIcon(getClass().getResource("/cuadros2/m7.png"));
        JOptionPane.showMessageDialog(null, "EN HORA BUENA AVANZA 4 POSICIONES","REGLA",JOptionPane.PLAIN_MESSAGE,imagen1);
        if (ficha == 1) {
            ficha1(4);

            sumdado = sumdado + 4;
        } else {
            ficha2(4);

            sumdado2 = sumdado2 + 4;
        }
         } catch (Exception e) {
                    System.out.println("" + e);

                }


            }
        };
        hilo.start();
    }

    public void ganador() {
         imagen1 = new ImageIcon(getClass().getResource("/cuadros2/a1.png"));
        JOptionPane.showMessageDialog(null, "","GANASTE HURRA!!!!!!!!!!!!!!!",JOptionPane.PLAIN_MESSAGE,imagen1);
        new monopolio_1();
        dispose();

    }

    public void actualiza_posicion() {
        label1.setText("POSICIÓN: " + sumdado);
        label3.setText("ALEATORIO: " + dado1);
        label2.setText("POSICIÓN: " + sumdado2);
        label4.setText("ALEATORIO: " + dado2);
    }

    public void imagenDado() {
        imadado.add(new ImageIcon(getClass().getResource("/dado2/d1.png")));
        imadado.add(new ImageIcon(getClass().getResource("/dado2/d2.png")));
        imadado.add(new ImageIcon(getClass().getResource("/dado2/d3.png")));
        imadado.add(new ImageIcon(getClass().getResource("/dado2/d4.png")));
        imadado.add(new ImageIcon(getClass().getResource("/dado2/d5.png")));
        imadado.add(new ImageIcon(getClass().getResource("/dado2/d6.png")));
        imadado.add(new ImageIcon(getClass().getResource("/dado2/d7.png")));
        imadado.add(new ImageIcon(getClass().getResource("/dado2/d8.png")));
        imadado.add(new ImageIcon(getClass().getResource("/dado2/d9.png")));
        imadado.add(new ImageIcon(getClass().getResource("/dado2/d10.png")));
        imadado.add(new ImageIcon(getClass().getResource("/dado2/d11.png")));
        imadado.add(new ImageIcon(getClass().getResource("/dado2/d12.png")));
        imadado.add(new ImageIcon(getClass().getResource("/dado2/d13.png")));



    }

    public void cerrar(){

        System.exit(-1);
    }
    public static void main(String[] args) {
        new monopolio_1();
    }
}
