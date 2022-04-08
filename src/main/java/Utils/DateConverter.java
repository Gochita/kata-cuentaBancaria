package Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateConverter {

    public static final String format = "dd/MM/yyyy";

    public static Date date(String dateString){
        SimpleDateFormat formato = new SimpleDateFormat(format);
        Date fecha = null;
        try {
            fecha = formato.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return fecha;
    }

}
