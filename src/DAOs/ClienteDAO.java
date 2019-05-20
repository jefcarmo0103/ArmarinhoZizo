package DAOs;

import Models.Cliente;
import Models.DefaultModel;
import java.util.*;
import java.sql.Date;

public class ClienteDAO extends DefaultDAO {
    private String table = "Cliente";

    public ClienteDAO(){
        super();
    }

    @Override
    public void Adiciona(DefaultModel model) {
        Dictionary<Integer, Object> parameters = getParameters(model);
    }

    @Override
    public void Altera(DefaultModel model) {

    }

    @Override
    public void Exclui(DefaultModel model) {

    }

    @Override
    public Dictionary getParameters(DefaultModel model) {
        Dictionary<Integer, Object> params = null;

        Cliente cliente = (Cliente) model;

        params.put(1, cliente.getNome());
        params.put(2, new Date(cliente.getData_Nasc().getTimeInMillis()));
        params.put(3, cliente.getEmail());
        params.put(4, cliente.getTelefone());

        return params;
    }


    @Override
    public String getInsert() {
        return String.format("insert into %s values (?,?,?,?)", table);
    }

    @Override
    public String getDelete() {
        return String.format("delete from %s where ID_CLIENTE = ?", table);
    }

    @Override
    public String getSelectAll() {
        return String.format("select * from %s", table);
    }

    @Override
    public String getUpdate() {
        return String.format("update %s set NOME_CLIENTE = ?, DATA_NASC_CLIENTE = ?, EMAIL_CLIENTE = ?, " +
                "TELEFONE = ? where ID_CLIENTE = ?", table);
    }

}
