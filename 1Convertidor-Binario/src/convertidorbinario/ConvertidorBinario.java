package convertidorbinario;

import java.util.Scanner;

public class ConvertidorBinario {

    public static void main(String[] args) {
        Scanner scan =  new Scanner(System.in);
        int valor = 0;
        System.out.println("Ingrese el Número: ");
        valor = scan.nextInt();
        
        int division = valor;
        int residuo = 0;
        String resultado = "";
        do{
            residuo = division % 2;
            division = division / 2;
            resultado = resultado + residuo;
            System.out.println("Residuo = " + residuo);            
            System.out.println("Division = " + division);
        }while(division > 1);
        System.out.println(resultado);
    }
}
