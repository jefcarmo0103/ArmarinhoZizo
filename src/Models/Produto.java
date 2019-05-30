package Models;

public class Produto extends DefaultModel {

    public int Id;
    public String Nome;
    public double PrecoUnitario;


    public Produto(){}
    public Produto(String nome_produto, double preco_unit){
        Nome = nome_produto;
        PrecoUnitario = preco_unit;
    }

    public String getNomeProduto() {
        return Nome;
    }

    public void setNomeProduto(String nomeProduto) {
        Nome = nomeProduto;
    }

    public double getPrecoUnitario() {
        return PrecoUnitario;
    }

    public void setPrecoUnitario(double precoUnitario) {
        PrecoUnitario = precoUnitario;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }





}
