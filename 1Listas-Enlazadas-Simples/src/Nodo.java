/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Clase que define los elementos que debe tener un Nodo de la lista.
 *
 * @author sir_quiroz
 */
public class Nodo<Persona> {

    // Variable en la cual se va a guardar el valor.
    private Persona dato;
    // Variable para enlazar los nodos.
    private Nodo<Persona> siguiente;

    /**
     * Constructor que inicializamos el valor de las variables.
     */
    /**
     * Constructor por defecto
     */
    public Nodo() {
        siguiente = null;
    }

    /**
     * Le pasamos un dato al nodo
     *
     * @param p
     */
    public Nodo(Persona p) {
        siguiente = null;
        dato = p;
    }

    /**
     * Le pasamos un dato y su siguiente nodo al nodo
     *
     * @param t Dato a insertar
     * @param siguiente Su sisguiente nodo
     */
    public Nodo(Persona t, Nodo<Persona> siguiente) {
        this.siguiente = siguiente;
        dato = t;
    }

    // Métodos get y set para los atributos.
    public Persona getDato() {
        return dato;
    }

    public void setDato(Persona dato) {
        this.dato = dato;
    }

    public Nodo<Persona> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo<Persona> siguiente) {
        this.siguiente = siguiente;
    }

}
