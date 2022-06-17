package gui;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import util.CifradoCesar;
import util.Propiedades;
import util.Utilidad;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Miguel Quiroz
 */
public class frmVentana extends javax.swing.JFrame {

    private String Nick = "NN";
    private String Server = "127.0.0.1";
    private int puertoChat = 1234;
    private int puertoFile = 4321;
    private Propiedades p = new Propiedades();
    private String rutaFile = System.getProperty("user.dir") + "/ficheros/";

    /**
     * Creates new form frmVentana
     */
    public frmVentana() {
        initComponents();
        txtChat.setContentType("text/html");
        Server = p.getP("Server");
        puertoChat = Integer.parseInt(p.getP("puertoChat"));
        puertoFile = Integer.parseInt(p.getP("puertoFile"));
        //Nick = p.getP("Nick");
        new Utilidad().createFolder();
        Nick = new Utilidad().getNick();
        receptorChat();
        receptorFile();
        setTitle(Nick);
    }

    /**
     * recibe el chat y lo desencrypta
     */
    private void receptorChat() {

        Thread miHiloChat = new Thread() {
            @Override
            public void run() {
                try {
                    ServerSocket sckServer = new ServerSocket(puertoChat);
                    while (true) {
                        //espera y aceptar una peticion
                        Socket sckCliente = sckServer.accept();
                        //sleep(2000);//pausa al hilo para porbar 2 segundos
                        //recibo mensaje del cliente
                        ///////////////////////////////
                        InputStream aux_in = sckCliente.getInputStream();
                        DataInputStream entrada = new DataInputStream(aux_in);
                        String txtIn = entrada.readUTF();
                        String txtDcrypt = CifradoCesar.decrypt(txtIn, Integer.parseInt(p.getP("clave")));
                        new Utilidad().appendRed(txtDcrypt, txtChat);
                        //txtChat.append(new Utilidad().getFechaHora() + ":: " + txtDcrypt + "\n");
                        ///////////////////////////////
                        //envio mensaje al cliente de que me llegó 1 y si no llega deja el 0
                        OutputStream aux_out = sckCliente.getOutputStream();
                        DataOutputStream salida = new DataOutputStream(aux_out);
                        salida.writeUTF("1");
                        ///////////////////////////////
                        sckCliente.close();
                    }
                } catch (IOException | NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Amigo fuera de linea CHAT" + ex);
                }
            }//run
        };
        miHiloChat.start();
    }

