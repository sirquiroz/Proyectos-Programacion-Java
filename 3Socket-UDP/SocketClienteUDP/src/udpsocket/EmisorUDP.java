package udpsocket;
import java.io.*;
import java.net.*;//importo las clases para trabajar con los sockets
public class EmisorUDP {
    public static void main(String args[]){
        int Puerto = 1234;//puerto a comunicar
        InetAddress Destino;//direccion a donde comunicar
        DatagramSocket dgs;//envia y recibe el paquete
        DatagramPacket dgp;//construye el paquete a partir del mensaje
        //el mensaje a enviar por la red que es de 1024 byte
        byte msg[] = new byte[1024];
        //Establecer el socket bajo udp
        try{
            System.out.println("Ingrese el Texto...");
            //leer desde el teclado
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            String a = br.readLine();
            msg = a.getBytes();
            ///////////////////////
            
            dgs = new DatagramSocket();
            //recoger el destino del servidor
            Destino = InetAddress.getByName("Lab3Pc02");
            //creamos un DATAGRAMAPACKET con el mensaje, la longitud, la direccion
            //y el puerto de comunicacion
            dgp = new DatagramPacket(msg,msg.length,Destino,Puerto);
            //envio el paquete por el socket
            dgs.send(dgp);
            //cierro el canal de comunicacion
            dgs.close();
        }catch(Exception e){
            System.out.println("Error en el envio: "+e);
        }
            

    }
}







