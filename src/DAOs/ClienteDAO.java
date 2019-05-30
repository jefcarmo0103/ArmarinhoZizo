package DAOs;

import Models.Cliente;
import Models.DefaultModel;
import Util.ValidateDate;
import Util.ValidateInteger;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.*;

public class ClienteDAO extends DefaultDAO {
    private String table = "CLIENTE";

    public ClienteDAO(){
        super();
    }

    @Override
    public void Adiciona(DefaultModel model) {
        Map<Integer, Object> parameters = getParameters(model);
        crud.Add(parameters, getInsert());
    }

    @Override
    public void Altera(DefaultModel model) {
        Map<Integer, Object> parameters = getParameters(model);
    	crud.Update(parameters, getUpdate());
    }

    @Override
    public void Exclui(DefaultModel model) {
        Map<Integer, Object> parameters = getParameters(model);
    	crud.Delete(parameters, getDelete());
    }

    @Override
    public ArrayList<Cliente> SelecionarTodos() throws NoSuchFieldException, IllegalAccessException, ParseException {

        Map<String,Object> result = (Map<String,Object>)crud.getAll(getSelectAll());
        Class<? extends Cliente> clazz = new Cliente().getClass();
        ArrayList<Cliente> resposta = new ArrayList<>();
        Field[] campos = clazz.getDeclaredFields();


        if(result.size() == 0)
            return resposta;

        int x = 0,i = 0;
        Cliente cliente = new Cliente();

        while (x < result.size()){

            String campo = campos[i].getName().toUpperCase().concat("_" + table + x);
            Object o = result.get(campo);
            Field field = clazz.getDeclaredField(campos[i].getName());

            if(ValidateInteger.isIntegerValid((String)o)){

                int num = ValidateInteger.returnIntegerValid((String)o);
                field.set(cliente,num);

            }
            else if(ValidateDate.isThisDateValid((String)o)){
                Calendar data = ValidateDate.returnCalendarValid((String)o);
                field.set(cliente,data);
            }
            else{
                field.set(cliente,o);
            }

            i++;
            x++;

            if(i >= 5){
                resposta.add(cliente);
                cliente = new Cliente();
                i = 0;
            }
        }

        return resposta;
    }

    @Override
    public Map getParameters(DefaultModel model) {
        Map<Integer, Object> params = new HashMap<Integer, Object>();

        Cliente cliente = (Cliente) model;

        params.put(1, cliente.getNome());
        params.put(2, new Date(cliente.getData_Nasc().getTimeInMillis()));
        params.put(3, cliente.getEmail());
        params.put(4, cliente.getTelefone());

        return params;
    }




    @Override
    public String getInsert() {
        return String.format("insert into %s(NOME_CLIENTE, DATA_NASC_CLIENTE, EMAIL_CLIENTE, TELEFONE) values (?,?,?,?)", table);
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
