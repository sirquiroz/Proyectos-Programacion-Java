
import java.util.Random;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LABORATORIO 5
 */
public class Ejemplo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        Random aleatorio = new Random();
        int t = 11;
        String[][] m = new String[t][t];
        //llena la matriz
        for (int i = 0; i < t; i++) {
            for (int j = 0; j < t; j++) {
                m[i][j] = "x";
            }
        }
        int c = Math.round(t/2); //ubicacion columna del borracho
        int f = Math.round(t/2); //ubicacion fila del borracho
        m[f][c] = "F";//Pinto el faro
        c++;
        m[f][c] = "B";//Pinto el Borracho  
        //pinto la matriz
        for (int i = 0; i < t; i++) {
            for (int j = 0; j < t; j++) {
                System.out.print( m[i][j]+"\t");
            }
            System.out.println("");
        }
        System.out.println("Ingrese el numero de pasos..");
        int pasos = lectura.nextInt();
        for (int p = 0; p < pasos; p++) {
            lectura.nextLine();
            int o = aleatorio.nextInt(4);
            m[f][c] = "-"; //pinto x donde estaba el borracho
            switch(o){
                case 0: f--; break;
                case 1: f++; break;
                case 2: c--; break;
                case 3: c++; break;
            }
            // pinto al borracho
            m[f][c] = "B";
            System.out.println("Paso "+p);
            //dibujo la matriz
            for (int i = 0; i < t; i++) {
                for (int j = 0; j < t; j++) {
                    System.out.print( m[i][j]+"\t");
                }
                System.out.println("");
            }
        }//for p
    }
    
}
