package clientesockets;

import java.net.*;
import java.io.*;

public class EmisorUDP {

    public static void main(String args[]) {
        // Los argumentos dan:
        // el nombre de la máquina receptora y 2 mensajes
        try {
            // Crea su socket
            DatagramSocket elSocket = new DatagramSocket();

            // Construye la dirección del socket del receptor
            InetAddress maquina = InetAddress.getByName("localhost");
            int puerto = 1234;
            String txt1 = "sddddas";

            // Crea el primer mensaje
            byte[] cadena = txt1.getBytes();
            DatagramPacket mensaje = new DatagramPacket(cadena,
                    cadena.length, maquina, puerto);

            // Envía el primer mensaje
            elSocket.send(mensaje);
            String txt = "sas";
            // Crea el segundo mensaje
            cadena = txt.getBytes();
            mensaje.setData(cadena);
            mensaje.setLength(txt.length());

            // Envía el segundo mensaje
            elSocket.send(mensaje);

            // Cierra su socket
            elSocket.close();
        } catch (UnknownHostException e) {
            System.err.println("Desconocido: " + e.getMessage());
        } catch (SocketException e) {
            System.err.println("Socket: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("E/S: " + e.getMessage());
        }
    }
}
