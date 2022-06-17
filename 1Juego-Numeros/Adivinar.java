/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Deberes;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Sistemas Operativos
 */
public class Adivinar extends JFrame implements ActionListener{
    int d = 4;
    Random numero = new Random();
    JButton nuevo;
    static int aleatorio;
    JButton[][] btns = new JButton[3][3];
    public Adivinar(){
        JPanel npanel = new JPanel(new GridLayout(3, 3, 2, 2));
        setTitle("Adivine un número");
        setLayout(new FlowLayout());
        setSize(200, 200);
        setResizable(false);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        int c = 0;
        for (int i = 0; i < btns.length; i++) {
            for (int j = 0; j < btns[i].length; j++) {
                c++;
                btns[i][j] = new JButton("Número: "+c);
                btns[i][j].setVisible(true);
                btns[i][j].setEnabled(false);
                btns[i][j].setText(Integer.toString(c));
                btns[i][j].addActionListener(this);
                npanel.add(btns[i][j]);
            }
        }
        add(npanel);
        nuevo = new JButton("N U E V O");
        nuevo.setVisible(true);
        add(nuevo);
        nuevo.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                aleatorio = numero.nextInt(10)+1;
                for (int i = 0; i < btns.length; i++) {
                    for (int j = 0; j < btns.length; j++) {
                        btns[i][j].setEnabled(true);
                        
                    }
                    
                }
                //nuevo.setEnabled(false);
            }
            
        });
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        //JOptionPane.showMessageDialog(null, Integer.toString(aleatorio)+" "+Integer.toString(d));
        for (int i = 0; i < btns.length; i++) {
            for (int j = 0; j < btns.length; j++) {
                if(e.getSource().equals(btns[i][j])){
                //d--;
                int num = Integer.parseInt(btns[i][j].getText());
                    if(d>0){
                        if(aleatorio == num){
                            deshabilitar(true);
                        }else{
                            d--;
                            JOptionPane.showMessageDialog(null, "Le quedan "+d+" oportunidades");
                        }
                       
                        //nuevo.setEnabled(true);
                    }
                    if(d == 0){
                        deshabilitar(false);
                        d=4;
                    }
                }
                
            }
            
        }
    }
    
    public void deshabilitar(boolean b){
        String txt="Ya no le quedan mas oportunidades";
        if(b){
           txt = "Su número es el correcto!";
        }
        JOptionPane.showMessageDialog(null, txt);
                            for (int k = 0; k < btns.length; k++) {
                                for (int l = 0; l < btns.length; l++) {
                                    btns[k][l].setEnabled(false);
                                }

                            }
    }
    
    public static void main(String[] args) {
        new Adivinar();
    }
}

