package Juego;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;
import java.util.LinkedList;
import java.util.Random;
import javax.swing.*;
import javax.swing.border.Border;

public class DragCartasPanel extends JFrame implements MouseListener, MouseMotionListener, ActionListener {

    private boolean jug2=false;//si no es el turno del jugador 1, pues lo es del 2
    private Carta CartaSelected=null;
    private Rectangle2D tablero;
    
    
    private static final int CARTA_DIAMETER_X = 50; // dimensiones de la cartas
    private static final int CARTA_DIAMETER_Y = 70;// dimensiones de la cartas
       
    private JButton baraja = new JButton("Barajar");
    private JButton monto1 = new JButton("   ");
    private JButton monto2 = new JButton("   ");
    private JButton bpuntos1 = new JButton(" ");
    private JButton bpuntos2 = new JButton(" ");
    private JLabel Nombrepuntos = new JLabel("Puntos:");
    private JLabel Nombremonto2 = new JLabel("Monto:");
    private JLabel Nombrepuntos1 = new JLabel("Puntos:");
    private JLabel Nombremonto1 = new JLabel("Monto:");
    private JLabel fondo;

    LinkedList<Carta> Jugador1= new <Carta> LinkedList();
    LinkedList<Carta> Jugador2= new <Carta> LinkedList();
    
    LinkedList<Carta> PilaCartas = new <Carta> LinkedList();//lista enlazada
    LinkedList<Carta> CartasEnMesa = new <Carta> LinkedList();
    AudioClip musica;
    private JLabel perfilJugador = new JLabel();
    private JLabel nombreJugador = new JLabel();
    
    private JLabel perfilJugador1 = new JLabel();
    private JLabel nombreJugador1 = new JLabel();
    private int c = 0, click = 0;
    //CUANDO LA CARTA NO HAYA SIDO PULSADA     
    String ruta = System.getProperty("user.dir");
    Border border = BorderFactory.createLineBorder(Color.black, 2);
    //Vector cartas = new Vector();
    Random aleatorio = new Random();
    Registro datos;

    
    
