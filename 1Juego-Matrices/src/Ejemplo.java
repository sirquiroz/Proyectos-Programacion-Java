
import java.util.Scanner;

public class Ejemplo {

    public static void main(String[] args) {
        Ejemplo obj = new Ejemplo();
        obj.menu();
    }
    int tamano_f = 20;
    int tamano_c = 20;
    int[][] matriz = new int[tamano_f][tamano_c];
    int p_f = tamano_f / 2;
    int p_c = tamano_c / 2;
    Scanner leer = new Scanner(System.in);

    public void menu() {
        int op = -1;
        do {
            System.out.println("1.- Subir");
            System.out.println("2.- Bajar");
            System.out.println("3.- Izq");
            System.out.println("4.- Der");
            op = leer.nextInt();
            if (op > 0 && op < 5) {
                mover(op);
            }
        } while (op != 0);
        System.out.println("Gracias por utilizar el Sistema");
    }//menu

    public void mover(int m) {
        switch (m) {
            case 1:
                if (p_f > 0) {
                    matriz[p_f][p_c] = 0;
                    p_f--;
                    matriz[p_f][p_c] = 99;
                } else {
                    System.out.println("No puede subir");
                }
                break;
            case 2:
                if (p_f < tamano_f-1) {
                    matriz[p_f][p_c] = 0;
                    p_f++;
                    matriz[p_f][p_c] = 99;
                } else {
                    System.out.println("No puede bajar");
                }
                break;
            case 3:
                if (p_c > 0) {
                    matriz[p_f][p_c] = 0;
                    p_c--;
                    matriz[p_f][p_c] = 99;
                } else {
                    System.out.println("No puede mover a la IZQ");
                }
                break;
            case 4:
                if (p_c < tamano_c-1) {
                    matriz[p_f][p_c] = 0;
                    p_c++;
                    matriz[p_f][p_c] = 99;
                } else {
                    System.out.println("No puede mover a la Derecha");
                }
                break;
        }
        for (int i = 0; i < tamano_f; i++) {
            for (int j = 0; j < tamano_c; j++) {
                System.out.print("\t" + matriz[i][j]);
            }//forj           
            System.out.println("");
        }//fori
    }//mover 
}
