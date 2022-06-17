package PROYECTO;

import java.awt.*;
import PROYECTO.CerrarVentana;
import java.applet.Applet;
import java.applet.AudioClip;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.*;



public class Monopoly extends Frame implements ActionListener{
    
	JButton jug1,jug2, trabar;
	JLabel [] tabla = new JLabel[40] ;
	JLabel pos_j1,pos_j2,ale_j1,ale_j2,imag_cen, token1,token2,dadito,regla,regla1,regla2,regla3,regla4,regla5,regla6,regla7,regla8,regla9,regla10,regla11,regla12;
	int x=5, y =15,tokenx1=10,tokeny1=30,tokenx2=30,tokeny2=50;
	int ale_dado1,ale_dado2,conta_j1=0,conta_j2=0,aux =10,auxi=38, mostrar=0, mov=0;
	AudioClip open, next, dado;
	Vector dado_ima = new Vector();
	Random aleatorio = new Random();
	
	int Token1_paso = 0, Token2_paso = 0;

	int aPosicion[][] = {{10,30}, {110,30}, {210,30}, {310,30}, {410,30}, {510,30}, {610,30}, {710,30}, {810,30}, {910,30}, {910,130}, 
							   {910,230}, {910,330}, {910,430}, {910,530}, {910,630}, {810,630}, {710,630}, {610,630}, {510,630}, {410,630}, {310,630},
								{210,630}, {110,630}, {10,630}, {10,530}, {10,430}, {10,330}, {10,230}};

	public void crear_tablero(){
		setSize(1270,728);
	    setTitle("                                                                                                                              ...::: MONOPOLY® :::...");
	    setLayout(null);
	    Crear_tabla();
	    botones();
	    Agregar_tabla();
	    setBackground(Color.BLACK);
	    setVisible(true);
	
	    open = Applet.newAudioClip(getClass().getResource("/imagenes/inicio.wav"));
	    next = Applet.newAudioClip(getClass().getResource("/imagenes/next.wav"));
	    dado = Applet.newAudioClip(getClass().getResource("/imagenes/dado.wav"));
	    open.play();
		addWindowListener(new CerrarVentana());
	}


