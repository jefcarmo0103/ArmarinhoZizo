package Views.component.utilcomp;

import Models.Cliente;
import javafx.util.StringConverter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ClienteConverter extends StringConverter<Cliente> {
    @Override
    public String toString(Cliente c) {

        return c == null ? null: String.format("%s", c.Nome);

    }

    @Override
    public Cliente fromString(String string) {
        Cliente c = null;

        if(string == null)
            return c;

        String[] commaIndex = string.split(",");
        if(commaIndex.length == 0)
            c = new Cliente();
        else{

            Calendar cal = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
            sdf.setLenient(false);

            Date date = null;
            try {
                date = sdf.parse(commaIndex[3]);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            cal.setTime(date);

            c = new Cliente(commaIndex[0], commaIndex[1], commaIndex[2], cal);
        }

        return c;

    }
}
