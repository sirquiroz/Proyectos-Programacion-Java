
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class ejemplo extends JFrame implements ActionListener {
    JTextField txt1;
    JLabel lbl1;
    JButton btn1;
    public ejemplo() {
        setTitle("conversion");
        txt1 = new JTextField();
        txt1.setBounds(0, 0, 100, 30);
        lbl1 = new JLabel("aa");
        btn1 = new JButton("Conver");
        
        btn1.setBounds(100, 100, 100, 25);
        lbl1.setBounds(200, 200, 1000, 25);
        add(txt1);
        add(lbl1);
        add(btn1);
        btn1.addActionListener(this);
        setLayout(null);
        setVisible(true);
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
                
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int num = Integer.parseInt(txt1.getText().trim());
        int mil = num/1000;
        String letras="";
        if(mil>0){
            switch(mil){
                case 1: letras+="Mil "; break;
                case 2: letras+="dosMil "; break;
                case 3: letras+="tresMil "; break;
                case 4: letras+="cuatroMil "; break;
                case 5: letras+="cincoMil "; break;
                case 6: letras+="seisMil "; break;
                case 7: letras+="sieteMil "; break;
                case 8: letras+="ochoMil "; break;
                case 9: letras+="nueveMil "; break;
            }
            num=num%1000;       
        }//mil
        System.out.println(""+num);
        int cen = num/100;
        
        if(cen>0){
            switch(cen){
                case 1: letras+="cien "; break;
                case 2: letras+="dosciento "; break;
                case 3: letras+="tresciento "; break;
                case 4: letras+="cuatrociento "; break;
                case 5: letras+="quiniento "; break;
                case 6: letras+="seisciento "; break;
                case 7: letras+="sieteciento "; break;
                case 8: letras+="ochociento "; break;
                case 9: letras+="nueveciento "; break;
            }
            num=num%100;       
        }//mil
        int dec = num/10;
         if(dec>0){
            switch(dec){
                case 1: letras+="cien "; break;
                case 2: letras+="veinte "; break;
                case 3: letras+="treinta "; break;
                case 4: letras+="cuarenta "; break;
                case 5: letras+="cincuenta "; break;
                case 6: letras+="sesenta "; break;
                case 7: letras+="setenta "; break;
                case 8: letras+="ochenta "; break;
                case 9: letras+="noventa "; break;
            }
            num=num%10;       
        }//mil
        int uni = num;
         if(uni>0){
            switch(uni){
                case 1: letras+="uno "; break;
                case 2: letras+="dos "; break;
                case 3: letras+="tres "; break;
                case 4: letras+="cuatro "; break;
                case 5: letras+="cinco "; break;
                case 6: letras+="seis "; break;
                case 7: letras+="siete"; break;
                case 8: letras+="ocho "; break;
                case 9: letras+="nueve "; break;
            }
        }//mil
         lbl1.setText(letras);
    }
    public static void main(String[] args) {
        ejemplo obj = new ejemplo();
    }
    
    
}
