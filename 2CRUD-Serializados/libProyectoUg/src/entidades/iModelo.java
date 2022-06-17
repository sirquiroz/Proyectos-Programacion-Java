/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Miguel Quiroz
 */
public interface iModelo {
     public boolean verificaExiste(String[] dato);
    public boolean insertar(Object obj);
    public Object consultar(String dato);
    public boolean modificar(Object obj);
    public boolean eliminar(Object obj);
    public void listar(DefaultTableModel listado);
    public void llenaCombo(JComboBox cmb);
}