    /**
     * recepto los archivos
     */
    private void receptorFile() {
        Thread miHiloFile = new Thread() {
            @Override
            public void run() {
                try {
                    ServerSocket serv = new ServerSocket(puertoFile);
                    //System.out.println("no hay conexion todavia");
                    //int ncli = 0;
                    while (true) {
                        //ncli++;
                        //System.out.println("servidor levantado y listo");
                        Socket cli = serv.accept();
                        //System.out.println("conexion recibida de " + cli.getInetAddress().getHostName());
                        //System.out.println("con ip " + cli.getInetAddress().getHostAddress());
                        //System.out.println("y puerto remoto" + cli.getPort());
                        //System.out.println("puerto local" + cli.getLocalPort());
                        //instanciar los envolventes
                        DataInputStream entrada = new DataInputStream(cli.getInputStream());
                        //DataOutputStream salida = new DataOutputStream(cli.getOutputStream());
                        // objetos
                        //ObjectOutputStream osalida = new ObjectOutputStream(cli.getOutputStream());
                        //ObjectInputStream oentrada = new ObjectInputStream(cli.getInputStream());

                        InputStream isentrada = cli.getInputStream();
                        //System.out.println("leyendo desde el cliente");
                        //System.out.println(entrada.readUTF());
                        //System.out.println(entrada.readUTF());
                        //System.out.println(entrada.readUTF());
                        //System.out.println(entrada.readUTF());
                        //txtChat.append(new Utilidad().getFechaHora() + ":: " + entrada.readUTF() + "\n");
                        String txtDcrypt = CifradoCesar.decrypt(entrada.readUTF(), Integer.parseInt(p.getP("clave")));
                        new Utilidad().appendGreen(txtDcrypt, txtChat);
                        //////txtChat.setText(txtChat.getText() + "<font color=\\\"red\\\">" + new Utilidad().getFechaHora() + ":: " + txtDcrypt + "</font><br>");
                        String snombrefuente = entrada.readUTF();//nombre del archivo
                        File fdestino0 = new File(rutaFile + snombrefuente);
                        FileOutputStream foseldestino = new FileOutputStream(fdestino0);
                        //leer desde el socket, y escribir en el archivo
                        int c;
                        //int numbytes = 0;
                        //int acumnumbytes = 0;
                        while ((c = isentrada.read()) != -1) {
                            foseldestino.write(c);
                        }//fin while
                        foseldestino.close();//cierro el archivo

                        cli.close();
                    }//fin while

                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, "Amigo fuera de linea FICHERO" + e);
                }
            }
        };
        miHiloFile.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnEnviar = new javax.swing.JButton();
        txtTexto = new javax.swing.JTextField();
        lblEstado = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        btnEnviarFichero = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtChat = new javax.swing.JTextPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        btnEnviar.setText("Enviar");
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });

        lblEstado.setText("0");

        btnEnviarFichero.setText("Fichero");
        btnEnviarFichero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarFicheroActionPerformed(evt);
            }
        });

        txtChat.setEditable(false);
        jScrollPane2.setViewportView(txtChat);

        jMenu1.setText("Configuracion");

        jMenuItem1.setText("Servidor");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Nick");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Salir");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addGroup(layout.createSequentialGroup()
                .addComponent(txtTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 706, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEnviar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEnviarFichero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEnviar)
                    .addComponent(txtTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEstado)
                    .addComponent(btnEnviarFichero))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        Server = new Utilidad().getServer();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        Nick = new Utilidad().getNick();
        this.setTitle(Nick);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
        try {
            //me conecto al server
            Socket sckCliente = new Socket(Server, puertoChat);
            //////////////////////////////
            //creo el flujo de salida
            OutputStream aux_os = sckCliente.getOutputStream();
            DataOutputStream salida = new DataOutputStream(aux_os);
            String texto = Nick + ": " + txtTexto.getText().trim();
            String txtEcrypt = CifradoCesar.encrypt(texto, Integer.parseInt(p.getP("clave")));
            salida.writeUTF(txtEcrypt);
            //txtChat.setCaretPosition(txtChat.getStyledDocument().getLength());
            //txtChat.setText("<font color=\\\"red\\\">" + new Utilidad().getFechaHora() + ":: " + texto + "</font><br>");
            new Utilidad().appendBlue(texto, txtChat);
            //txtChat.append(new Utilidad().getFechaHora() + ":: " + Nick + ": " + txtTexto.getText().trim() + "\n");
            txtTexto.setText("");
            lblEstado.setText("0");//lo pongo en 0 para indicar q se envio el mensaje pero aun no recibo respuesta
            //////////////////////////////
            //////////////////////////////
            //creo la entrada entrada de la respuesta del servidor
            InputStream aux = sckCliente.getInputStream();
            DataInputStream entrada = new DataInputStream(aux);
            lblEstado.setText(entrada.readUTF());
            ///////////////////////////////
            sckCliente.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnEnviarActionPerformed
    public File obtenerFichero() {
        File fichero = null;
        JFileChooser jfchooser = new JFileChooser();
        //FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF", "jpg", "gif");

        jfchooser.addChoosableFileFilter(new FileNameExtensionFilter("PDF Documents", "pdf"));
        jfchooser.addChoosableFileFilter(new FileNameExtensionFilter("Images", "jpg", "png", "gif", "bmp"));

        int seleccion = jfchooser.showOpenDialog(null);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            fichero = jfchooser.getSelectedFile();
        }
        return fichero;
    }
    private void btnEnviarFicheroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarFicheroActionPerformed
        //btnEnviarFichero.setEnabled(false);  
        Thread miHilo2 = new Thread() {
            @Override
            public void run() {
                try {
                    //System.out.println("cliente con archivos");
                    Socket cli = new Socket(Server, puertoFile);
                    //System.out.println("El server es"+ cli.getInetAddress().getHostName());
                    //System.out.println("la ip"+ cli.getInetAddress().getHostAddress());
                    //paso de objetos       
                    //ObjectOutputStream osalida = new ObjectOutputStream(cli.getOutputStream());
                    //ObjectInputStream oentrada = new ObjectInputStream(cli.getInputStream());
                    //---------
                    OutputStream ossalida = cli.getOutputStream();
                    //JOptionPane.showMessageDialog(null, "aqui");
                    File fcliente = obtenerFichero();
                    if (fcliente != null) {
                        FileInputStream fiselarchivo = new FileInputStream(fcliente);
                        //System.out.println("datos del archivo");
                        //System.out.println(" nombre" + fcliente.getName());
                        //System.out.println(" ruta " + fcliente.getPath());
                        //DataInputStream entrada = new DataInputStream(cli.getInputStream());
                        DataOutputStream salida = new DataOutputStream(cli.getOutputStream());
                        //salida.writeUTF("CLIENTE tiene el archivo " + fcliente.getName());
                        //salida.writeUTF("cliente y su ruta" + fcliente.getAbsolutePath());
                        //txtChat.append(new Utilidad().getFechaHora() + ":: " + Nick + ": " + fcliente.getName() + "\n");
                        //salida.writeUTF(Nick + ": " + fcliente.getName());
                        String texto = Nick + ": " + fcliente.getName();
                        String txtEcrypt = CifradoCesar.encrypt(texto, Integer.parseInt(p.getP("clave")));
                        salida.writeUTF(txtEcrypt);
                        new Utilidad().appendOrange(texto, txtChat);
                        //txtChat.setText(txtChat.getText() + "<font color=\\\"blue\\\">" + new Utilidad().getFechaHora() + ":: " + texto + "</font><br>");
                        salida.writeUTF(fcliente.getName());
                        //salida.writeUTF("tamaño del archivo bytes" + fcliente.length());
                        //salida.writeUTF("tamaño en kb " + fcliente.length() / 1024);
                        //System.out.println("copiando datos del cliente al servidor");
                        //leer archivo , y escribo en el socket
                        long tamanio = fcliente.length();
                        int numbytes = 0, acumnumbytes = 0;
                        int c;
                        //double cBarra = tamanio / 100;
                        int iBarra = 0;
                        while ((c = fiselarchivo.read()) != -1) {
                            ossalida.write(c);
                            numbytes++;
                            acumnumbytes++;
                            if (acumnumbytes > (tamanio / 20)) {
                                iBarra = iBarra + 5;
                                jProgressBar1.setValue(iBarra);
                                jProgressBar1.setStringPainted(true);
                                //System.out.println("copiando archivos:" + (numbytes / 1024));
                                //System.out.println("faltan.. " + ((fcliente.length() - numbytes) / 1024));
                                acumnumbytes = 0;
                            }//fin if
                        }//fin while
                        jProgressBar1.setValue(100);
                    }//if (fcliente != null) 
                    cli.close();
                    //btnEnviarFichero.setEnabled(true);
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }//run
        };
        miHilo2.start();
    }//GEN-LAST:event_btnEnviarFicheroActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            //falta que coja el formato correcto al abrir
            txtChat.setContentType("text/html");
            File fichero = new File(rutaFile + "/chat.backup");
            if (fichero.exists()) {
                FileReader archivo = new FileReader(fichero);
                String linea;
                String texto = "";
                BufferedReader lectura = new BufferedReader(archivo);
                while ((linea = lectura.readLine()) != null) {
                    texto += linea + "\n";
                }
                lectura.close();
                txtChat.setText(texto);
                archivo.close();
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            //falta que coja el formato correcto al cerrar para guardar
            txtChat.setContentType("text/html");
            FileWriter archivo = new FileWriter(rutaFile + "/chat.backup");
            archivo.write(txtChat.getText());
            archivo.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmVentana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmVentana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmVentana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmVentana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmVentana().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnviar;
    private javax.swing.JButton btnEnviarFichero;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JTextPane txtChat;
    private javax.swing.JTextField txtTexto;
    // End of variables declaration//GEN-END:variables

}
