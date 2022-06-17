
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LABORATORIO 5
 */
public class Cliente {
    public static void main(String[] args) {
        try {
            String ip ="172.18.125.200";
            //String ip ="127.0.0.1";
            int puerto = 1234;
            InetAddress destino = InetAddress.getByName(ip);
            DatagramSocket ds = new DatagramSocket();
            String msn = "Hola desde Cliente";
            byte[] cadena = msn.getBytes();
            DatagramPacket paquete = new DatagramPacket(cadena, cadena.length, destino,  puerto);
            ds.send(paquete);
            ds.close();
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
    }
}
