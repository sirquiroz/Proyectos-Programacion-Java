/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clase8.acciones;

/**
 *
 * @author Dario Espinosa Aldean / D-306 / 5203 
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
public class DeberNumeroCorrecto extends JFrame implements ActionListener {
JButton bt1,bt2,bt3,bt4,bt5,bt6,bt7,bt8,bt9,bt10;
 Random alea=new Random();
static int cont=4;
int win=1;
int n;
 public DeberNumeroCorrecto(){
            setLayout(new GridLayout(2,2));
            bt1=new JButton("[1]"); bt2=new JButton("[2]");bt3=new JButton("[3]");bt4=new JButton("[4]");
            bt5=new JButton("[5]"); bt6=new JButton("[6]");bt7=new JButton("[7]");bt8=new JButton("[8]");
            bt9=new JButton("[9]");bt10=new JButton("[Juego Nuevo]");
            interfaz();
            N_OFF();
            add(bt1); add(bt2);add(bt3);add(bt4);add(bt5);add(bt6);add(bt7);add(bt8);add(bt9);add(bt10);
            bt1.addActionListener(this);bt2.addActionListener(this);bt3.addActionListener(this);bt4.addActionListener(this);
            bt5.addActionListener(this);bt6.addActionListener(this);bt7.addActionListener(this);bt8.addActionListener(this);
            bt9.addActionListener(this);bt10.addActionListener(this);
            //bt4.setBackground(Color.red);
            setTitle("!Seleccione el Numero Correcto!");
            setSize(650,650);
            setLocationRelativeTo(null);
            setVisible(true);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            JOptionPane.showMessageDialog(null, "El JUEGO CONSISTE EN ACERTAR EL NUMERO CORRECTO EN 4 INTENTOS");
                    
    }
    public void N_ON(){
    bt1.setEnabled(true);bt2.setEnabled(true);bt3.setEnabled(true);bt4.setEnabled(true);bt5.setEnabled(true);
    bt6.setEnabled(true);bt7.setEnabled(true);bt8.setEnabled(true);bt9.setEnabled(true);
}
    public void N_OFF(){
    bt1.setEnabled(false);bt2.setEnabled(false);bt3.setEnabled(false);bt4.setEnabled(false);bt5.setEnabled(false);
    bt6.setEnabled(false);bt7.setEnabled(false);bt8.setEnabled(false);bt9.setEnabled(false);
}
    public void interfaz(){
       bt1.setBackground(Color.YELLOW); bt2.setBackground(Color.YELLOW); bt3.setBackground(Color.YELLOW);
       bt4.setBackground(Color.YELLOW);bt5.setBackground(Color.YELLOW);bt6.setBackground(Color.YELLOW);
       bt7.setBackground(Color.YELLOW);bt8.setBackground(Color.YELLOW);bt9.setBackground(Color.YELLOW);
         }
    public static void main(String[] args) {
        new DeberNumeroCorrecto();
    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(bt10)){
         cont=4;
         n=alea.nextInt(9)+1;
         JOptionPane.showMessageDialog(null, " !!!!! PLAY NOW !!!!!!!!");
         JOptionPane.showMessageDialog(null, " -> Numero de Oportunidades [0-4] ");
         N_ON();
        
       }
          bt10.setEnabled(false);
          while(win<=4){
                    if(e.getSource().equals(bt1)){
                    if(n==1){
                    JOptionPane.showMessageDialog(null, "Numero Correcto");
                    JOptionPane.showMessageDialog(null, "Oportunidad N_"+"["+cont+"-4]");
                    N_OFF();
                    bt10.setEnabled(true);
                    break;
              } 
                    else {
                   cont--;
                    JOptionPane.showMessageDialog(null, " -> Sigue Intentando ");
                    JOptionPane.showMessageDialog(null, "Te quedan N_Oportunidad"+"["+cont+"-4]");
                }
               if (cont==0){
            JOptionPane.showMessageDialog(null, " -> [You FAIL-GAME OVER]");
            N_OFF();
            bt10.setEnabled(true);
            break;
      }
   }
              
       if(e.getSource().equals(bt2)){
             //bt2.setBackground(new Color(r,g,b));
         if(n==2) {
                JOptionPane.showMessageDialog(null, "Numero Correcto");
               JOptionPane.showMessageDialog(null, "Oportunidad N_"+"["+cont+"-4]");
               N_OFF();
               bt10.setEnabled(true);
               
                } 
                 else {
             cont--;
               JOptionPane.showMessageDialog(null, " -> Sigue Intentando ");
               JOptionPane.showMessageDialog(null, "Te quedan N_Oportunidad"+"["+cont+"-4]");
           }
         if (cont==0){
            JOptionPane.showMessageDialog(null, " -> [You FAIL-GAME OVER]");
            N_OFF();
            bt10.setEnabled(true);
               break;
      }
                }
      if(e.getSource().equals(bt3)){
      
        if(n==3) {
               JOptionPane.showMessageDialog(null, "Numero Correcto");
              JOptionPane.showMessageDialog(null, "Oportunidad N_"+"["+cont+"-4]");
              N_OFF();
              bt10.setEnabled(true);
              
            } 
                 else {
            cont--;
              JOptionPane.showMessageDialog(null, " -> Sigue Intentando ");
              JOptionPane.showMessageDialog(null, "Te quedan N_Oportunidad"+"["+cont+"-4]");
          }
        if (cont==0){
            JOptionPane.showMessageDialog(null, " -> [You FAIL-GAME OVER]");
            N_OFF();
            bt10.setEnabled(true);
                      break;
      }
        
              }
      if(e.getSource().equals(bt4)){
       
        if(n==4) {
                    JOptionPane.showMessageDialog(null, "Numero Correcto");
              JOptionPane.showMessageDialog(null, "Oportunidad N_"+"["+cont+"-4]");
              N_OFF();
              bt10.setEnabled(true);
              
              } 
                 else {
            cont--;
              JOptionPane.showMessageDialog(null, " -> Sigue Intentando ");
              JOptionPane.showMessageDialog(null, "Te quedan N_Oportunidad"+"["+cont+"-4]");
          }
        if (cont==0){
            JOptionPane.showMessageDialog(null, " -> [You FAIL-GAME OVER]");
            N_OFF();
            bt10.setEnabled(true);
            break;
      }
           }
       
        if(e.getSource().equals(bt5)){
       
        if(n==5) {
                JOptionPane.showMessageDialog(null, "Numero Correcto");
                JOptionPane.showMessageDialog(null, "Oportunidad N_"+"["+cont+"-4]");
                N_OFF();
                bt10.setEnabled(true);
                
           } 
                 else {
            cont--;
                JOptionPane.showMessageDialog(null, " -> Sigue Intentando ");
                JOptionPane.showMessageDialog(null, "Te quedan N_Oportunidad"+"["+cont+"-4]");
            }
        if (cont==0){
            JOptionPane.showMessageDialog(null, " -> [You FAIL-GAME OVER]");
            N_OFF();
            bt10.setEnabled(true);
            break;
      }
         }
        if(e.getSource().equals(bt6)){
                if(n==6) {
                       JOptionPane.showMessageDialog(null, "Numero Correcto");
                JOptionPane.showMessageDialog(null, "Oportunidad N_"+"["+cont+"-4]");
                N_OFF();
                bt10.setEnabled(true);
                
                } 
                 else {
                cont--;
                JOptionPane.showMessageDialog(null, " -> Sigue Intentando ");
                JOptionPane.showMessageDialog(null, "Te quedan N_Oportunidad"+"["+cont+"-4]");
            }
            if (cont==0){
            JOptionPane.showMessageDialog(null, " -> [You FAIL-GAME OVER]");
            N_OFF();
            bt10.setEnabled(true);
            break;
      }
                      }
            if(e.getSource().equals(bt7)){
       
        if(n==7) {
                     JOptionPane.showMessageDialog(null, "Numero Correcto");
                    JOptionPane.showMessageDialog(null, "Oportunidad N_"+"["+cont+"-4]");
                    N_OFF();
                    bt10.setEnabled(true);
                   
             } 
                 else {
            cont--;
                    JOptionPane.showMessageDialog(null, " -> Sigue Intentando ");
                    JOptionPane.showMessageDialog(null, "Te quedan N_Oportunidad"+"["+cont+"-4]");
                }
        if (cont==0){
            JOptionPane.showMessageDialog(null, " -> [You FAIL-GAME OVER]");
            N_OFF();
            bt10.setEnabled(true);
            break;
      }
        
                  }
        if(e.getSource().equals(bt8)){
           if(n==8) {
                 JOptionPane.showMessageDialog(null, "Numero Correcto");
                JOptionPane.showMessageDialog(null, "Oportunidad N_"+"["+cont+"-4]");
                N_OFF();
                bt10.setEnabled(true);
                
                 } 
                 else {
               cont--;
                JOptionPane.showMessageDialog(null, " -> Sigue Intentando ");
                JOptionPane.showMessageDialog(null, "Te quedan N_Oportunidad"+"["+cont+"-4]");
              }
        if (cont==0){
            JOptionPane.showMessageDialog(null, " -> [You FAIL-GAME OVER]");
            N_OFF();
            bt10.setEnabled(true);
            break;
      }
        
        }
        if(e.getSource().equals(bt9)){
          if(n==9) {
                 JOptionPane.showMessageDialog(null, "Numero Correcto");
                JOptionPane.showMessageDialog(null, "Oportunidad N_"+"["+cont+"-4]");
                N_OFF();
                bt10.setEnabled(true);
                  } 
                 else {
            cont--;
                JOptionPane.showMessageDialog(null, " -> Sigue Intentando ");
                JOptionPane.showMessageDialog(null, "Te quedan N_Oportunidad"+"["+cont+"-4]");
            }
        if (cont==0){
            JOptionPane.showMessageDialog(null, " -> [You FAIL-GAME OVER]");
            N_OFF();
            bt10.setEnabled(true);
            break;
      }
             }
        win=win+1;
    }
  }
}
   
 
 
 
