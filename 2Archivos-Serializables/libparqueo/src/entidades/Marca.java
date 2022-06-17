package entidades;
import java.io.Serializable;
public class Marca implements Serializable{
    private String nombre;
    public Marca() {
    }
    public Marca(String nombre) {
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre.toUpperCase();
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    @Override
    public String toString(){
        return this.getNombre();
    }
}
