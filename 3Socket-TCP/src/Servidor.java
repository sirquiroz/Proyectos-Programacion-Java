
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JOptionPane;

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
            ServerSocket sk = new ServerSocket(puerto);
            int numCli = 1;
            while(true){
                Socket cliente = sk.accept();
                System.out.println("Nuevo cliente: "+numCli);
                System.out.println("IP: "+cliente.getInetAddress().toString());
                //enviar mensaje al cliente
                OutputStream os = cliente.getOutputStream();
                DataOutputStream salida = new DataOutputStream(os);
                salida.writeUTF("Hola Cliente "+numCli);
                cliente.close();
                numCli++;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
