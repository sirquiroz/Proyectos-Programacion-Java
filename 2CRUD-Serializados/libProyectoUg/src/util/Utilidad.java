package util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utilidad {

    public String getFecha() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy");
        String date = sdf.format(new Date());
        return date;
    }

    public String getHora() {
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
        String date = sdf.format(new Date());
        return date;
    }

    public String getFechaHora() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        String date = sdf.format(new Date());
        return date;
//        return getFecha() + " "+getHora();
    }
}
