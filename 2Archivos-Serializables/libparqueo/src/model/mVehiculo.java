/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entidades.Marca;
import entidades.Modelo;
import entidades.Vehiculo;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LABORATORIO 10
 */
public class mVehiculo implements Modelo {

    private final String RUTA = System.getProperty("user.dir") + "/db/vehiculos.obj";

    @Override
    public boolean verificaExiste(String[] dato) {
        boolean estado = false;
        try {
            ArrayList<Vehiculo> vehiculos = leerData();
            for (Vehiculo objM : vehiculos) {
                if (objM.getPlaca().equals(dato[0]) && objM.getFecha().equals(dato[1])) {
                    estado = true;
                    break;
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return estado;
    }

    public ArrayList<Vehiculo> leerData() {
        ArrayList<Vehiculo> vehiculos = new ArrayList<>();
        try {
            File fichero = new File(RUTA);
            if (fichero.exists()) {
                FileInputStream fis = new FileInputStream(fichero);
                ObjectInputStream ois = new ObjectInputStream(fis);
                vehiculos = (ArrayList<Vehiculo>) ois.readObject();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return vehiculos;
    }

    @Override
    public boolean insertar(Object obj) {
        Vehiculo objM = (Vehiculo) obj;
        try {
            String[] datoV = {objM.getPlaca(), objM.getFecha()};
            if (verificaExiste(datoV)) {
                JOptionPane.showMessageDialog(null, "Registro ya existe");
                return false;
            }
            ArrayList<Vehiculo> vehiculos = leerData();
            vehiculos.add(objM);
            FileOutputStream fos = new FileOutputStream(RUTA);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(vehiculos);
            oos.flush();
            oos.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "sss" + e.toString());
            return false;
        }
        return true;

    }

    @Override
    public Object consultar(String dato) {
        ArrayList<Vehiculo> vehiculos = leerData();
        for (Vehiculo objV : vehiculos) {
            if (objV.getPlaca().equals(dato)) {
                return objV;
            }
        }
        return null;
    }

    @Override
    public boolean modificar(Object objOld, Object objNew) {
        boolean estado = false;
        try {
            Vehiculo objO = (Vehiculo) objOld;
            Vehiculo objN = (Vehiculo) objNew;
            ArrayList<Vehiculo> vehiculos = leerData();
            for (Vehiculo objV : vehiculos) {
                if (objV.getPlaca().equals(objO.getPlaca())) {
                    vehiculos.remove(objV);
                    vehiculos.add(objN);
                    FileOutputStream fos = new FileOutputStream(RUTA);
                    ObjectOutputStream oos = new ObjectOutputStream(fos);
                    oos.writeObject(vehiculos);
                    oos.flush();
                    oos.close();
                    estado = true;
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return estado;
    }

    @Override
    public boolean eliminar(Object obj) {
        boolean estado = false;
        try {
            Vehiculo objN = (Vehiculo) obj;
            ArrayList<Vehiculo> vehiculos = leerData();
            for (Vehiculo objV : vehiculos) {
                if (objV.getPlaca().equals(objN.getPlaca())) {
                    vehiculos.remove(objV);
                    FileOutputStream fos = new FileOutputStream(RUTA);
                    ObjectOutputStream oos = new ObjectOutputStream(fos);
                    oos.writeObject(vehiculos);
                    oos.flush();
                    oos.close();
                    estado = true;
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return estado;
    }

    @Override
    public void listar(DefaultTableModel listado) {
        listado.getDataVector().clear();
        try {
            ArrayList<Vehiculo> vehiculos = leerData();
            for (Vehiculo objV : vehiculos) {
                Object[] obj = new Object[4];
                obj[0] = objV.getFecha();
                obj[1] = objV.getPlaca();
                obj[2] = objV.getObjMarca().getNombre();
                obj[3] = objV.getModelo(); 
                listado.addRow(obj);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    @Override
    public void llenaCombo(JComboBox combo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
