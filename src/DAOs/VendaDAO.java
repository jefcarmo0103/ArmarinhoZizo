package DAOs;

import Interfaces.ICalculate;
import Models.Produto;

import java.util.List;

public class VendaDAO implements ICalculate {
    @Override
    public double calculaPrecoFinal(List<Produto> produtos) {
        return 0;
    }
}
