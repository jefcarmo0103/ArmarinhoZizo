package Views.component.utilcomp;

import Models.Produto;
import javafx.util.StringConverter;


public class ProdutoConverter extends StringConverter<Produto> {
    @Override
    public String toString(Produto p) {

        return p == null ? null: String.format("%s", p.Nome);

    }

    @Override
    public Produto fromString(String string) {
        Produto p = null;

        if(string == null)
            return p;

        String[] commaIndex = string.split(",");
        if(commaIndex.length == 0)
            p = new Produto();
        else{
            Double preco = Double.parseDouble(commaIndex[1]);
            p = new Produto(commaIndex[0], preco);
        }

        return p;

    }
}
