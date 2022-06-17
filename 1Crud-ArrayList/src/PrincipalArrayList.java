
/**
 * Este ejemplo usa arrayList para trabajar
 *
 * @author Miguel Quiroz
 * @version 1.5
 */
import java.util.*;

public class PrincipalArrayList {

    //Vector listado = new Vector();
    ArrayList<Persona> listado = new ArrayList<>();
    Scanner teclado = new Scanner(System.in);

    /**
     * metodo principal
     *
     * @param args
     */
    public static void main(String[] args) {
        PrincipalArrayList obj = new PrincipalArrayList();
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
        Persona obj = new Persona();
        obj.Cedula = "0123456789";
        obj.Nombre = "Miguel Quiroz";
        obj.Edad = "32";
        listado.add(obj);
        Persona obj2 = new Persona();
        obj2.Cedula = "0987654321";
        obj2.Nombre = "Pedro Picapiedra";
        obj2.Edad = "23";
        listado.add(obj2);
        Persona obj3 = new Persona();
        obj3.Cedula = "1234567890";
        obj3.Nombre = "apito Pote";
        obj3.Edad = "18";
        listado.add(obj3);
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
            System.out.println("@SYSTEM Es un Sistema Disenado Para EL Control de Ingreso De Participantes. Usando ArrayList");
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
        Persona obj = new Persona();
        System.out.println("Ingrese Nueva Cedula");
        obj.Cedula = teclado.next();
        System.out.println("Ingrese el Nombre");
        obj.Nombre = teclado.next();
        System.out.println("Ingrese la Edad");
        obj.Edad = teclado.next();
        listado.add(obj);
    }

    /**
     * permite consultar los datos de una persona
     */
    public void Consultar() {
        clear();
        System.out.println("Ingrese la cedula");
        String cedula = teclado.next();
        boolean encontrado = false;
        for (Persona obj : listado) {
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
        for (Persona obj : listado) {
            if (obj.Cedula.equals(cedula)) {
                Persona obj_new = new Persona();
                obj_new.Cedula = cedula;
                System.out.println("Ingrese el Nuevo Nombre");
                obj_new.Nombre = teclado.next();
                System.out.println("Ingrese la nueva Edad");
                obj_new.Edad = teclado.next();
                listado.remove(obj);//elimino el antiguo participante
                listado.add(obj_new);//agrego al nuevo participante
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
        for (Persona obj : listado) {
            if (obj.Cedula.equals(cedula)) {
                listado.remove(obj);//elimino el antiguo participante
                encontrado = true;
                System.out.println("Participante Eliminado con exito");
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
     * lista a todos los participantes registrados
     */
    public void Listado() {
        clear();
        System.out.println("-------------------------------------------------------------");
        System.out.println(padRight("|Cedula", 15) + padRight("|Nombre", 35) + padRight("|Edad", 10) + "|");
        System.out.println("-------------------------------------------------------------");
        System.out.println("-------------------------------------------------------------");
        for (Persona obj : listado) {
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
