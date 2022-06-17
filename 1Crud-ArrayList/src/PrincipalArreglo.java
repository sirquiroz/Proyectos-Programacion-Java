
/**
 * Este ejemplo usa arrayList para trabajar
 *
 * @author Miguel Quiroz
 * @version 1.5
 */
import java.util.*;

public class PrincipalArreglo {

    int puntero = 0;
    int tamanio = 100;
    //Vector listado = new Vector();
    Persona[] listado = new Persona[tamanio];
    Scanner teclado = new Scanner(System.in);

    /**
     * metodo principal
     *
     * @param args
     */
    public static void main(String[] args) {
        PrincipalArreglo obj = new PrincipalArreglo();
        obj.MenuPrincipal();
    }

    /**
     * metodo que me permite limpiar la pantalla
     */
    public void clear() {
        for (int i = 0; i < 100; i++) {
            System.out.println("");
        }
    }

    /**
     * este metodo me permite llenar 3 datos por defecto
     */
    public void llenarDatos() {
        listado[puntero] = new Persona();
        listado[puntero].Cedula = "0123456789";
        listado[puntero].Nombre = "Miguel Quiroz";
        listado[puntero].Edad = "32";
        puntero++;

        listado[puntero] = new Persona();
        listado[puntero].Cedula = "0987654321";
        listado[puntero].Nombre = "Pedro Picapiedra";
        listado[puntero].Edad = "23";
        puntero++;

        listado[puntero] = new Persona();
        listado[puntero].Cedula = "1234567890";
        listado[puntero].Nombre = "Pepito Pote";
        listado[puntero].Edad = "18";
        puntero++;
    }

    /**
     * Presenta el menu principal con las opciones del sistema
     */
    public void MenuPrincipal() {
        llenarDatos();
        int op;
        do {
            clear();
            System.out.println("\t\t\t\t\t\t@SYSTEM LES DA UNA CORDIAL BIENVENIDA");
            System.out.println("@SYSTEM Es un Sistema Disenado Para EL Control de Ingreso De Participantes. Usando Arreglos de Objetos");
            System.out.println("");
            System.out.println("\t\t\t\tHI@SYSTEM MENU");
            System.out.println("\t\t\t1.- Registrar Participante");
            System.out.println("\t\t\t2.- Actualizar Participantes ");
            System.out.println("\t\t\t3.- Eliminar Participante ");
            System.out.println("\t\t\t4.- Listado de Participantes ");
            System.out.println("\t\t\t5.- Buscar Participante ");
            System.out.println("\t\t\t0.-Salir");
            op = teclado.nextInt();
            switch (op) {
                case 1:
                    Registrar();
                    break;
                case 2:
                    Actualizar();
                    break;
                case 3:
                    Eliminar();
                    break;
                case 4:
                    Listado();
                    break;
                case 5:
                    Consultar();
                    break;
            }
        } while (op != 0);
        System.out.println("GRACIAS POR USAR EL @SYSTEM");

    }

    /**
     * permite registrar a una persona
     */
    public void Registrar() {
        clear();
        listado[puntero] = new Persona();
        System.out.println("Ingrese Nueva Cedula");
        listado[puntero].Cedula = teclado.next();
        System.out.println("Ingrese el Nombre");
        listado[puntero].Nombre = teclado.next();
        System.out.println("Ingrese la Edad");
        listado[puntero].Edad = teclado.next();
        puntero++;
    }

    /**
     * permite consultar los datos de una persona
     */
    public void Consultar() {
        clear();
        System.out.println("Ingrese la cedula");
        String cedula = teclado.next();
        boolean encontrado = false;
        for (int i = 0; i < puntero; i++) {
            Persona obj = listado[i];
            if (obj.Cedula.equals(cedula)) {
                System.out.println("Participante encontrado:");
                System.out.println("Cedula: " + obj.Cedula);
                System.out.println("Nombre: " + obj.Nombre);
                System.out.println("Edad: " + obj.Edad);
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Participante no existe");
        }
        System.out.println("Presione 0 para continuar");
        teclado.next();
    }

    /**
     * Actualiza los datos de una participante
     */
    public void Actualizar() {
        clear();
        boolean encontrado = false;
        System.out.println("Ingrese la cedula");
        String cedula = teclado.next();
        for (int i = 0; i < puntero; i++) {
            Persona obj = listado[i];
            if (obj.Cedula.equals(cedula)) {
                System.out.println("Ingrese el Nuevo Nombre");
                listado[i].Nombre = teclado.next();
                System.out.println("Ingrese la nueva Edad");
                listado[i].Edad = teclado.next();
                encontrado = true;
                System.out.println("Participante Modificado con exito");
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Participante no existe");
        }
        System.out.println("Presione 0 para continuar");
        teclado.next();
    }

    /**
     * Elimina los datos de un participante
     */
    public void Eliminar() {
        clear();
        boolean encontrado = false;
        System.out.println("Ingrese la cedula");
        String cedula = teclado.next();
        for (int i = 0; i < puntero; i++) {
            Persona obj = listado[i];
            if (obj.Cedula.equals(cedula)) {
                //listado.remove(obj);//elimino el antiguo participante
                encontrado = true;
                listado[i] = null;
                System.out.println("Participante Eliminado con exito");
                quitarNullArreglo();
                puntero--;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Participante no existe");
        }
        System.out.println("Presione 0 para continuar");
        teclado.next();
    }
    public void quitarNullArreglo(){
        for (int i = 0; i < puntero; i++) {
            if (listado[i] == null) {
                listado[i] = listado[i+1];
                listado[i+1]= null;
            }
        }
    }
    /**
     * lista a todos los participantes registrados
     */
    public void Listado() {
        clear();
        System.out.println("-------------------------------------------------------------");
        System.out.println(padRight("|Cedula", 15) + padRight("|Nombre", 35) + padRight("|Edad", 10) + "|");
        System.out.println("-------------------------------------------------------------");
        System.out.println("-------------------------------------------------------------");
        for (int i = 0; i < puntero; i++) {
            Persona obj = listado[i];
            System.out.println(padRight("|" + obj.Cedula, 15) + padRight("|" + obj.Nombre, 35) + padRight("|" + obj.Edad, 10) + "|");
            System.out.println("-------------------------------------------------------------");
        }
        System.out.println("Presione 0 para continuar");
        teclado.next();

    }

    /**
     * metodo que me permite relleanr de espacios n hacia la derecha
     *
     * @param s el string a mostrar
     * @param n numero maximo de caracteres
     * @return el nuevo String
     */
    public static String padRight(String s, int n) {
        return String.format("%1$-" + n + "s", s);
    }

    /**
     * metodo que me permite relleanr de espacios n hacia la izquierda
     *
     * @param s el string a mostrar
     * @param n numero maximo de caracteres
     * @return el nuevo String
     */
    public static String padRightNum(int s, int n) {
        return String.format("%1$-" + n + "s", s);
    }

}