    public DragCartasPanel(Registro form) {
        this.tablero=new Rectangle2D.Double(300,300,420,CARTA_DIAMETER_Y);
        
        this.fondo = new JLabel(){
            @Override
            public void paintComponent(Graphics g){
                super.paintComponent(g);
                ((Graphics2D)g).draw(tablero);
            }
        };
        this.CrearCartas();
        this.agregarCartas();
        cartasIniciales();
        coordenadasIniciales();
                
        setLayout(null);
        //barajaImagenes();
        datos = form;
        setSize(1140, 720);
        setBackground(Color.blue);
        setForeground(Color.yellow);
        poisicionesOtrosComponentes();
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        agregarOtrosComponentes();
        

        
        setVisible(true);
        musica = Applet.newAudioClip(getClass().getResource("/img/apolo.wav"));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        repaint();
        this.fondo.repaint();
    }
    public static int NumAleatorio(int x,int y){
        double i;
        i=Math.random();
        return (int)Math.floor(i*(y-x+1)+x);
    }
    public void RepartirCartas(int n){
        int x=0;
        int y=this.PilaCartas.indexOf(this.PilaCartas.getLast());
        int k;//con fines graficos
        
        for(int i=0;i<n;i++){
            Carta c;
            c=this.PilaCartas.remove(NumAleatorio(x,y));
            this.Jugador1.addFirst(c);
            y--;
            c=this.PilaCartas.remove(NumAleatorio(x,y));
            this.Jugador2.addFirst(c);
            y--;
        }
        int f=420;
        int in=300;
        k=(int)Math.floor(((double)(f-(Jugador1.size()*CARTA_DIAMETER_X)))/((double)(Jugador1.size()-1)));
        int i=0;
        for(Carta c:Jugador1){
            c.setBounds(in+((k+CARTA_DIAMETER_X)*i), 590, CARTA_DIAMETER_X, CARTA_DIAMETER_Y);
            c.x=in+((k+CARTA_DIAMETER_X)*i);
            c.y=590;
            i++;
        }
        i=0;
        k=(int)Math.floor(((double)(f-(Jugador2.size()*CARTA_DIAMETER_X)))/((double)(Jugador2.size()-1)));
        for(Carta c:Jugador2){
            c.setBounds(in+((k+CARTA_DIAMETER_X)*i), 10, CARTA_DIAMETER_X, CARTA_DIAMETER_Y);
            c.x=in+((k+CARTA_DIAMETER_X)*i);
            c.y=10;
            i++;
        }
        this.OrdenarPilaCartas();
        
    }
    public void OrdenarPilaCartas(){
        int i=0;
        for(Carta c:this.PilaCartas){
            c.setBounds(250,300+(i*1), CARTA_DIAMETER_X, CARTA_DIAMETER_Y);
            c.x=250;
            c.y=300+(i*1);
            c.Ocultar();
            i++;
        }
    }
    public void CrearCartas(){
        for(int i=1;i<=10;i++){
            Carta c=new Carta(i, 250, 300, CARTA_DIAMETER_X, CARTA_DIAMETER_Y);
            c.Frente=new ImageIcon("img/"+Carta.IntToString(c.num)+"-C-N.png");
            this.PilaCartas.add(c);
            c=new Carta(i, 250, 300, CARTA_DIAMETER_X, CARTA_DIAMETER_Y);
            c.Frente=new ImageIcon("img/"+Carta.IntToString(c.num)+"-C-R.png");
            this.PilaCartas.add(c);
            c=new Carta(i, 250, 300, CARTA_DIAMETER_X, CARTA_DIAMETER_Y);
            c.Frente=new ImageIcon("img/"+Carta.IntToString(c.num)+"-D-R.png");
            this.PilaCartas.add(c);
            c=new Carta(i, 250, 300, CARTA_DIAMETER_X, CARTA_DIAMETER_Y);
            c.Frente=new ImageIcon("img/"+Carta.IntToString(c.num)+"-T-N.png"); 
            this.PilaCartas.add(c);
        }
    }
    public void paintComponent(Graphics g) {  
    }//el fin con paintComponent

    public void mousePressed(MouseEvent e) {

        //MOVIMIENTO DE CARTA


        int x = e.getX();   //Devuelven la posición x,y del mouse
        int y = e.getY();
        if(this.jug2){
            for (Carta c : this.Jugador1) {
                if (x >= c.x && x <= (c.x + c.tamx)
                        && y >= c.y && y <= (c.y + c.tamy)) {
                        this.CartaSelected=c;
                    c.fromx = x - c.x;
                    c.fromy = y - c.y;
                }
            }
        }else{
            for (Carta c : this.Jugador2) {
                if (x >= c.x && x <= (c.x + c.tamx)
                        && y >= c.y && y <= (c.y + c.tamy)) {
                        this.CartaSelected=c;
                    c.fromx = x - c.x;
                    c.fromy = y - c.y;
                }
            }
        }
    }

    public void mouseDragged(MouseEvent e) {
        //MOVIMIENTO DE CARTA Y NUEVA POSICION DE LA MISMA.

        if(this.CartaSelected!=null){
                Carta c=this.CartaSelected;
                c.x = e.getX() - c.fromx;
                c.y = e.getY() - c.fromy;
                c.x = Math.max(c.x, 0);
                c.x = Math.min(c.x, getWidth() - c.tamx);
                c.y = Math.max(c.y, 0);
                c.y = Math.min(c.y, getHeight() - c.tamy);
                c.setBounds(c.x, c.y, c.tamx, c.tamy);
        }
}



    
    private void coordenadasIniciales() {

        for(Carta c : this.PilaCartas) {
            c.setBounds(c.x,c.y,c.tamx,c.tamy);
        }
            
    }

