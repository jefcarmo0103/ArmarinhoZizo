package Models;

import java.util.*;

public class Compra extends DefaultModel{
    public Calendar DataCompra;
    public double ValorTotal;

    public Compra(){}
    public Compra(Calendar data_compra, double valor_total){
        DataCompra = data_compra;
        ValorTotal = valor_total;
    }

    public Calendar getDataCompra() {
        return DataCompra;
    }

    public void setDataCompra(Calendar dataCompra) {
        DataCompra = dataCompra;
    }

    public double getValorTotal() {
        return ValorTotal;
    }

    public void setValorTotal(double valorTotal) {
        ValorTotal = valorTotal;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int Id;
}
