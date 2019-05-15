package Models;

import java.util.*;

public class Venda extends DefaultModel {

    public Date DataVenda;
    public double PrecoTotal;
    public Cliente Consumidor;

    public Venda(){}
    public Venda(Date data_venda, double preco_total, Cliente cliente){
        DataVenda = data_venda;
        PrecoTotal = preco_total;
        Consumidor = cliente;
    }

    public Date getDataVenda() {
        return DataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        DataVenda = dataVenda;
    }

    public double getPrecoTotal() {
        return PrecoTotal;
    }

    public void setPrecoTotal(double precoTotal) {
        PrecoTotal = precoTotal;
    }

}