    private void cartasIniciales() {
        for(Carta c: this.PilaCartas){
            c.setIcon(c.Opuesto);
        }
    }

    private void agregarCartas() {
        for(Carta c: this.PilaCartas){
        add(c);
        }
    }

    private void poisicionesOtrosComponentes() {

        Nombrepuntos.setBounds(755, 15, 50, 30);
        Nombrepuntos.setForeground(Color.white);
        Nombrepuntos1.setBounds(755,625, 50, 30); 
        Nombrepuntos1.setForeground(Color.white);
        Nombremonto2.setBounds(860, 15,  50, 30);
        Nombremonto2.setForeground(Color.white);
        Nombremonto1.setBounds(860, 625, 50, 30);
        Nombremonto1.setForeground(Color.white);
        
        
        bpuntos1.setBounds(800, 15, 50, 30);
        bpuntos2.setBounds(800, 625, 50, 30);

        monto1.setBounds(900, 15, 90, 30);
        monto2.setBounds(900, 625, 90, 30);

        baraja.setBounds(720, 320, 90, 35);

        perfilJugador.setBounds(50, 580, 100, 80);

        nombreJugador.setBounds(200, 600, 100, 30);

        perfilJugador1.setBounds(50, 20, 100, 80);

        nombreJugador1.setBounds(200, 100, 100, 30);
        
        fondo.setSize(1200, 680);
    }

    private void agregarOtrosComponentes() {



        bpuntos1.setBackground(Color.yellow);
        bpuntos2.setBackground(Color.yellow);

        //lcompu.setIcon(new ImageIcon(ruta + "/img/computador.jpg"));
       

        perfilJugador.setIcon(new ImageIcon(ruta + datos.imagen));
        nombreJugador.setText(datos.nombre);
        nombreJugador.setForeground(Color.white);
        
        perfilJugador1.setIcon(new ImageIcon(ruta + datos.imagen));
        nombreJugador1.setText(datos.nombre);
        nombreJugador1.setForeground(Color.white);

        fondo.setIcon(new ImageIcon(ruta + "/img/poker.jpg"));

        baraja.addActionListener(this); //CUANDO HAGA CLICK EN BARAJA
        add(perfilJugador);
        add(nombreJugador);
        add(perfilJugador1);
        add(nombreJugador1);
        add(Nombrepuntos);
        add(Nombrepuntos1);
        add(Nombremonto1);
        add(Nombremonto2);
        add(monto2);
        add(monto1);
        add(bpuntos2);
        add(bpuntos1);
        add(baraja);
        add(fondo);
      
    }

    public void mouseExited(MouseEvent e) { // Se activa cuando el mouse sale del Panel
        this.CartaSelected=null;
    }
   

    //Si no queremos hacer uso de alguna de ellas, debemos declararlas igualmente, simplemente, sin ningún código dentro
    public void mouseMoved(MouseEvent e) {
    }  // ignore these events

    public void mouseEntered(MouseEvent e) {
    }  // ignore these events

    public void mouseClicked(MouseEvent e) {
    }  // ignore these events

