package entidades;

import java.io.Serializable;

public class Vehiculo implements Serializable{
    private String Placa;
    private String Modelo;
    private String Fecha;
    private Marca objMarca;

    public Vehiculo(String Placa, String Modelo, String Fecha, Marca objMarca) {
        this.Placa = Placa;
        this.Modelo = Modelo;
        this.Fecha = Fecha;
        this.objMarca = objMarca;
    }

    public Vehiculo() {
    }

    public String getPlaca() {
        return Placa;
    }

    public void setPlaca(String Placa) {
        this.Placa = Placa;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String Modelo) {
        this.Modelo = Modelo;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public Marca getObjMarca() {
        return objMarca;
    }

    public void setObjMarca(Marca objMarca) {
        this.objMarca = objMarca;
    }
}
