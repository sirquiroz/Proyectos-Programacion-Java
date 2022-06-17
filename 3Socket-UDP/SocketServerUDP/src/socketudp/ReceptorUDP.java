package socketudp;
import java.net.*;
public class ReceptorUDP {
    public static void main(String args[]){
        int Puerto=1234;//puerto en el cual voy a trabajar
        byte msg[] = new byte[1024];
        try{
            //creamos el socket udp en el puerto asociado
            DatagramSocket dgs = new DatagramSocket(Puerto);
            System.out.println("Servidor Activo esperando Peticiones..");
            //implementacion del protocolo del servidor
            //en un bucle infinito
            while(true){
                //creo el paquete indicando el mensaje y el puerto que escucha
                DatagramPacket dgp_recibido = new DatagramPacket(new byte[1024], 1024);
                //cuando llega un dataGramaPacket lo trabajo
                dgs.receive(dgp_recibido);//recibo el paquete enviado
                System.out.println("Ha llegado un mensaje...");
                System.out.println("Procedente de la ip: " + dgp_recibido.getAddress());
                System.out.println("En el Puerto: " + dgp_recibido.getPort());
                //recibir el msn y lo tranformo a String
                String mensaje = new String(dgp_recibido.getData());
                System.out.println("El mensaje es: "+ mensaje);


                
            }
        }catch(Exception e){
            System.out.println("Error en el Server: "+e);
        }

    }

}