    public void mouseReleased(MouseEvent e) {
        if(this.CartaSelected!=null){
            if(this.CartaEsJugable(CartaSelected,e.getPoint())){
                    if(!this.Jugador2.remove(this.CartaSelected)){
                        this.Jugador1.remove(this.CartaSelected);
                    }
            if(!this.CartasEnMesa.isEmpty()){
                Carta c=this.EstaEnMesa(CartaSelected,e.getPoint());
                if(c!=null){
                    this.Llevar(CartaSelected,c);
                }else{
                    if(this.EsSumable(CartaSelected,e.getPoint())){
                        Carta A=this.SumaA(CartaSelected,e.getPoint());
                        Carta B=this.SumaB(CartaSelected,e.getPoint(),A.num);
                        this.LlevarSuma(A, B, CartaSelected);
                    }else{
                        this.PonerEnMesa(CartaSelected);
                    }
                }
                                
            }else{
                this.PonerEnMesa(CartaSelected);
            }
           
            this.jug2=!this.jug2;
            }
            this.CartaSelected=null;
            
        }
        try{
        if(Integer.parseInt(this.bpuntos1.getText())>=40){
            JOptionPane.showMessageDialog(null, "Felicidades Jugador1 ha ganado");
            System.exit(0);
        }
        }catch(NumberFormatException ex){
            
        }
        try{
        if(Integer.parseInt(this.bpuntos2.getText())>=40){
            JOptionPane.showMessageDialog(null, "Felicidades " +datos.nombre + " ha ganado");
            System.exit(0);
        }
        }catch(NumberFormatException ex){
            
        }
        this.repaint();
    }  // ignore these even
private boolean CartaEsJugable(Carta c,Point pt){
    if(CartasEnMesa.isEmpty()&&this.tablero.contains(pt)){
        return true;
    }
    for(Carta p:this.CartasEnMesa){
        if(p.Contiene(pt)){
            return true;
        }        
    }
    return false;
}
private boolean EsSumable(Carta c,Point pt){
    int i=-1;
    int n=-1;
//    System.out.println("c.num="+c.num);
//    System.out.println("entra a esSumable");
    for(Carta p:this.CartasEnMesa){
        if(p.Contiene(pt)&&n==-1){
            i=this.CartasEnMesa.indexOf(p);
            n=p.num;
            //System.out.println("esta contenido en:"+p.num);
        }        
    }
    if(n==-1){
        //System.out.println("no lo encuentra");
        return false;
    }
    for(Carta p:this.CartasEnMesa){
        if((n+p.num)==c.num&&i!=this.CartasEnMesa.indexOf(p)){
            //System.out.println("es true xq es"+p.num);
            return true;            
        }
    }
    return false;
}private Carta SumaB(Carta c,Point pt,int n){
    int i=-1;
    for(Carta p:this.CartasEnMesa){
        if((n+p.num)==c.num){
            i=this.CartasEnMesa.indexOf(p);            
        }
    }
    if(i!=-1){
        return this.CartasEnMesa.remove(i);
    }
    System.out.println("retorno null en SumaB");
    return null;
}
private Carta SumaA(Carta c,Point pt){
    int i=-1;
    for(Carta p:this.CartasEnMesa){
        if(p.Contiene(pt)&&i==-1){
            i=this.CartasEnMesa.indexOf(p);
        }        
    }
    if(i!=-1){
        return this.CartasEnMesa.remove(i);
    }
    System.out.println("retorno null en SumaA");
    return null;
}
private Carta EstaEnMesa(Carta c,Point pt){
    int i=-1;
    for(Carta p:this.CartasEnMesa){
        if(p.num==c.num&&p.Contiene(pt)){
            i=this.CartasEnMesa.indexOf(p);
        }        
    }
    if(i!=-1){
        return this.CartasEnMesa.remove(i);
    }
    return null;
}
    private Carta Llevar(Carta Sel,Carta Allevar) {
        int n=-1;
        int p;
            if(jug2){
                p=2;                
            }else{
                p=1;
            }
            this.AumentarMonto(1,p);
        this.PilaCartas.addFirst(Allevar);
        for(Carta c:this.CartasEnMesa){
            if((c.num==(Allevar.num+1))&&n==-1){
                n=this.CartasEnMesa.indexOf(c);
            }
        }
        if(n!=-1){
            return Llevar(Sel,this.CartasEnMesa.remove(n));
        }
        this.PilaCartas.addFirst(Sel);
        this.PonerEnMesa(null);
        this.OrdenarPilaCartas();
        this.AumentarContador(2);
        if(this.CartasEnMesa.isEmpty()){
            this.AumentarContador(2);
        }
            this.AumentarMonto(1,p);
        return null;
    }
    private void LlevarSuma(Carta p1,Carta p1a,Carta p2) {
        int p;
        if(this.jug2){
            p=2;
        }else{
           p=1; 
        }
        this.AumentarMonto(3,p);
        this.PilaCartas.addFirst(p2);
        this.PilaCartas.addFirst(p1);
        this.PilaCartas.addFirst(p1a);
        this.PonerEnMesa(null);
        this.OrdenarPilaCartas();
        if(this.CartasEnMesa.isEmpty()){
            this.AumentarContador(2);
        }
    }
    private void AumentarContador(int i){
        if(this.jug2){
            try{
                this.bpuntos2.setText(String.valueOf(Integer.parseInt(this.bpuntos2.getText())+i));
            }catch(NumberFormatException ex){
                this.bpuntos2.setText(String.valueOf(i));
            }
             }else{
                 try{
                this.bpuntos1.setText(String.valueOf(Integer.parseInt(this.bpuntos1.getText())+i));
                }catch(NumberFormatException ex){
                    this.bpuntos1.setText(String.valueOf(i));
                }
             }
    }
    private void AumentarContador(int i,int p){
        if(p==2){
            try{
                this.bpuntos2.setText(String.valueOf(Integer.parseInt(this.bpuntos2.getText())+i));
            }catch(NumberFormatException ex){
                this.bpuntos2.setText(String.valueOf(i));
            }
             }else{
                 try{
                this.bpuntos1.setText(String.valueOf(Integer.parseInt(this.bpuntos1.getText())+i));
                }catch(NumberFormatException ex){
                    this.bpuntos1.setText(String.valueOf(i));
                }
             }
    }
    private void PonerEnMesa(Carta p) {
        if(p!=null){
            this.CartasEnMesa.add(p);
        }
        int k=300;
        int f=420;
        int d=(int)Math.floor(((double)(f-(CartasEnMesa.size()*CARTA_DIAMETER_X)))/((double)(CartasEnMesa.size()-1)));
        int i=0;
        for(Carta c:CartasEnMesa){
            c.x=k+((CARTA_DIAMETER_X+d)*i);
            c.y=300;
            c.setBounds(k+((CARTA_DIAMETER_X+d)*i), 300, CARTA_DIAMETER_X, CARTA_DIAMETER_Y);            
            i++;
            
        }
    }

