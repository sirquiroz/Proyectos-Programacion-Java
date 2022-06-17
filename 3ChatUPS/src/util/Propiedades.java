/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Miguel Quiroz
 */
public class Propiedades {
    private Properties p;
    /**
     * cargo el archivo de propiedades
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public Propiedades() {
        
        try {
            p = new Properties();
            p.load(new FileReader("misPropiedades.properties"));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    /**
     * leer una propiedad
     * @param name
     * @return 
     */
    public String getP(String name) {
        return p.getProperty(name, null);
    }
    /**
     * escribir una propiedad
     * @param name
     * @param value
     * @throws IOException 
     */
    public void setP(String name, String value) {
        
        try {
            p.setProperty(name, value);
            p.store(new FileWriter("misPropiedades.properties"), "un comentario");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
}
