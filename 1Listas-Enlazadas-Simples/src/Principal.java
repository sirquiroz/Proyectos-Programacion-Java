
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author sir_quiroz
 */
public class Principal {

    public static void main(String arg[]) {
        new Principal().menu();
    }
    Scanner leer = new Scanner(System.in);
    ListaEnlazada<Persona> lista = new ListaEnlazada<>();//crear la lista

    /*
    Operaciones básicas:
    agregar (valor): agrega el valor al final de la lista.
    insertar (referencia, valor): inserta el valor después del valor de referencia en la lista. 
    remover (referencia): elimina el nodo con el valor que coincida con la referencia. 
    editar (referencia): actualiza el valor de nodo con el valor que coincida con la referencia.
    esVacia (): retorna true si la lista está vacía, false en caso contrario. 
    buscar (valor): retorna la true si el elemento existe en la lista, false caso contrario.
    eliminar(): elimina la lista
    listar (): imprime en pantalla los elementos de la lista.*/
    public void menu() {
        int op = 0;
        do {
            System.out.println("Ejemplo Lista Simple Enlazada");
            System.out.println("1.- Insertar Primero");
            System.out.println("2.- Insertar Ultimo");
            System.out.println("3.- Insertar en N Posicion");
            System.out.println("4.- Remover");
            System.out.println("5.- Editar");
            System.out.println("6.- esVacia");
            System.out.println("7.- Buscar");
            System.out.println("8.- Vaciar");
            System.out.println("9.- Listar");
            System.out.println("10.- Tamaño de la lista");
            System.out.println("0.- Exit");
            op = leer.nextInt();
            switch (op) {
                case 1:
                    InsertaUltimo();
                    break;
                case 2:
                    insertaPrimero();
                    break;
                case 3:
                    insertaPosicion();
                    break;
                case 4:
                    eliminar();
                    break;
                case 5:
                    editar();
                    break;
                case 6:
                    estaVacia();
                    break;
                case 7:
                    buscar();
                    break;
                case 8:
                    EliminarPrimerElemento();
                    break;
                case 9:
                    listarElementos();
                    break;
                case 10:
                    tamanioLista();
                    break;

            }//switch
        } while (op != 0);
    }//menu

    void InsertaUltimo() {
        System.out.println("Insertar al Ultimo de la Lista");
        Persona obj = new Persona();
        System.out.println("Ingrese el Nombre: ");
        obj.setNombre(leer.next());
        System.out.println("Ingrese la Edad: ");
        obj.setEdad(leer.nextInt());
        lista.insertarUltimo(obj);
        listarElementos();
    }

    private void insertaPrimero() {
        System.out.println("Insertar al Inicio de la Lista");
        Persona obj = new Persona();
        System.out.println("Ingrese el Nombre: ");
        obj.setNombre(leer.next());
        System.out.println("Ingrese la Edad: ");
        obj.setEdad(leer.nextInt());
        lista.insertarPrimero(obj);
        listarElementos();
    }

    private void insertaPosicion() {
        System.out.println("Ingrese la posicion: ");
        int pos = leer.nextInt();
        System.out.println("Insertar en la posucion " + pos + " de la Lista");
        Persona obj = new Persona();
        System.out.println("Ingrese el Nombre: ");
        obj.setNombre(leer.next());
        System.out.println("Ingrese la Edad: ");
        obj.setEdad(leer.nextInt());
        lista.introducirDato(pos, obj);
        listarElementos();
    }

    void listarElementos() {
        lista.mostrar();
    }

    private void eliminar() {
        System.out.println("Ingrese la posicion: ");
        int pos = leer.nextInt();

        lista.borraPosicion(pos);
        listarElementos();
    }

    
    private void tamanioLista() {
        System.out.println("Existen " + lista.cuantosElementos() + " elementos: ");
        listarElementos();

    }

    private void editar() {
        System.out.println("Ingrese la posicion: ");
        int pos = leer.nextInt();
        System.out.println("Modificar en la posicion " + pos + " de la Lista");
        Persona obj = new Persona();
        System.out.println("Ingrese el Nombre: ");
        obj.setNombre(leer.next());
        System.out.println("Ingrese la Edad: ");
        obj.setEdad(leer.nextInt());
        lista.modificarDato(pos, obj);
        listarElementos();
        
    }

    private void estaVacia() {
        if(lista.estaVacia()){
            System.out.println("La lista esta vacia");
        }else{
            System.out.println("La lista tiene al menos un dato");
            tamanioLista();
        }
    }

    private void EliminarPrimerElemento() {
        Persona obj = lista.devolverYBorrarPrimero();
        System.out.println("Dato Eliminado: ");
        System.out.println("Nombre: "+obj.getNombre());
        System.out.println("Edad: "+obj.getEdad());
    }

    private void buscar() {
        System.out.println("Ingrese la posicion: ");
        int pos = leer.nextInt();
        System.out.println("El elemento en la posicion " + pos + " de la Lista");
        Persona obj = lista.devolverDato(pos);
        System.out.println("Nombre: "+obj.getNombre());
        System.out.println("Edad: "+obj.getEdad());
    }
    /*
    //Creo la lista enlazada de numeros
    //Puede ser de String, double, Objetos, etc.        
    System.out.println("Insercion de numeros del 0 al 9 en forma de lista");
    for(int i=0;i<10;i++){
        lista.insertarUltimo(i);
    }        
    //Mostramos la lista
    lista.mostrar();
    System.out.println("Numero de elementos: " + lista.cuantosElementos());
    ystem.out.println("Eliminación del dato que esta en la posicion 3");
    lista.borraPosicion(3); //Elimina el el dato 3
    System.out.println("Numero de elementos: " + lista.cuantosElementos());
    System.out.println("Insercion del dato 2 en la posicion 5");
    lista.introducirDato(5, 2);
    System.out.println("Numero de elementos: " + lista.cuantosElementos());
    System.out.println("Modificamos el dato de la posicion 5 por un 3");
    lista.modificarDato(5, 3);
    System.out.println("Numero de elementos: " + lista.cuantosElementos());
    System.out.println("Inserto en la posicion 0");
    lista.introducirDato(0, 10);
    lista.mostrar();
    System.out.println("Inserto en la ultima posicion");
    //Equivalente a insertarUltimo
    lista.introducirDato(lista.cuantosElementos(), 11);
    System.out.println("Posicion del dato 5: "+lista.indexOf(5));
    System.out.println("Posicion del dato 5 desde la posicion 7: "+lista.indexOf(5, 7));
    System.out.println("¿Existe el dato 10 en la lista? "+lista.datoExistente(10));
    System.out.println("¿Existe el dato 20 en la lista? "+lista.datoExistente(20));
    */
}