	public void botones(){
	// Agrego los label para las fichas(token)
	    token1 = new JLabel();
	    token1.setIcon(new ImageIcon(getClass().getResource("/imagenes/p2.png")));
	    token1.setBounds(30, 50, 100, 100);
	    token1.setVisible(true);
	    add(token1);
	
	    token2 = new JLabel();
	    token2.setIcon(new ImageIcon(getClass().getResource("/imagenes/p6.png")));
	    token2.setBounds(30, 50, 70, 50);
	    token2.setVisible(true);
	    add(token2);
	
	
	//Agrego los botones
	
		jug1 = new JButton("::JUGADOR 1::");
		jug1.setBounds(150, 300, 120, 40);
		jug1.addActionListener(this);
		
		jug2 = new JButton("::JUGADOR 2::");
		jug2.setBounds(760, 300, 120, 40);
		jug2.addActionListener(this);
	
	
	//DECLARACION DE LABEL
		pos_j1 = new JLabel("POSICIÓN JUG 1: ");
		pos_j2 = new JLabel("POSICIÓN JUG 2: ");
		ale_j1 = new JLabel("ALEATORIO JUG 1: ");
		ale_j2 = new JLabel("ALEATORIO JUG 2: ");
		regla =new JLabel(" ::: REGLAS ::: ");
		regla1=new JLabel("-EL GANADOR ES EL PRIMERO EN LLEGAR A ");
		regla2=new JLabel("                   LA 29º CASILLA");
		regla3=new JLabel("-SI CAES EN LA 5º CASILLA AVANZA 2 ESP.");
		regla4=new JLabel("-SI CAES EN LA 9º CASILLA RETROCEDE 3 ESP.");
		regla5=new JLabel("-SI CAES EN LA 12º CASILLA AVANZA 1 ESP.");
		regla6=new JLabel("-SI CAES EN LA 15º CASILLA RETROCEDE 2 ESP.");
		regla7=new JLabel("-SI CAES EN LA 20º CASILLA RETROCEDE 10 ESP.");
		regla8=new JLabel("-SI CAES EN LA 24º CASILLA ESTAS A SALVO");
		regla9=new JLabel("-SI CAES EN LA 27º CASILLA REGRESA AL GO");
		regla10=new JLabel("   ::: MUCHA SUERTE :::   ");
		regla11=new JLabel(" JUGADOR 1 >>> FICHA CARRO");
		regla12=new JLabel(" JUGADOR 2 >>> FICHA BARCO");
		imag_cen = new JLabel();
	
		pos_j1.setOpaque(true);
		pos_j1.setBackground(Color.BLACK);
		pos_j1.setForeground(new java.awt.Color(255,255,255));
		pos_j1.setBounds(140, 350, 150, 30);
		pos_j1.setFont(new Font("Arial", 1, 12));
		
		pos_j2.setOpaque(true);
		pos_j2.setBackground(Color.BLACK);
		pos_j2.setForeground(new java.awt.Color(255,255,255));
		pos_j2.setBounds(750, 350, 150, 30);
		pos_j2.setFont(new Font("Arial", 1, 12));
		
		ale_j1.setOpaque(true);
		ale_j1.setBackground(Color.BLACK);
		ale_j1.setForeground(new java.awt.Color(255,255,255));
		ale_j1.setBounds(140, 380, 110, 30);
		ale_j1.setFont(new Font("Arial", 1, 12));
		
		ale_j2.setOpaque(true);
		ale_j2.setBackground(Color.BLACK);
		ale_j2.setForeground(new java.awt.Color(255,255,255));
		ale_j2.setBounds(750, 380, 110, 30);
		ale_j2.setFont(new Font("Arial", 1, 12));
		
		regla.setOpaque(true);
		regla.setBackground(Color.BLACK);
		regla.setForeground(new java.awt.Color(255,255,255));
		regla.setBounds(1025, 30, 200, 30);
		regla.setFont(new Font("Arial", 1, 18));
		
		regla1.setOpaque(true);
		regla1.setBackground(Color.BLACK);
		regla1.setForeground(new java.awt.Color(255,255,255));
		regla1.setBounds(1010, 70, 200, 30);
		regla1.setFont(new Font("Arial", 1, 8));
		
		regla2.setOpaque(true);
		regla2.setBackground(Color.BLACK);
		regla2.setForeground(new java.awt.Color(255,255,255));
		regla2.setBounds(1010, 90, 250, 30);
		regla2.setFont(new Font("Arial", 1, 8));
		
		regla3.setOpaque(true);
		regla3.setBackground(Color.BLACK);
		regla3.setForeground(new java.awt.Color(255,255,255));
		regla3.setBounds(1010, 110, 200, 30);
		regla3.setFont(new Font("Arial", 1, 8));
		
		regla4.setOpaque(true);
		regla4.setBackground(Color.BLACK);
		regla4.setForeground(new java.awt.Color(255,255,255));
		regla4.setBounds(1010, 130, 200, 30);
		regla4.setFont(new Font("Arial", 1, 8));
		
		regla5.setOpaque(true);
		regla5.setBackground(Color.BLACK);
		regla5.setForeground(new java.awt.Color(255,255,255));
		regla5.setBounds(1010, 150, 200, 30);
		regla5.setFont(new Font("Arial", 1, 8));
		
		regla6.setOpaque(true);
		regla6.setBackground(Color.BLACK);
		regla6.setForeground(new java.awt.Color(255,255,255));
		regla6.setBounds(1010, 170, 200, 30);
		regla6.setFont(new Font("Arial", 1, 8));
		
		regla7.setOpaque(true);
		regla7.setBackground(Color.BLACK);
		regla7.setForeground(new java.awt.Color(255,255,255));
		regla7.setBounds(1010, 190, 200, 30);
		regla7.setFont(new Font("Arial", 1, 8));
		
		regla8.setOpaque(true);
		regla8.setBackground(Color.BLACK);
		regla8.setForeground(new java.awt.Color(255,255,255));
		regla8.setBounds(1010, 210, 200, 30);
		regla8.setFont(new Font("Arial", 1, 8));
		
		regla9.setOpaque(true);
		regla9.setBackground(Color.BLACK);
		regla9.setForeground(new java.awt.Color(255,255,255));
		regla9.setBounds(1010, 230, 200, 30);
		regla9.setFont(new Font("Arial", 1, 8));
		
		regla10.setOpaque(true);
		regla10.setBackground(Color.BLACK);
		regla10.setForeground(new java.awt.Color(255,255,255));
		regla10.setBounds(1010, 250, 200, 30);
		regla10.setFont(new Font("Arial", 1, 14));
		
		regla11.setOpaque(true);
		regla11.setBackground(Color.BLACK);
		regla11.setForeground(new java.awt.Color(255,255,255));
		regla11.setBounds(1010, 350, 250, 30);
		regla11.setFont(new Font("Arial", 1, 14));
		
		regla12.setOpaque(true);
		regla12.setBackground(Color.BLACK);
		regla12.setForeground(new java.awt.Color(255,255,255));
		regla12.setBounds(1010, 370, 250, 30);
		regla12.setFont(new Font("Arial", 1, 14));

		
		imag_cen = new JLabel();
		imag_cen.setIcon(new ImageIcon(getClass().getResource("/imagenes/a1.png")));
		imag_cen.setBounds(290, 100, 448, 336);
		
		
		
		add(jug1);
		add(jug2);
		add(pos_j1);
		add(pos_j2);
		add(ale_j1);
		add(ale_j2);
		add(regla);
		add(regla1);
		add(regla2);
		add(regla3);
		add(regla4);
		add(regla5);
		add(regla6);
		add(regla7);
		add(regla8);
		add(regla9);
		add(regla10);
		add(regla11);
		add(regla12);
		add(imag_cen);
	}



