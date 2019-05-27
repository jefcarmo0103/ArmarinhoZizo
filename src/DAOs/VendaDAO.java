package DAOs;

import Interfaces.ICalculate;
import Models.Compra;
import Models.DefaultModel;
import Models.Produto;
import Models.Venda;

import java.sql.Date;
import java.util.*;

public class VendaDAO extends DefaultDAO  {
	private String table = "Venda";

    @Override
    public void Adiciona(DefaultModel model) {
    	Map<Integer, Object> parameters = getParameters(model);
        crud.Add(parameters, getInsert());		

    }

    @Override
    public void Altera(DefaultModel model) {
    	Map<Integer, Object> parameters = getParameters(model);
        crud.Add(parameters, getUpdate());

    }

    @Override
    public void Exclui(DefaultModel model) {
    	Map<Integer, Object> parameters = getParameters(model);
        crud.Add(parameters, getDelete());

    }

    @Override
    public ArrayList SelecionarTodos() {
        return null;
    }

    @Override
    public Map getParameters(DefaultModel model) {
    	Map<Integer, Object> params = new HashMap<Integer, Object>();

        Venda venda = (Venda) model;

        params.put(1, new Date(venda.getDataVenda().getTimeInMillis()));
        params.put(2, venda.getPrecoTotal());
        return params;
    }

    @Override
    public String getInsert() {
    	return String.format("insert into %s values (?,?,?,?)", table);
    }

    @Override
    public String getDelete() {
    	return String.format("delete from %s where ID_VENDA = ?", table);
    }

    @Override
    public String getSelectAll() {
		return String.format("select * from %s", table);
    }

    @Override
    public String getSelectById() {
        return String.format("select * from %s where ID_VENDA = ?", table);
    }

    @Override
    public String getUpdate() {
        return String.format("update %s set DATA_VENDA = ?, VALOR_TOTAL = ?" +
                "where ID_VENDA = ?", table);
    }
}
