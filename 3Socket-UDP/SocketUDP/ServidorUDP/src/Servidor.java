
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LABORATORIO 5
 */
public class Servidor {
    public static void main(String[] args) {
        try {
            int puerto = 1234;
            DatagramSocket ds = new DatagramSocket(puerto);
            System.out.println("Esperando Conexion..");
            while(true){
                byte[] cadena = new byte[1024];
                DatagramPacket paquete = new DatagramPacket(cadena, cadena.length);
                ds.receive(paquete);
                System.out.println("Nuevo mensaje: ");
                String msn = new String(paquete.getData());
                System.out.println("Mensaje: "+msn);
                System.out.println("IP: "+paquete.getAddress().getHostAddress());
                System.out.println("NAME: "+paquete.getAddress().getHostName());
            }            
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
    }
}
