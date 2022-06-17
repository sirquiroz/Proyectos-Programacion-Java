/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package veintiuno;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 *
 * @author Dennis Medina
 */
class Cerrar_Ventana implements WindowListener{

    public Cerrar_Ventana() {
    }

    public void windowOpened(WindowEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    public void windowClosing(WindowEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
        System.exit(-1);
    }

    public void windowClosed(WindowEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    public void windowIconified(WindowEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    public void windowDeiconified(WindowEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    public void windowActivated(WindowEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    public void windowDeactivated(WindowEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

}
