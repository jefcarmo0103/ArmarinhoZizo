package Models;

public class Fornecedor extends DefaultModel {

    public String NomeFornecedor;
    public String CNPJ;
    public String Email;
    public String Telefone;
    public String Contato;

    public Fornecedor(){}
    public Fornecedor(String nome_fornecedor, String cnpj, String email, String telefone, String contato ){
        NomeFornecedor = nome_fornecedor;
        CNPJ = cnpj;
        Email = email;
        Telefone = telefone;
        Contato = contato;
    }

    public String getNomeFornecedor() {
        return NomeFornecedor;
    }

    public void setNomeFornecedor(String nomeFornecedor) {
        NomeFornecedor = nomeFornecedor;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String telefone) {
        Telefone = telefone;
    }

    public String getContato() {
        return Contato;
    }

    public void setContato(String contato) {
        Contato = contato;
    }

}

