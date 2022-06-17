/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Deberes;
import java.awt.*;
import javax.swing.*;

public class JPanelFondo extends javax.swing.JPanel {

    /**
     * Creates new form JPanelFondo
     */
    public JPanelFondo() {
        initComponents();
        this.setSize(300,300);
    }
 public void paintComponent(Graphics g) {
     Dimension tam = getSize();
     ImageIcon ImagenFondo = new ImageIcon(new ImageIcon(getClass().getResource("/Background/Background.gif")).getImage());
     g.drawImage(ImagenFondo.getImage(),0,0,tam.width,tam.height,null);
     setOpaque(false);
     super.paintComponent(g);
 }
    @SuppressWarnings("unchecked")
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
