package PROYECTO;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JOptionPane;

public class CerrarVentana implements WindowListener {

    public void windowOpened(WindowEvent e) {

    }

    public void windowClosing(WindowEvent e) {
         int a = JOptionPane.showConfirmDialog(null, "DESEA ABANDONAR MONOPOLY ?");
         if(a==0){
            System.exit(-1);
         }
    }

    public void windowClosed(WindowEvent e) { }

    public void windowIconified(WindowEvent e) { }

    public void windowDeiconified(WindowEvent e) { }

    public void windowActivated(WindowEvent e) { }

    public void windowDeactivated(WindowEvent e) { }

}
