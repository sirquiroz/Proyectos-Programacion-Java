/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Sudoku;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Progress extends JFrame {

    JProgressBar current;
    JTextArea out;
    JButton find;
    Thread runner;
    int num = 0;
    JFrame f;

    public Progress() {
        super("Cargando.......");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel pane = new JPanel();
        pane.setLayout(new FlowLayout());
        current = new JProgressBar(0, 1000);
        current.setValue(0);
        current.setStringPainted(true);
        pane.add(current);
        setContentPane(pane);

    }


    public void iterate() {
        while (num <= 1100) {
            current.setValue(num);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) { }
            num += 250;
        }
    }

    public static void main(String[] arguments) {
        Progress frame = new Progress();
        frame.getContentPane().setBackground(Color.red);
        frame.setSize(200,65);
        frame.setVisible(true);
        
        frame.iterate();
        frame.setVisible(false);
        new Sudoku();
   }
}

