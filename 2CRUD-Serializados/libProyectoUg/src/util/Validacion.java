package util;

import java.awt.Toolkit;
import javax.swing.JTextField;

public class Validacion {
    
    public boolean camposLlenos(JTextField campos[]){
        for (JTextField txt : campos) {
            if(txt.getText().trim().length()<2){
                txt.requestFocus();
                return false;
            }
        }
        return true;
    }
    
    public void soloNumero(java.awt.event.KeyEvent evt){
        int car = evt.getKeyChar();
        if(car < 48 || car > 57){
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }
    public void soloLetra(java.awt.event.KeyEvent evt){
        int car = evt.getKeyChar();
        if((car < 'A' || car > 'z') && car !=' '){
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }
    public boolean validaPlaca(String txt){
        
        //String exp = "[G][A-Z]{2}\\-[0-9]{4}";
        String exp = "[G][A-Z]{2}\\-[0-9]{4}";
        
        
        return txt.matches(exp);
        
    }
    public boolean validaCedula(String txt){
        
        //String exp = "[G][A-Z]{2}\\-[0-9]{4}";
        String exp = "[01][0-9]{9}";
        
        
        return txt.matches(exp);
        
    }
    
}
