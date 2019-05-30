package Models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.*;

public class Venda extends DefaultModel {

    public Calendar DataVenda;
    public double PrecoTotal;
    private int codigo;
    private Cliente cliente;

	public Venda(){

        this.codigo = 0;
        this.itens = FXCollections.observableArrayList();
        this.itensRemover = FXCollections.observableArrayList();

    }
    public Venda(Calendar data_venda, double preco_total, Cliente cliente){
        DataVenda = data_venda;
        PrecoTotal = preco_total;
        this.cliente = cliente;
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


    private ObservableList<ItemVenda> itens;
    private ObservableList<ItemVenda> itensRemover;


    public Venda(int codigo) {
        this.codigo = codigo;
        this.itens = FXCollections.observableArrayList();
        this.itensRemover = FXCollections.observableArrayList();

    }

    public int getCodigo() {
        return codigo;
    }



    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }



    public double getValorTotal() {
        double total = 0;
        for (ItemVenda iv : itens) {
            total += (iv.getValorUnitario() * iv.getQuantidade());
        }
        return total;
    }


    public ObservableList<ItemVenda> getItens() {
        return itens;
    }

    public ObservableList<ItemVenda> getItensRemover() {
        return itensRemover;
    }

    public void addItem(ItemVenda itemVenda) {
        itens.add(itemVenda);
    }

    public void removeItem(ItemVenda itemVenda) {
        itens.remove(itemVenda);
        if (itemVenda.getCodigo() != 0) {
            itensRemover.add(itemVenda);
        }
    }

    public int quantidadeItens() {
        return itens.size();
    }

    @Override
    public String toString() {
        return String.valueOf(this.codigo);
    }

    public class ItemVenda {

        private int codigo;
        private Produto produto;
        private int quantidade;
        private double valorUnitario;

        public ItemVenda() {
            this.codigo = 0;
        }

        public ItemVenda(int codigo) {
            this.codigo = codigo;
        }

        public int getCodigo() {
            return codigo;
        }

        public void setCodigo(int codigo) {
            this.codigo = codigo;
        }

        public Produto getProduto() {
            return produto;
        }

        public void setProduto(Produto produto) {
            this.produto = produto;
        }

        public int getQuantidade() {
            return quantidade;
        }

        public void setQuantidade(int quantidade) {
            this.quantidade = quantidade;
        }

        public double getValorUnitario() {
            return valorUnitario;
        }

        public void setValorUnitario(double valorUnitario) {
            this.valorUnitario = valorUnitario;
        }

        public double getSubtotal() {
            return valorUnitario * quantidade;
        }

        @Override
        public boolean equals(Object obj) {
            if(obj instanceof ItemVenda){
                ItemVenda i = (ItemVenda) obj;
                return i.getCodigo() == getCodigo();
            }
            return false;
        }
    }

}
