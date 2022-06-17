package servidorsockets;

/**
 * En el siguiente ejemplo, se desarrolla un mínimo servidor UDP. La aplicación servidor UDP
 * depende de una clase de comunicaciones proporcionada por Java: DatagramSocket Esta clase realiza
 * la mayor parte del trabajo de crear el socket. El servidor implementado escucha por el puerto de
 * comunicaciones 8050, cuando le llega un datagrama procedente de algún cliente, imprime la dirección del cliente, y el
 * puerto por la salida estandar del sistema, y luego envia un datagrama que contiene la fecha del sistema.
 */
import java.net.*;
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
//el puerto de escucha del servidor será el 8050
        int PUERTO = 8050;
        byte msg[] = new byte[1024];
//Creamos el socket UDP del servidor en el pueto asociado
        DatagramSocket s = new DatagramSocket(PUERTO);
        System.out.println("Servidor Activo");
//implementacion del protocolo del servidor en un bucle infinito
        while (true) {
            DatagramPacket recibido = new DatagramPacket(new byte[1024], 1024);
//llega un datagrama
            s.receive(recibido);
            System.out.println("Ha llegado una peticion \n");
            System.out.println("Procedente de :" + recibido.getAddress());
            System.out.println("En el puerto :" + recibido.getPort());
            System.out.println("Sirviendo la petición");
//se prepara el mensaje a enviar con la fecha del sistema
            String message = new String("HORA DEL SERVIDOR " + new Date());
            msg = message.getBytes();
//se crea el datagrama que contendrá al mensaje
            DatagramPacket paquete = new DatagramPacket(msg, msg.length, recibido.getAddress(),
                    recibido.getPort());
//se le envia al cliente
            s.send(paquete);
        }
    }
}
