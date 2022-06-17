//Programar un juego llamado Sudoku, esta es base guia para la resolucion
//del programa, este pequeño programa solo sirve para poder mostrar una
//matriz de 3x3 sin que se repita ningun numero
package Sudoku;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Calendar;

public class Sudoku extends JFrame implements ActionListener {

    JTextField txtTmp;
    public static int A[][] = new int[9][9];
    public static int C[][] = new int[9][9];
    private static final long serialVersionUID = 1L;
    private JLabel etiqueta;
    private long tiempoInicial = 0;
    JTextField V[][];
    JButton b1, b2, b3;
    Font Arial;
    JLabel l2 = new JLabel();
    JLabel Tiempo = new JLabel("Tiempo:");
    JLabel l3 = new JLabel();
    JLabel l4 = new JLabel("Activo");
    JLabel l5 = new JLabel("Jugando");
    public static int n = 35, cont = 0, cont2 = 0;
    String Nombre = null;
    JPanel P[][] = new JPanel[3][3];
    //===============================
    JMenuBar Menu = new JMenuBar();
    //===============================
    JMenu Archivo = new JMenu("Archivo");
    JMenuItem Nuevo = new JMenuItem("Nuevo");
    JMenuItem Cerrar = new JMenuItem("Cerrar");
    //===============================
    JMenu Nivel = new JMenu("Nivel");
    JRadioButton Nivel1 = new JRadioButton("Facil");
    JRadioButton Nivel2 = new JRadioButton("Normal");
    JRadioButton Nivel3 = new JRadioButton("Dificil");
    ButtonGroup NivelGrupo = new ButtonGroup();
    //===============================
    JMenu Ayuda = new JMenu("Ayuda");
    JMenuItem Inst = new JMenuItem("Instrucciones");
    JMenuItem Acerca = new JMenuItem("Acerca");
    //===============================
    JSeparator S1 = new JSeparator();
    JSeparator S2 = new JSeparator();
    JSeparator S3 = new JSeparator();
    JSeparator S4 = new JSeparator();
    JSeparator S5 = new JSeparator();
    
