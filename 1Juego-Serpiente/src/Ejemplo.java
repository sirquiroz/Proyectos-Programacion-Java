
import java.util.Random;
import java.util.Scanner;

public class Ejemplo {

    public static void main(String[] args) {
        int j1 = 0;
        int j2 = 0;
        int dado;
        int meta = 40;
        Random aleatorio = new Random();
        Scanner leer = new Scanner(System.in);
        do {
            //lanzar dados J1
            System.out.println("Enter lanzar dado J1");
            leer.nextLine();
            dado = aleatorio.nextInt(6) + 1;
            System.out.println("J1: " + dado);
            j1 = j1 + dado;
            if (j1 > meta) {
                j1 = meta - (j1 - meta);
            }
            if (j1 == meta) {
                break;//termina el juego
            }
            System.out.println("J1 está en posición: " + j1);
            //lanzar dados J2
            System.out.println("Enter lanzar dado J2");
            leer.nextLine();
            dado = aleatorio.nextInt(6) + 1;
            System.out.println("J2: " + dado);
            j2 = j2 + dado;
            if (j2 > meta) {
                j2 = meta - (j2 - meta);
            }
            if (j2 == meta) {
                break;//termina el juego
            }
            System.out.println("J2 está en la posición: " + j2);
            //Regla 1: 11 - 4
            //Regla 2: 20 + 3
            //Regla 3: 38 va a 0
            switch (j1) {
                case 11:
                    System.out.println("J1 retrocede 4 espacios");
                    j1 = j1 - 4;
                    break;
                case 20:
                    j1 = j1+3;
                    System.out.println("J1 avanza 3 espacios");
                    break;
                case 38:
                    j1 = 0;
                    System.out.println("J1 va a inicio");
                    break;
            }
            switch (j2) {
                case 11:
                    System.out.println("J2 retrocede 4 espacios");
                    j2 = j2 - 4;
                    break;
                case 20:
                    j2 = j2+3;
                    System.out.println("J2 avanza 3 espacios");
                    break;
                case 38:
                    j2 = 0;
                    System.out.println("J2 va a inicio");
                    break;
            }
        } while (j1 < meta && j2 < meta);
        if (j1 > j2) {
            System.out.println("J1 Gana");
        } else if (j2 > j1) {
            System.out.println("J2 Gana");
        } else {
            System.out.println("Empate");
        }
    }

}
