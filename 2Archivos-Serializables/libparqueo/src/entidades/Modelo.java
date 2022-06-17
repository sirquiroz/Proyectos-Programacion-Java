package entidades;

//import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

public interface Modelo {
    public boolean verificaExiste(String[] dato);
    public boolean insertar(Object obj);
    //public ArrayList<Object> leerData();
    public Object consultar(String dato);
    public boolean modificar(Object objOld, Object objNew);
    public boolean eliminar(Object obj);
    public void listar(DefaultTableModel listado);
    public void llenaCombo(JComboBox combo);
}