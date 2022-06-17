/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;

/**
 *
 * @author Miguel Quiroz
 */
public class Ciudad implements Serializable{
    private String Nombre;
 
    public Ciudad(String Nombre) {
        this.Nombre = Nombre;
    }

    public Ciudad() {
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
}
