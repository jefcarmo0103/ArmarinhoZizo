package DAOs;

import Models.Cliente;
import Models.DefaultModel;
import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.*;

public class ClienteDAO extends DefaultDAO {
    private String table = "Cliente";

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

        int x = 0,i = 0;
        Cliente cliente = new Cliente();

        while (x < campos.length){


            String campo = campos[x].getName().toUpperCase().concat("_CLIENTE");
            Object o = result.get(campo);
            Field field = clazz.getDeclaredField(campos[x].getName());

            if(isThisDateValid((String)o)){
                Calendar data = Calendar.getInstance();

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
                sdf.setLenient(false);

                Date date = sdf.parse((String)o);
                data.setTime(date);

                field.set(cliente,data);
            }
            else{
                field.set(cliente,o);
            }

            i++;
            x++;

            if(i >= 4){
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

    private boolean isThisDateValid(String dateToValidate){

        if(dateToValidate == null){
            return false;
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        sdf.setLenient(false);

        try {

            //if not valid, it will throw ParseException
            Date date = sdf.parse(dateToValidate);
            System.out.println(date);

        } catch (ParseException e) {

            e.printStackTrace();
            return false;
        }

        return true;
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