    private void cargarImagenes() {
        Thread hilo = new Thread() {
            public void run() {
                try {
                    for(Carta c:Jugador1){
                        c.setIcon(c.Frente);
                        sleep(300);
                    }
                    for(Carta c:Jugador2){
                        c.setIcon(c.Frente);
                        sleep(300);
                    }

                } catch (Exception e) {
                }
            }
        };
        hilo.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(baraja)) {
            this.RepartirCartas(5);
            cargarImagenes();
            click++;
            if (click == 4) //para cuando termine las cartas
            {
                this.monto1.setText("   ");
                this.monto2.setText("   ");
                this.AumentarPuntXBaraja();
                c=0;
            }
        }


    }
    private void AumentarPuntXBaraja(){
        try{
            if(!(((Integer.parseInt(monto1.getText()))-14)<6)){
            this.AumentarContador(Jugador1.size()-14,1);
            }
        }catch(Exception e){
        }
        try{
            if(!(((Integer.parseInt(monto1.getText()))-14)<6)){
            this.AumentarContador(Jugador2.size()-14,2);
        }
        }catch(Exception e){ 
        }
        
        
    }
    private void AumentarMonto(int i,int player){
        if(player==1){
            try{
            this.monto1.setText(String.valueOf(Integer.parseInt(this.monto1.getText())+i));
            }catch(NumberFormatException ex){
                this.monto1.setText(String.valueOf(i));
            }
        }
        if(player==2){
           try{
            this.monto2.setText(String.valueOf(Integer.parseInt(this.monto2.getText())+i));
            }catch(NumberFormatException ex){
                this.monto2.setText(String.valueOf(i));
            } 
        }
    }
    
}//endclass DragBallPanel