package model;

import entidades.Combo;
import entidades.Marca;
import entidades.Modelo;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class mMarca implements Modelo {

    private final String RUTA = System.getProperty("user.dir") + "/db/marcas.obj";

    @Override
    public boolean verificaExiste(String[] dato) {
        boolean estado = false;
        try {
            ArrayList<Marca> marcas = leerData();
            for (Marca objM : marcas) {
                if (objM.getNombre().equals(dato[0])) {
                    estado = true;
                    break;
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return estado;
    }

    @Override
    public boolean insertar(Object obj) {
        Marca objM = (Marca) obj;
        try {
            String[] datoV = {objM.getNombre()};
            if (verificaExiste(datoV)) {
                JOptionPane.showMessageDialog(null, "Registro ya existe");
                return false;
            }
            ArrayList<Marca> marcas = leerData();
            marcas.add(objM);
            FileOutputStream fos = new FileOutputStream(RUTA);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(marcas);
            oos.flush();
            oos.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }
        return true;
    }

    public ArrayList<Marca> leerData() {
        ArrayList<Marca> marcas = new ArrayList<>();
        try {
            File fichero = new File(RUTA);
            if (fichero.exists()) {
                FileInputStream fis = new FileInputStream(fichero);
                ObjectInputStream ois = new ObjectInputStream(fis);
                marcas = (ArrayList<Marca>) ois.readObject();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return marcas;
    }

    @Override
    public Object consultar(String dato) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modificar(Object objOld, Object objNew) {
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
        ArrayList<Marca> marcas = leerData();
        Collections.sort(marcas, (Marca o1, Marca o2) -> o1.getNombre().compareTo(o2.getNombre()));
        /*
		
		Collections.sort(marcas, new Comparator<Marca>() {
            @Override
            public int compare(Marca o1, Marca o2) {
                return o1.getNombre().compareTo(o2.getNombre());
            }
        });
		*/
		//int i=0;
        for (Marca objM : marcas) {
            Combo objC = new Combo(0, objM.getNombre());
            cmb.addItem(objC);
            //i++;
        }
    }

}
