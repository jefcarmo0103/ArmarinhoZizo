package Models;

import java.util.*;

public class Compra extends DefaultModel{
    public Date DataCompra;
    public double ValorTotal;

    public Compra(){}
    public Compra(Date data_compra, double valor_total){
        DataCompra = data_compra;
        ValorTotal = valor_total;
    }

    public Date getDataCompra() {
        return DataCompra;
    }

    public void setDataCompra(Date dataCompra) {
        DataCompra = dataCompra;
    }

    public double getValorTotal() {
        return ValorTotal;
    }

    public void setValorTotal(double valorTotal) {
        ValorTotal = valorTotal;
    }
}
