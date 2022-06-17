package clientesockets;
import java.net.*;
/**
 * El lado cliente de una aplicación UDP descansa en la clase DatagramSocket.
 * De nuevo, mucho del trabajo necesario para establecer la conexión lo ha realizado la
 * clase DatagramSocket junto a la clase DatagramPacket.
 */
public class Main {
    final static int PORT_DAYTIME = 8050;
// puerto asignado para la comunicación con el servidor
    public static void main(String args[]) throws Exception {
        DatagramSocket dgSocket;
        DatagramPacket datagram;
        InetAddress destination;
        byte msg[] = new byte[1024];
// Establecemos en socket bajo UDP
        dgSocket = new DatagramSocket();
//recogemos el destino del servidor, que se le pasa como parámetro
        destination = InetAddress.getByName("localhost");
//creamos un DATAGRAMA, con el mensaje, la longitud, la dirección y el puerto
        datagram = new DatagramPacket(msg, msg.length, destination,
                PORT_DAYTIME);
//enviamos el datagrama
        dgSocket.send(datagram);
        datagram = new DatagramPacket(msg, msg.length);
//esperamos que nos llegue respuesta desde el servidor
        dgSocket.receive(datagram);
//ha llegado un datagrama, para ver los datos se utiliza getDAta()
        String received = new String(datagram.getData());
        System.out.println("DATOS DEL DATAGRAMA: " + received);
//cerramos el socket UDP
        dgSocket.close();
    }
}



