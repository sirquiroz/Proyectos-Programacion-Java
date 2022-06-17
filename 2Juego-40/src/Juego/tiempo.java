
package Juego;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class tiempo{

   InputStreamReader isr = new InputStreamReader(System.in);
   BufferedReader br = new BufferedReader(isr);
   public static void main(String args[]) throws IOException
   {
      long milisegundosactuales,milisegundos;
      int tiempo = 0;
      milisegundosactuales = System.currentTimeMillis();//Variable para obtener el tiempo al abrir el programa
      boolean evento = false;
      while(true)
      {
         evento = false;//Booleano para no tener que repetir código y poder maracar eventos relacionados con el tiempo
         milisegundos = System.currentTimeMillis();//Método para obtener el tiempo actual
         if (milisegundosactuales == milisegundos)
         {   
            milisegundosactuales = milisegundos + 1000;//1000 milisegundos = 1 segundo
            tiempo++;
            System.out.println(tiempo);
            evento = true;
            System.out.println(evento);
         }
         else if((milisegundosactuales + 1000) < milisegundos)//Metodo para evitar que se detenga el contador
            milisegundosactuales = System.currentTimeMillis();
      }   
   }
}


