/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author sir_quiroz
 */
public class Persona {

    private String Nombre;
    private int Edad;

    public String getNombre() {
        return Nombre.toUpperCase();
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int Edad) {
        this.Edad = Edad;
    }

    public Persona() {
    }

    public Persona(String Nombre, int Edad) {
        this.Nombre = Nombre;
        this.Edad = Edad;
    }

    @Override
    public String toString() {
        return this.Nombre + " : " + this.Edad;
    }
}
