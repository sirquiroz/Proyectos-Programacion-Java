/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Deberes;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;



/**
 *
 * @author Laboratorio 5 PC01
 */
public class Menu_Memoria extends JFrame implements ActionListener{
    
    
    public Menu_Memoria(){
        
        setLayout(null);
         setTitle("Bienvenido");
        JPanelFondo Background = new JPanelFondo();
        JButton play_btn = new JButton("JUGAR!");
        JLabel label = new JLabel ("JUEGO DE MEMORIA V1") ;
        label.setBounds(108, 50, 200, 50);
        JLabel label2 = new JLabel ("Desarrollado por: Bryan Macías ");
        label2.setBounds(113, 90, 250, 50);
        JLabel label3 = new JLabel ("Vanessa Machado");
        label3.setBounds(140, 110, 250, 50);
        play_btn.setBounds(150,150,100,30);
        
        label.setFont(new java.awt.Font("Arial", 3, 15));
      
        label.setForeground(new java.awt.Color(75, 0, 130));
        java.net.URL url = getClass().getResource("/Background/star.png");
        java.awt.Image imagen = getToolkit().getImage(url);
        setIconImage(imagen);
       
    
       
        
        this.add(label);
        this.add(label2);
        this.add(label3);
        this.add(play_btn);
        
        setSize(300, 300);
        this.add(Background,BorderLayout.CENTER);
      
        setResizable(false);
       
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
       
     ;
       
        
        play_btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               
                new Memoria2();
             dispose();
            }
        });
       
        
      //  add(panel);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    public static void main(String[] args) {
//        try {
//            UIManager.setLookAndFeel(new SeaGlassLookAndFeel());
//        }
//        catch (Exception e ){
//            JOptionPane.showMessageDialog(null, "Exception in lAF "+e);
//        }
        new Menu_Memoria();
    }
}
