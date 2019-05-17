package Models;

public class Produto extends DefaultModel {

    public String NomeProduto;
    public double PrecoUnitario;
    public int Quantidade;


    public Produto(){}
    public Produto(String nome_produto, double preco_unit){
        NomeProduto = nome_produto;
        PrecoUnitario = preco_unit;
    }

    public String getNomeProduto() {
        return NomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        NomeProduto = nomeProduto;
    }

    public double getPrecoUnitario() {
        return PrecoUnitario;
    }

    public void setPrecoUnitario(double precoUnitario) {
        PrecoUnitario = precoUnitario;
    }

    public int getQuantidade() {
        return Quantidade;
    }

    public void setQuantidade(int quantidade) {
        Quantidade = quantidade;
    }


}
