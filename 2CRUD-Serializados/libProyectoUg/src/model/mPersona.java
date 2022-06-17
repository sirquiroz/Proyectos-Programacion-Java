/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entidades.Combo;
import entidades.Persona;
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
public class mPersona implements iModelo {

    private final String RUTA = System.getProperty("user.dir") + "/db/personas.obj";

    public mPersona() {
        //verifico si la carpeta no existe la creo
        File folder = new File(System.getProperty("user.dir") + "/db/");
        if (!folder.exists()) {
            folder.mkdirs();
        }
    }

    public boolean guardaData(ArrayList<Persona> lista) {
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

    public ArrayList<Persona> leerData() {
        ArrayList<Persona> personas = new ArrayList<>();
        try {
            File fichero = new File(RUTA);
            if (fichero.exists()) {
                FileInputStream fis = new FileInputStream(fichero);
                ObjectInputStream ois = new ObjectInputStream(fis);
                personas = (ArrayList<Persona>) ois.readObject();
            }
        } catch (IOException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "leerData: " + e);
        }
        return personas;
    }

    @Override
    public boolean verificaExiste(String[] dato) {
        boolean estado = false;
        try {
            ArrayList<Persona> personas = leerData();
            for (Persona objM : personas) {
                if (objM.getCedula().equals(dato[0])) {
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
        Persona objM = (Persona) obj;
        try {
            String[] datoV = {objM.getCedula()};
            if (verificaExiste(datoV)) {
                JOptionPane.showMessageDialog(null, "Registro ya existe");
                return false;
            }
            ArrayList<Persona> personas = leerData();
            personas.add(objM);
            guardaData(personas);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Insertar: " + e.toString());
            return false;
        }
        return true;
    }

    @Override
    public Object consultar(String dato) {
        ArrayList<Persona> personas = leerData();
        for (Persona objV : personas) {
            if (objV.getCedula().equals(dato)) {
                return objV;
            }
        }
        return null;
    }

    @Override
    public boolean modificar(Object obj) {
        boolean estado = false;
        try {
            Persona objNew = (Persona) obj;
            ArrayList<Persona> personas = leerData();
            for (Persona objP : personas) {
                if (objP.getCedula().equals(objNew.getCedula())) {
                    personas.remove(objP);//elimino anterior
                    personas.add(objNew);//agrego nuevo                    
                    estado = guardaData(personas);
                    break;
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "modificar: " + e);
        }
        return estado;
    }

    @Override
    public boolean eliminar(Object obj) {
        boolean estado = false;
        try {
            Persona objNew = (Persona) obj;
            ArrayList<Persona> personas = leerData();
            for (Persona objP : personas) {
                if (objP.getCedula().equals(objNew.getCedula())) {
                    personas.remove(objP);//elimino anterior
                    estado = guardaData(personas);
                    break;
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "eliminar: " + e);
        }
        return estado;
    }

    @Override
    public void listar(DefaultTableModel listado) {
        listado.getDataVector().clear();
        try {
            ArrayList<Persona> personas = leerData();
            for (Persona objP : personas) {
                Object[] row = new Object[5];
                row[0] = objP.getCedula();
                row[1] = objP.getNombre();
                row[2] = objP.getApellido();
                row[3] = objP.getEdad();
                row[4] = objP.getObjCiudad().getNombre();
                listado.addRow(row);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "listar: " + e);
        }
    }

    @Override
    public void llenaCombo(JComboBox cmb) {
        cmb.removeAllItems();
        ArrayList<Persona> personas = leerData();
        Collections.sort(personas, (Persona o1, Persona o2) -> o1.getApellido().compareTo(o2.getApellido()));
        for (Persona objP : personas) {
            Combo objC = new Combo(0, objP.getApellido() + " " + objP.getNombre());
            cmb.addItem(objC);
            //i++;
        }
    }

}
