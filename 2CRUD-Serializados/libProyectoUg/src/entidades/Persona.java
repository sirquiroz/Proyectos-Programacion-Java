/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author Miguel Quiroz
 */

import java.io.Serializable;

public class Persona implements Serializable{
    private String Cedula;
    private String Nombre;
    private String Apellido;
    private int Edad;
    private Ciudad objCiudad;

    public Persona(String Cedula, String Nombre, String Apellido, int Edad, Ciudad objCiudad) {
        this.Cedula = Cedula;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Edad = Edad;
        this.objCiudad = objCiudad;
    }

    public Persona() {
    }

    public String getCedula() {
        return Cedula;
    }

    public void setCedula(String Cedula) {
        this.Cedula = Cedula;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int Edad) {
        this.Edad = Edad;
    }

    public Ciudad getObjCiudad() {
        return objCiudad;
    }

    public void setObjCiudad(Ciudad objCiudad) {
        this.objCiudad = objCiudad;
    }

    
}
