/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entidades.Ciudad;
import entidades.Combo;
import entidades.iModelo;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Miguel Quiroz
 */
public class mCiudad implements iModelo {

    public mCiudad() {
        //verifico si la carpeta no existe la creo 
        File folder = new File(System.getProperty("user.dir") + "/db/");
        if (!folder.exists()) {
            folder.mkdirs();
        }
    }

    private final String RUTA = System.getProperty("user.dir") + "/db/ciudades.obj";

    @Override
    public boolean verificaExiste(String[] dato) {
        boolean estado = false;
        try {
            ArrayList<Ciudad> ciudades = leerData();
            for (Ciudad objM : ciudades) {
                if (objM.getNombre().equals(dato[0])) {
                    estado = true;
                    break;
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "verificaExiste: " + e);
        }
        return estado;
    }

    @Override
    public boolean insertar(Object obj) {
        Ciudad objM = (Ciudad) obj;
        try {
            String[] datoV = {objM.getNombre()};
            if (verificaExiste(datoV)) {
                JOptionPane.showMessageDialog(null, "Registro ya existe");
                return false;
            }
            ArrayList<Ciudad> ciudades = leerData();
            ciudades.add(objM);
            guardaData(ciudades);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "insertar: " + e.toString());
            return false;
        }
        return true;
    }

    public boolean guardaData(ArrayList<Ciudad> lista) {
        boolean estado = false;
        try {
            FileOutputStream fos = new FileOutputStream(RUTA);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(lista);
            oos.flush();
            oos.close();
            estado = true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "guardaData: " + e.toString());
        }
        return estado;
    }

    public ArrayList<Ciudad> leerData() {
        ArrayList<Ciudad> ciudades = new ArrayList<>();
        try {
            File fichero = new File(RUTA);
            if (fichero.exists()) {
                FileInputStream fis = new FileInputStream(fichero);
                ObjectInputStream ois = new ObjectInputStream(fis);
                ciudades = (ArrayList<Ciudad>) ois.readObject();
            }
        } catch (IOException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "leerData: " + e);
        }
        return ciudades;
    }

    @Override
    public Object consultar(String dato) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modificar(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void listar(DefaultTableModel listado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void llenaCombo(JComboBox cmb) {
        cmb.removeAllItems();
        ArrayList<Ciudad> ciudades = leerData();
        Collections.sort(ciudades, (Ciudad o1, Ciudad o2) -> o1.getNombre().compareTo(o2.getNombre()));
        /*
        Collections.sort(marcas, new Comparator<Marca>() {
            @Override
            public int compare(Marca o1, Marca o2) {
                return o1.getNombre().compareTo(o2.getNombre());
            }
        });
         */
        //int i=0;
        for (Ciudad objM : ciudades) {
            Combo objC = new Combo(0, objM.getNombre());
            cmb.addItem(objC);
            //i++;
        }
    }

}
