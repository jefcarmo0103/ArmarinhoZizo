package Views.component.utilcomp;

import Models.Cliente;
import javafx.util.StringConverter;

public class ClienteConverter extends StringConverter<Cliente> {
    @Override
    public String toString(Cliente c) {

        String res = String.format("%s, %s, %s, %3$tY-%3$tm-%3$te", c.Nome, c.Email, c.Telefone, c.Data_Nasc);
        return c == null ? null: res;


    }

    @Override
    public Cliente fromString(String string) {
        Cliente c = null;

        if(string == null)
            return  c;

        String[] commaIndex = string.split(",");
        if(commaIndex.length == 0)
            c = new Cliente();
        else{
            //c = new Cliente(commaIndex[0], commaIndex[3])
        }

        return c;

    }
}
