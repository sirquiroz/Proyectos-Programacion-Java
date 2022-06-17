
import java.io.DataInputStream;
import java.io.InputStream;
import java.net.Socket;

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
            String server = "127.0.0.1";
            int puerto = 1234;
            Socket sk = new Socket(server, puerto);
            InputStream is = sk.getInputStream();
            DataInputStream entrada = new DataInputStream(is);
            System.out.println(entrada.readUTF());
            sk.close();
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