	public void Crear_tabla(){
		for (int i = 0; i <tabla.length; i++) {
      	tabla[i]= new JLabel();
      }
	}


	public void Agregar_tabla(){
            
	   for (int i = 0; i < 9; i++){

         tabla[0].setIcon(new ImageIcon(getClass().getResource("/imagenes/go.PNG")));
         tabla[1].setIcon(new ImageIcon(getClass().getResource("/imagenes/1.jpg")));
         tabla[2].setIcon(new ImageIcon(getClass().getResource("/imagenes/1.jpg")));
         tabla[3].setIcon(new ImageIcon(getClass().getResource("/imagenes/4.jpg")));
         tabla[4].setIcon(new ImageIcon(getClass().getResource("/imagenes/4.jpg")));
         tabla[5].setIcon(new ImageIcon(getClass().getResource("/imagenes/m3.png")));
         tabla[6].setIcon(new ImageIcon(getClass().getResource("/imagenes/6.jpg")));
         tabla[7].setIcon(new ImageIcon(getClass().getResource("/imagenes/6.jpg")));
         tabla[8].setIcon(new ImageIcon(getClass().getResource("/imagenes/6.jpg")));
         tabla[i].setBounds(x, y, 120, 120);
			
			x= x+100;
         add(tabla[i]);
		}


      for (int i = 9; i < 15; i++){
      	tabla[9].setIcon(new ImageIcon(getClass().getResource("/imagenes/14.gif")));
         tabla[10].setIcon(new ImageIcon(getClass().getResource("/imagenes/3.jpg")));
         tabla[11].setIcon(new ImageIcon(getClass().getResource("/imagenes/3.jpg")));
         tabla[12].setIcon(new ImageIcon(getClass().getResource("/imagenes/m6.png")));
         tabla[13].setIcon(new ImageIcon(getClass().getResource("/imagenes/3.jpg")));
         tabla[14].setIcon(new ImageIcon(getClass().getResource("/imagenes/3.jpg")));

         tabla[i].setBounds(x, y, 120, 120);
         y = y + 100;
         add(tabla[i]);
      }
             
             
      for (int i = 23; i > 14; i--){
         tabla[23].setIcon(new ImageIcon(getClass().getResource("/imagenes/m9.png")));
         tabla[22].setIcon(new ImageIcon(getClass().getResource("/imagenes/7.jpg")));
         tabla[21].setIcon(new ImageIcon(getClass().getResource("/imagenes/7.jpg")));
         tabla[20].setIcon(new ImageIcon(getClass().getResource("/imagenes/2.jpg")));
         tabla[19].setIcon(new ImageIcon(getClass().getResource("/imagenes/2.jpg")));
         tabla[18].setIcon(new ImageIcon(getClass().getResource("/imagenes/10.gif")));
         tabla[17].setIcon(new ImageIcon(getClass().getResource("/imagenes/2.jpg")));
         tabla[16].setIcon(new ImageIcon(getClass().getResource("/imagenes/8.jpg")));
         tabla[15].setIcon(new ImageIcon(getClass().getResource("/imagenes/8.jpg")));
          
         tabla[i].setBounds(x, y, 120, 120);
         x = x-100;
         add(tabla[i]);
      }
             
             
      for (int i = 29; i > 23; i--){
         tabla[24].setIcon(new ImageIcon(getClass().getResource("/imagenes/m7.png")));
         tabla[25].setIcon(new ImageIcon(getClass().getResource("/imagenes/5.jpg")));
         tabla[26].setIcon(new ImageIcon(getClass().getResource("/imagenes/m10.png")));
         tabla[27].setIcon(new ImageIcon(getClass().getResource("/imagenes/5.jpg")));
         tabla[28].setIcon(new ImageIcon(getClass().getResource("/imagenes/5.jpg")));
         tabla[29].setIcon(new ImageIcon(getClass().getResource("/imagenes/9.gif")));
   
         tabla[i].setBounds(x, y, 120, 120);
         y = y-100;
         add(tabla[i]);
      }
	}


public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(jug1)){

            ale_dado1 = (aleatorio.nextInt(6))+1;
            conta_j1 = conta_j1 + ale_dado1;
            pos_j1.setText("CONTADOR: "+conta_j1);
            ale_j1.setText("AVANZAR: "+ale_dado1);
            mov = 1;
            dado(ale_dado1,mov);
            
        }else {

            ale_dado2 = (aleatorio.nextInt(6))+1;
            conta_j2 = conta_j2 + ale_dado2;
            pos_j2.setText("CONTADOR: "+conta_j2);
            ale_j2.setText("AVANZAR: "+ale_dado2);
             mov = 2;
            dado(ale_dado2, mov);
        }
        
      }


	public void token1(final int t){
		
		Thread hilo_jug1 = new Thread() {
		
		   public void run() {

				int ini = 0, lim = 0;

				try {
					next.loop();
		
					if (t >= 0) { 
						ini = 0; 
						lim = t;
					} else {
						ini = t;
						lim = 0;
					}
		         
		         for (int i = ini; i < lim; i++) {
						
						Token1_paso = Token1_paso + (t < 0?-1:1) ;
						
						if (Token1_paso >= aPosicion.length) {
							//int a = JOptionPane.showConfirmDialog(null, "DESEA ABANDONAR MONOPOLY ?");
							JOptionPane.showMessageDialog(null, "GANASTE JUGADOR # 1", "Game Over", 1);
         				System.exit(-1);
						}
									
						
						tokenx1 = aPosicion[Token1_paso][0];
						tokeny1 = aPosicion[Token1_paso][1];
								                        	
		         	System.out.println("T1 --> " + Token1_paso + " | " + tokenx1 + "," + tokeny1);
					   token1.setBounds(tokenx1,tokeny1, 50, 50);
  		            sleep(100);
		     		}
		     		
		     		next.stop();
		      }
		      catch (Exception e) {
		      	System.out.println("" + e);
		    	}
		    	
		    	if (Token1_paso == 5)  token1(2);
		    	if (Token1_paso == 9)  token1(-3);
		    	if (Token1_paso == 12) token1(1);
		    	if (Token1_paso == 15) token1(-2);
		    	if (Token1_paso == 20) token1(-10);
		    	
		    	if (Token1_paso == 27) {
		    		Token1_paso = 0;
					tokenx1 = 10;
					tokeny1 = 30;
					token1.setBounds(tokenx1,tokeny1, 50, 50);
		    	} ;


		    	
			}
	   };
	        
	   hilo_jug1.start();
	   jug2.setEnabled(true);
		jug1.setEnabled(false);
	}


	public void token2(final int t){
		
		Thread hilo_jug2 = new Thread() {
		
		   public void run() {

				int ini = 0, lim = 0;

				try {
					next.loop();
		
					if (t >= 0) { 
						ini = 0; 
						lim = t;
					} else {
						ini = t;
						lim = 0;
					}
		         
		         for (int i = ini; i < lim; i++) {
						
						Token2_paso = Token2_paso + (t < 0?-1:1) ;
						
						if (Token2_paso >= aPosicion.length) {
							JOptionPane.showMessageDialog(null, "GANASTE JUGADOR # 2", "Game Over", 1);
         				System.exit(-1);
						}
									
						tokenx2 = aPosicion[Token2_paso][0];
						tokeny2 = aPosicion[Token2_paso][1];
								                        	
		         	System.out.println("T2 --> " + Token2_paso + " | " + tokenx2 + "," + tokeny2);
					   token2.setBounds(tokenx2,tokeny2, 50, 50);
  		            sleep(100);
		     		}
		     		
		     		next.stop();
		      }
		      catch (Exception e) {
		      	System.out.println("" + e);
		    	}
		    	
		    	if (Token2_paso == 5) token2(2);
		    	if (Token2_paso == 9) token2(-3);
		    	if (Token2_paso == 12) token2(1);
		    	if (Token2_paso == 15) token2(-2);
		    	if (Token2_paso == 20) token2(-10);
		    	
		    	if (Token2_paso == 27) {
		    		Token2_paso = 0;
					tokenx2 = 10;
					tokeny2 = 30;
					token2.setBounds(tokenx2,tokeny2, 50, 50);
		    	} ;


		    	
			}
	   };
	        
	   hilo_jug2.start();
	   jug1.setEnabled(true);
		jug2.setEnabled(false);
	}





	public void token1_bak(final int t, final int iFactor){
		
		Token1_paso = Token1_paso + (t * iFactor);
		
		Thread hilo_jug1 = new Thread() {
		
		   public void run() {
				try {
					next.loop();
		         
		         for (int i = 0; i < t; i++) {
		                        	
		         	System.out.println("T1 --> " + tokenx1 + "," + tokeny1);
		                        	
			          if (tokenx1 < 831 && tokeny1 < 51){
			          	  // izquierda - derecha
			          	  System.out.println("T1:Izquierda-Derecha");	
			          	  tokenx1 = tokenx1 + 100;
			          	  
			          } else if(tokenx1 > 831 && tokeny1 < 551 ){
			          	  // arriba - abajo
			          	  System.out.println("T1:Arriba-Abajo");
			              tokeny1= tokeny1 + 100;
			              
			          } else if (tokenx1 > 51 && tokeny1 >= 630){
			          	  // derecha - izquierda
			          	  System.out.println("T1:Derecha-Izquierda");
			              tokenx1 = tokenx1 - 100;
			              
			          } else if (tokenx1 <= 51 && tokeny1 >= 51) {
			          	  //abajo arriba
			          	  System.out.println("T1:Abajo-Arriba");
							  tokeny1 = tokeny1 - 100;
							  
			          } else{
			              tokenx1=tokenx1 - 100;
			              token1.setBounds(tokenx1,tokeny1, 50, 50);
			              System.out.println("T1:Default");
			          }
			                                      
						 token1.setBounds(tokenx1,tokeny1, 50, 50);
			          sleep(100);
		     		}
		     		
		     		next.stop();
		      }
		      catch (Exception e) {
		      	System.out.println("" + e);
		    	}
		    	
		    	//if (Token1_paso == 5) token1(2,1);
		    	//if (Token1_paso == 9) token1(5,-1);
		    	
		    	
			}
	   };
	        
	   hilo_jug1.start();
	   jug2.setEnabled(true);
		jug1.setEnabled(false);
	}


