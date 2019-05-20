package Models;

import java.util.*;

public class Venda extends DefaultModel {

    public Calendar DataVenda;
    public double PrecoTotal;
    public Cliente Consumidor;

    public Venda(){}
    public Venda(Calendar data_venda, double preco_total, Cliente cliente){
        DataVenda = data_venda;
        PrecoTotal = preco_total;
        Consumidor = cliente;
    }

    public Calendar getDataVenda() {
        return DataVenda;
    }

    public void setDataVenda(Calendar dataVenda) {
        DataVenda = dataVenda;
    }

    public double getPrecoTotal() {
        return PrecoTotal;
    }

    public void setPrecoTotal(double precoTotal) {
        PrecoTotal = precoTotal;
    }

}