    public void init() {
        etiqueta = new JLabel();
        S5.setOrientation(SwingConstants.VERTICAL);
        S4.setOrientation(SwingConstants.VERTICAL);
        S1.setBounds(20, 155, 80, 5);
        S2.setBounds(20, 100, 80, 5);
        S3.setBounds(20, 200, 80, 5);
        S4.setBounds(99, 100, 5, 100);
        S5.setBounds(20, 100, 5, 100);
        Tiempo.setBounds(30, 140, 60, 60);
        Tiempo.setHorizontalAlignment(SwingConstants.CENTER);
        etiqueta.setBounds(30, 160, 60, 60);
        etiqueta.setHorizontalAlignment(SwingConstants.CENTER);
        add(S1);
        add(S2);
        add(S3);
        add(S4);
        add(S5);
        add(Tiempo);
        add(etiqueta);
        tiempoInicial = System.currentTimeMillis();
        //Thread hilo = new Thread( this );
        //hilo.start();
        
    }
 Thread mihilo;
    public void ver_reloj() {
         mihilo = new Thread() {
            public void run() {
                Calendar tiempo = Calendar.getInstance();
                while (true) {
                    try {
                        tiempo.setTimeInMillis(System.currentTimeMillis() - tiempoInicial);
                        etiqueta.setText(
                                tiempo.get(Calendar.MINUTE) + ":" + tiempo.get(Calendar.SECOND));
                        sleep(1000);
                    } catch (Exception e) {
                        System.out.println("Error: " + e);
                    }
                }
            }
        };
        mihilo.start();
    }
    //@SuppressWarnings("unchecked")
    public Sudoku() {
        crear_sudoku();
    }
    public void crear_sudoku() {
        juegos();
        mostrarjuego();
        setTitle("Sudoku V1.1");
        Archivo.add(Nuevo);
        Nuevo.addActionListener(this);
        Nuevo.setToolTipText("Muestra un nuevo Sudoku");
        Archivo.add(Cerrar);
        Cerrar.addActionListener(this);
        Cerrar.setToolTipText("Cierra el Programa");
        NivelGrupo.add(Nivel1);
        Nivel1.addActionListener(this);
        Nivel1.setToolTipText("Nivel facil que muestra entre 40 a 45 numeros en la tabla");
        NivelGrupo.add(Nivel2);
        Nivel2.addActionListener(this);
        Nivel2.setToolTipText("Nivel Medio que muestra entre 35 a 40 numeros en la tabla");
        NivelGrupo.add(Nivel3);
        Nivel3.addActionListener(this);
        Nivel3.setToolTipText("Nivel Dificil que muestra entre 30 a 35 numeros en la tabla");
        Nivel.add(Nivel1);
        Nivel.add(Nivel2);
        Nivel.add(Nivel3);
        Ayuda.add(Inst);
        Inst.addActionListener(this);
        Inst.setToolTipText("Muestra la manera en la que se juega SUDOKU");
        Ayuda.add(Acerca);
        Acerca.addActionListener(this);
        Acerca.setToolTipText("Creditos de Realizadores de el Programa");
        Menu.add(Archivo);
        Menu.add(Nivel);
        Menu.add(Ayuda);
        setJMenuBar(Menu);
        setResizable(false);

        java.net.URL url = getClass().getResource("/Images/ico_com.ico");
        java.awt.Image imagen = getToolkit().getImage(url);
        setIconImage(imagen);

        if(cont>0){
            init();
            Nuevo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
            Nuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/indice.jpeg")));
            Cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/exit.PNG")));

            int x = 199, y = 15, z3 = 0;//312,315
            for (int z = 0; z < 3; z++) {
                for (int z2 = 0; z2 < 3; z2++) {
                    P[z2][z] = new JPanel();
                    P[z2][z].setBorder(javax.swing.BorderFactory.createLineBorder(Color.BLUE, 2));
                    P[z2][z].setBounds(x, y, 104, 105);
                    add(P[z2][z]);
                    x = x + 102;
                    z3++;
                    P[z2][z].setLayout(new GridLayout(3, 3));
                }
                x = x - 306;
                y = y + 104;
            }

            int f = (int) (Math.random() * 74 + 1);
            l2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/" + f + ".gif")));
            add(l2);

            if(f < 75){l2.setBounds(55, 250, 66, 66);}
            else{l2.setBounds(35, 210, 100, 100);}
            V = new JTextField[9][9];
            l4 = new JLabel("ESTADO");
            l4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/inactivo.png")));
            l4.setHorizontalTextPosition(SwingConstants.CENTER);
            l4.setVerticalTextPosition(SwingConstants.BOTTOM);
            l4.setToolTipText("Inactivo");
            l4.getColorModel().getBlue(300);
            add(l4);
            l4.setBounds(60, 20, 60, 60);

            x = 0;
            y = 0;
            for (int i=0;i<9;i++){
                for (int j=0;j<9;j++){
                    if (C[i][j] == -1){
                        V[i][j]= new JTextField(""+A[i][j],1);
                        V[i][j].setEnabled(false);
                    } else{
                        V[i][j]= new JTextField(1);
                    }
                    V[i][j].setFont(new Font("Arial", 1, 16));
                    V[i][j].setDisabledTextColor(Color.BLACK);
                    V[i][j].setHorizontalAlignment(javax.swing.JTextField.CENTER);
                    V[i][j].setForeground(Color.blue);
                    P[x][y].add(V[i][j]);
                    // txtTmp = V[i][j];
                    V[i][j].addKeyListener(new java.awt.event.KeyAdapter() {
                        public void keyTyped(java.awt.event.KeyEvent evt) {
                            txtNumKeyTyped(evt);
                        }
                    });
                    V[i][j].addFocusListener(new FocusAdapter() {
                        public void focusGained(FocusEvent e) {
                            foco(e);
                        }
                    });
                    if ((j + 1)%3==0){x++;}
                }
                x= 0;
                if((i+1)%3==0){y++;}
            }
            b1 = new JButton("Terminado");
            b1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/terminar.png")));
            b1.setBounds(225, 350, 135, 35);
            add(b1);
            b1.addActionListener(this);
            b2 = new JButton("Resolver");
            b2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/sodoku.png")));
            b2.setBounds(360, 350, 130, 35);
            add(b2);
            b2.addActionListener(this);
            b3 = new JButton("Otro");
            b3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/toad.png")));
            b3.setBounds(40, 320, 85, 70);
            add(b3);
            b3.addActionListener(this);
            b3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
            b3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
            Jugador();
        }
        setLayout(null);
        setSize(550, 480);
        setVisible(true);
        getContentPane().setBackground(Color.white);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        cont++;
    }
    public void iterate(){/*Thread hilo = new Thread(this); hilo.stop();*/}
    private KeyEvent e;
    private void foco(FocusEvent e) {
        txtTmp = (JTextField) e.getSource();
        txtTmp.setSelectionStart(0);
        txtTmp.setSelectionEnd(txtTmp.getText().length());
    }
    private void txtNumKeyTyped(KeyEvent e) {
        this.e = e;
        char a = e.getKeyChar();
        if (!(a >= KeyEvent.VK_0 && a <= KeyEvent.VK_9)) {
            e.consume();
        }
        txtTmp = (JTextField) e.getSource();
        //System.out.println(""+txt.getText().length());
        if (txtTmp.getText().length() > 0) {
            // Máximo de caracteres impido la acción
            txtTmp.setText(txtTmp.getText().substring(0, 0));
            //e.consume();
        }
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(b1)) {
            comprobar();
            b1.setEnabled(false);
            etiqueta.setEnabled(false);
            iterate();
        }
        if (e.getSource().equals(b2)) {
            for (int i=0;i<9;i++){for(int j=0;j<9;j++){V[i][j].setText((A[i][j] + ""));V[i][j].setEnabled(false);}}
            b1.setEnabled(false);
            b2.setEnabled(false);
            etiqueta.setEnabled(false);
            //etiqueta.setVisible(false);
            mihilo.stop();
        }
        if (e.getSource().equals(b3)){
            int f= (int)(Math.random()*83+1);
            l2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/" + f + ".gif"))); add(l2);
            if(f<75){l2.setBounds(55, 240, 66, 66);}
            else{l2.setBounds(35, 200, 100, 100);}
        }
        if (e.getSource().equals(Nuevo)){dispose();new Sudoku();cont2 = 0;}
        if (e.getSource().equals(Cerrar)){System.exit(-1);}
        if (e.getSource().equals(Nivel1)){n = 40;}
        if (e.getSource().equals(Nivel2)){n = 35;}
        if (e.getSource().equals(Nivel3)){n = 30;}
        if (e.getSource().equals(Inst)){Ayudar();}
        if (e.getSource().equals(Acerca)){Acerca();}
    }
    public static void juegos() {
        //Almacenamos diez plantillas de Sudoku
        int S0[]= {1, 2, 3, 5, 6, 7, 8, 9, 4, 4, 5, 6, 1, 8, 9, 2, 3, 7, 7, 8, 9, 2, 3, 4, 1, 5, 6, 2, 1, 4, 3, 5, 6, 7, 8, 9, 3, 6, 5, 7, 9, 8, 4, 1, 2, 8, 9, 7, 4, 1, 2, 3, 6, 5, 5, 3, 2, 6, 4, 1, 9, 7, 8, 6, 4, 8, 9, 7, 3, 5, 2, 1, 9, 7, 1, 8, 2, 5, 6, 4, 3};
        int S1[]= {8, 3, 5, 4, 1, 6, 9, 2, 7, 2, 9, 6, 8, 5, 7, 4, 3, 1, 4, 1, 7, 2, 9, 3, 6, 5, 8, 5, 6, 9, 1, 3, 4, 7, 8, 2, 1, 2, 3, 6, 7, 8, 5, 4, 9, 7, 4, 8, 5, 2, 9, 1, 6, 3, 6, 5, 2, 7, 8, 1, 3, 9, 4, 9, 8, 1, 3, 4, 5, 2, 7, 6, 3, 7, 4, 9, 6, 2, 8, 1, 5};
        int S2[]= {3, 6, 1, 4, 7, 2, 5, 8, 9, 9, 8, 4, 5, 1, 6, 7, 2, 3, 5, 7, 2, 9, 3, 8, 6, 1, 4, 4, 5, 3, 7, 2, 1, 9, 6, 8, 6, 1, 7, 8, 9, 3, 2, 4, 5, 2, 9, 8, 6, 4, 5, 1, 3, 7, 8, 4, 6, 1, 5, 7, 3, 9, 2, 7, 2, 9, 3, 6, 4, 8, 5, 1, 1, 3, 5, 2, 8, 9, 4, 7, 6};
        int S3[]= {9, 6, 3, 1, 7, 4, 2, 5, 8, 1, 7, 8, 3, 2, 5, 6, 4, 9, 2, 5, 4, 6, 8, 9, 7, 3, 1, 8, 2, 1, 4, 3, 7, 5, 9, 6, 4, 9, 6, 8, 5, 2, 3, 1, 7, 7, 3, 5, 9, 6, 1, 8, 2, 4, 5, 8, 9, 7, 1, 3, 4, 6, 2, 3, 1, 7, 2, 4, 6, 9, 8, 5, 6, 4, 2, 5, 9, 8, 1, 7, 3};
        int S4[]= {7, 6, 5, 9, 1, 4, 8, 2, 3, 3, 8, 4, 7, 2, 5, 1, 6, 9, 1, 2, 9, 6, 8, 3, 7, 4, 5, 4, 1, 7, 3, 6, 9, 5, 8, 2, 2, 9, 8, 5, 7, 1, 6, 3, 4, 6, 5, 3, 8, 4, 2, 9, 7, 1, 8, 4, 2, 1, 5, 7, 3, 9, 6, 5, 3, 6, 4, 9, 8, 2, 1, 7, 9, 7, 1, 2, 3, 6, 4, 5, 8};
        int S5[]= {3, 4, 9, 6, 2, 7, 5, 1, 8, 8, 1, 2, 3, 5, 4, 6, 9, 7, 5, 6, 7, 1, 9, 8, 4, 3, 2, 6, 5, 3, 7, 1, 2, 8, 4, 9, 7, 2, 4, 8, 3, 9, 1, 6, 5, 1, 9, 8, 5, 4, 6, 2, 7, 3, 9, 8, 6, 2, 7, 1, 3, 5, 4, 2, 7, 5, 4, 6, 3, 9, 8, 1, 4, 3, 1, 9, 8, 5, 7, 2, 6};
        int S6[]= {2, 7, 3, 8, 9, 1, 6, 4, 5, 9, 8, 6, 4, 5, 3, 2, 1, 7, 4, 5, 1, 6, 2, 7, 9, 3, 8, 1, 4, 8, 5, 7, 9, 3, 6, 2, 7, 6, 5, 2, 3, 4, 8, 9, 1, 3, 2, 9, 1, 8, 6, 7, 5, 4, 5, 1, 7, 3, 6, 2, 4, 8, 9, 6, 9, 4, 7, 1, 8, 5, 2, 3, 8, 3, 2, 9, 4, 5, 1, 7, 6};
        int S7[]= {4, 6, 7, 9, 8, 3, 1, 5, 2, 5, 8, 3, 1, 2, 4, 7, 6, 9, 2, 9, 1, 7, 5, 6, 3, 4, 8, 6, 7, 4, 2, 1, 8, 9, 3, 5, 8, 2, 5, 3, 7, 9, 4, 1, 6, 1, 3, 9, 4, 6, 5, 2, 8, 7, 3, 4, 6, 8, 9, 2, 5, 7, 1, 9, 1, 8, 5, 3, 7, 6, 2, 4, 7, 5, 2, 6, 4, 1, 8, 9, 3};
        int S8[]= {8, 6, 2, 7, 5, 4, 9, 1, 3, 1, 9, 5, 2, 6, 3, 7, 4, 8, 4, 7, 3, 9, 1, 8, 5, 2, 6, 2, 8, 6, 1, 3, 5, 4, 7, 9, 7, 3, 1, 4, 8, 9, 6, 5, 2, 9, 5, 4, 6, 2, 7, 3, 8, 1, 3, 2, 7, 8, 4, 6, 1, 9, 5, 6, 1, 9, 5, 7, 2, 8, 3, 4, 5, 4, 8, 3, 9, 1, 2, 6, 7};
        int S9[]= {8, 5, 2, 4, 7, 6, 3, 1, 9, 3, 4, 9, 1, 5, 2, 7, 8, 6, 1, 7, 6, 3, 9, 8, 4, 5, 2, 4, 3, 5, 9, 8, 1, 6, 2, 7, 7, 9, 8, 6, 2, 4, 1, 3, 5, 6, 2, 1, 5, 3, 7, 9, 4, 8, 2, 1, 7, 8, 6, 3, 5, 9, 4, 5, 6, 3, 2, 4, 9, 8, 7, 1, 9, 8, 4, 7, 1, 5, 2, 6, 3};
        //Almacenamos un arreglo aleatorio en una matriz
        int num,i,j,k=0;
        num= (int)(Math.random()*10);
        if(num==0){for(i=0;i<9;i++){for(j=0;j<9;j++){A[i][j]=S0[k];k++;}}}
        if(num==1){for(i=0;i<9;i++){for(j=0;j<9;j++){A[i][j]=S1[k];k++;}}}
        if(num==2){for(i=0;i<9;i++){for(j=0;j<9;j++){A[i][j]=S2[k];k++;}}}
        if(num==3){for(i=0;i<9;i++){for(j=0;j<9;j++){A[i][j]=S3[k];k++;}}}
        if(num==4){for(i=0;i<9;i++){for(j=0;j<9;j++){A[i][j]=S4[k];k++;}}}
        if(num==5){for(i=0;i<9;i++){for(j=0;j<9;j++){A[i][j]=S5[k];k++;}}}
        if(num==6){for(i=0;i<9;i++){for(j=0;j<9;j++){A[i][j]=S6[k];k++;}}}
        if(num==7){for(i=0;i<9;i++){for(j=0;j<9;j++){A[i][j]=S7[k];k++;}}}
        if(num==8){for(i=0;i<9;i++){for(j=0;j<9;j++){A[i][j]=S8[k];k++;}}}
        if(num==9){for(i=0;i<9;i++){for(j=0;j<9;j++){A[i][j]=S9[k];k++;}}}
        arreglarjuego();
    }
    public static void arreglarjuego() {
        int B[][]= new int[9][9];
        int i,j,num;
        num=(int)(Math.random() * 4);
        if(num==0){for(i=0;i<9;i++){for(j=0;j<9;j++){B[i][j]= A[i][j];}}} //La matriz B almacena la matriz A
        if(num==1){for(i=0;i<9;i++){for(j=0;j<9;j++){B[i][j]= A[j][i];}}} //La matriz B almacena la transpuesta de la matriz A
        if(num==2){for(i=0;i<9;i++){for(j=0;j<9;j++){B[i][j]= A[i][8-j];}}} //La matriz B almacena la Matriz A volteada horizontalmente
        if(num==3){for(i=0;i<9;i++){for(j=0;j<9;j++){B[i][j]= A[8-j][i];}}} //La matriz B almacena la Matriz A volteada verticalmente
        for(i=0;i<9;i++){for(j=0;j<9;j++){A[i][j]=B[i][j];}}
    }
    public static void mostrarjuego() {
        int num1 = 0, k, i, pos, j;
        int aux[] = new int[81];
        k = (int) (Math.random() * 5 + n + 1);
        for (i = 0; i < 81; i++) {aux[i] = 0;}
        for (i = 0; i < k; i++) {do {pos = (int) (Math.random() * 81);} while (aux[pos] == -1);aux[pos] = -1;}
        for (i = 0; i < 9; i++) {for (j = 0; j < 9; j++){C[i][j] = aux[num1];num1++;}}
    }
    public void comprobar() {
        int contj= 0;
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                try{
                    C[i][j]= Integer.parseInt(V[i][j].getText());
                    if(C[i][j]!=A[i][j]){
                        if(contj <= 0){JOptionPane.showMessageDialog(null, "El resultado es erroneo");}
                        V[i][j].setForeground(Color.red);
                        contj++;
                    }
                }catch (Exception e){
                    if (C[i][j] != A[i][j] && contj <= 0){
                        JOptionPane.showMessageDialog(null, "El resultado es erroneo");
                        contj++;
                    }
                    V[i][j].setForeground(Color.red);
                }
            }
        }
        if(contj == 0){JOptionPane.showMessageDialog(null, "Juego Excelente");}
    }
    public void Ayudar() {
        JOptionPane.showMessageDialog(null, "                            Reglas del Juego\n"
                + "Se debe ingresar numeros del 1 al 9 en cada casillero\n"
                + "controlando que no se repita en linea vertical, horizontal\n"
                + "ni en el recuadro de 3x3 ", "Instrucciones", 1);
    }
    public void Acerca() {
        JOptionPane.showMessageDialog(null, "           THE GREAT GAME OF SUDOKU V 1.0\n\n"
                + "                       Programa Escrito por:\n"
                + "           Danilo Borja Chaves - Diseño Logico\n"
                + "Carlos Espinoza Alcivar - Diseño Estructurado                  \n"
                + "                       danborja@hotmail.com\n"
                + "                      c_j_hardy@hotmail.com\n"
                + "                                 20/12/2010", "Acerca", 1);
    }
    public void Jugador(){
        l5.setHorizontalAlignment(SwingConstants.CENTER);
            l4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/activo.png")));
            add(l5);
            l5.setBounds(20, 100, 80, 30);
            Nombre = JOptionPane.showInputDialog(null, "Introduzca Nombre: ", "Nombre del Jugador", 3);
            if (cont2>0){remove(l3);}
            l3 = new JLabel(Nombre);
            l3.setHorizontalAlignment(SwingConstants.CENTER);
            add(l3);
            l3.setBounds(22, 120, 80, 30);
            if (Nombre.equals("bebitahemoxa")) {
                l2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/b.JPG")));
                add(l2);
                l2.setBounds(5, 160, 200, 200);
            }
            cont2++;
            tiempoInicial = System.currentTimeMillis();
            ver_reloj();
    }
}