public void dado (final int a, final int band){
    imagenDado();
    dadito = new JLabel();
    dadito.setBounds(470, 430, 146, 200);
    add(dadito);


    Thread hilo_dado = new Thread(){

    public void run(){

        try {

        dado.loop();

            mostrar =0;
                 if(a == 1){ mostrar = 0;}
            else if(a == 2){ mostrar = 1;}
            else if(a == 3){ mostrar = 2;}
            else if(a == 4){ mostrar = 3;}
            else if(a == 5){ mostrar = 4;}
            else if(a == 6){ mostrar = 5;}
            
            for (int i = 0; i <= mostrar; i++) {
                dadito.setIcon((Icon) dado_ima.elementAt(i));
                sleep(100);
            }

           dado.stop();
             for (int i = 0; i < 10; i++) {
               dadito.setIcon((Icon) dado_ima.elementAt(mostrar));
               sleep(100);}

            for (int i = 0; i < 10; i++) {
               dadito.setIcon(null);
               sleep(50);}
               if (band == 1){
                   token1(a);}
                   else {
                   token2(a);
               }
        }catch(Exception e){
            System.out.println("" + e);
        }
    }
};
hilo_dado.start();
}






public void imagenDado(){
    dado_ima.add(new ImageIcon(getClass().getResource("/imagenes/da1.jpg")));
    dado_ima.add(new ImageIcon(getClass().getResource("/imagenes/da2.jpg")));
    dado_ima.add(new ImageIcon(getClass().getResource("/imagenes/da3.jpg")));
    dado_ima.add(new ImageIcon(getClass().getResource("/imagenes/da4.jpg")));
    dado_ima.add(new ImageIcon(getClass().getResource("/imagenes/da5.jpg")));
    dado_ima.add(new ImageIcon(getClass().getResource("/imagenes/da6.jpg")));
    dado_ima.add(new ImageIcon(getClass().getResource("/imagenes/da7.jpg")));
    dado_ima.add(new ImageIcon(getClass().getResource("/imagenes/da8.jpg")));
    dado_ima.add(new ImageIcon(getClass().getResource("/imagenes/da9.jpg")));
    dado_ima.add(new ImageIcon(getClass().getResource("/imagenes/da10.jpg")));
    dado_ima.add(new ImageIcon(getClass().getResource("/imagenes/da11.jpg")));
    dado_ima.add(new ImageIcon(getClass().getResource("/imagenes/da12.jpg")));
    dado_ima.add(new ImageIcon(getClass().getResource("/imagenes/da13.jpg")));



}
public static void main(String[] args) {
        Monopoly obj = new Monopoly();
        obj.crear_tablero();
    }
}