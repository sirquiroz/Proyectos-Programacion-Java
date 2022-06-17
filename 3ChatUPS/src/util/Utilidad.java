package util;

import java.awt.Color;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Miguel Quiroz
 */
public class Utilidad {

    private final String rutaFile = System.getProperty("user.dir") + "/ficheros/";

    public void createFolder() {
        try {
            File folder = new File(rutaFile);
            if (!folder.exists()) {
                folder.mkdirs();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//createFolder

    public String getFechaHora() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        String date = sdf.format(new Date());
        return date;
    }

    public String getNick() {
        String Nick = JOptionPane.showInputDialog(null, "Ingrese su Nick", "", JOptionPane.PLAIN_MESSAGE);
        new Propiedades().setP("Nick", Nick);
        return Nick;
    }

    public String getServer() {
        String Server = new Propiedades().getP("Server");
        Server = JOptionPane.showInputDialog(null, "Ingrese el Servidor", Server, JOptionPane.PLAIN_MESSAGE);
        new Propiedades().setP("Server", Server);
        return Server;
    }

    public void appendRed(String texto, JTextPane txtChat) {
        append(Color.RED, texto, txtChat);
    }

    public void appendGreen(String texto, JTextPane txtChat) {
        append(Color.GREEN, texto, txtChat);
    }

    public void appendBlue(String texto, JTextPane txtChat) {
        append(Color.BLUE, texto, txtChat);
    }

    public void appendOrange(String texto, JTextPane txtChat) {
        append(Color.ORANGE, texto, txtChat);
    }

    public void append(Color color, String texto, JTextPane txtChat) {
        StyledDocument doc = txtChat.getStyledDocument();
        Style syle = doc.addStyle("txt", null);
        StyleConstants.setForeground(syle, color);
        try {
            texto = getFechaHora() + ":: " + texto + "\n";
            doc.insertString(doc.getLength(), texto, syle);
            txtChat.setCaretPosition(doc.getLength());
        } catch (BadLocationException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

}
