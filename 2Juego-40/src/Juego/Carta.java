/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Juego;

import java.awt.Point;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Jesús
 */
public class Carta extends JLabel{
    public int num;
    public int x;
    public int y;
    public int tamx;
    public int tamy;
    public int fromx;
    public int fromy;
    public ImageIcon Opuesto=new ImageIcon("img/CARTAS.png");
    public ImageIcon Frente;
    
    public Carta(int num,int x,int y,int tamx,int tamy){
        this.num=num;
        this.x=x;
        this.y=y;
        this.tamx=tamx;
        this.tamy=tamy;
        this.fromx=0;
        this.fromy=0;
    }
    public void Ocultar(){
        this.setIcon(this.Opuesto);
    }
    public void Revelar(){
        this.setIcon(this.Frente);
    }
    public boolean Contiene(Point p){
        return p.x>=this.getX()&&p.x<=(this.getX()+this.getWidth())&&p.y>=this.getY()&&p.y<=(this.getY()+this.getHeight());
    }
    public static String IntToString(int i){
        if(i==1){
            return "A";            
        }
        if(i==2){
            return "2";            
        }
        if(i==3){
            return "3";            
        }
        if(i==4){
            return "4";            
        }
        if(i==5){
            return "5";            
        }
        if(i==6){
            return "6";            
        }
        if(i==7){
            return "7";            
        }
        if(i==8){
            return "J";            
        }
        if(i==9){
            return "Q";            
        }
        if(i==10){
            return "K";            
        }
        return "no se encontro la carta";
        
    }
    public static int StringToNum(String s){
        if(s.equalsIgnoreCase("A")){
            return 1;
        }
        if(s.equalsIgnoreCase("2")){
            return 2;
        }
        if(s.equalsIgnoreCase("3")){
            return 3;
        }
        if(s.equalsIgnoreCase("4")){
            return 4;
        }
        if(s.equalsIgnoreCase("5")){
            return 5;
        }
        if(s.equalsIgnoreCase("6")){
            return 6;
        }
        if(s.equalsIgnoreCase("7")){
            return 7;
        }
        if(s.equalsIgnoreCase("J")){
            return 8;
        }
        if(s.equalsIgnoreCase("Q")){
            return 9;
        }
        if(s.equalsIgnoreCase("K")){
            return 10;
        }
        return 0; 
    }
}
