package DAOs;

import Models.Cliente;
import Models.DefaultModel;
import javafx.collections.ObservableList;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
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
        crud.Add(parameters, getInsert());
    }

    @Override
    public void Altera(DefaultModel model) {
    	Dictionary<Integer, Object> parameters = getParameters(model);
    	crud.Update(parameters, getUpdate());
    }

    @Override
    public void Exclui(DefaultModel model) {
    	Dictionary<Integer, Object> parameters = getParameters(model);
    	crud.Delete(parameters, getDelete());
    }

    @Override
    public ArrayList<Cliente> SelecionarTodos() throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException {
        Map<String,Object> result = (Map<String,Object>)crud.getAll(getSelectAll());
        Class<? extends Cliente> clazz = new Cliente().getClass();
        ArrayList<Cliente> resposta = new ArrayList<>();
        Field[] campos = clazz.getDeclaredFields();

        for(int i = 0; i < result.size(); i++){
            Cliente cliente = new Cliente();
            for(int j = 0; j < campos.length; j++){
                String campo = campos[j].getName();
                Object o = result.get(campo);
                Field field = clazz.getDeclaredField(campos[j].getName());
                field.set(cliente,o);
            }
            resposta.add(cliente);
        }
        return resposta;
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
    public String getSelectById() {
        return String.format("select * from %s where ID_CLIENTE = ?", table);
    }

    @Override
    public String getUpdate() {
        return String.format("update %s set NOME_CLIENTE = ?, DATA_NASC_CLIENTE = ?, EMAIL_CLIENTE = ?, " +
                "TELEFONE = ? where ID_CLIENTE = ?", table);
    }

}
