package DAOs;

import Models.Compra;
import Models.DefaultModel;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Dictionary;

public class CompraDAO extends DefaultDAO {
    private String table = "compra";


	@Override
	public void Adiciona(DefaultModel model) {
		Dictionary<Integer, Object> parameters = getParameters(model);
        crud.Add(parameters, getInsert());		
	}

	@Override
	public void Altera(DefaultModel model) {
		Dictionary<Integer, Object> parameters = getParameters(model);
        crud.Update(parameters, getInsert());		
		
	}

	@Override
	public void Exclui(DefaultModel model) {
		Dictionary<Integer, Object> parameters = getParameters(model);
        crud.Delete(parameters, getInsert());					
	}

	@Override
	public ArrayList<Compra> SelecionarTodos() {
		return null;
	}

	@Override
	public Dictionary getParameters(DefaultModel model) {
		Dictionary<Integer, Object> params = null;

        Compra compra = (Compra) model;

        params.put(1, compra.getValorTotal());
        params.put(2, new Date(compra.getDataCompra().getTimeInMillis()));
        return params;
	}

	@Override	
	public String getInsert() {
		return String.format("insert into %s values (?,?,?,?)", table);
	}

	@Override
	public String getDelete() {
		return String.format("delete from %s where ID_COMPRA = ?", table);
	}

	@Override
	public String getSelectAll() {
		return String.format("select * from %s", table);
	}

	@Override
	public String getSelectById() {
		return String.format("select * from %s where ID_COMPRA = ?", table);
	}

	@Override
	public String getUpdate() {
		return String.format("update %s set VALOR_TOTAL = ?, DATA_COMPRA = ?" +
                "where ID_COMPRA = ?", table);
	}
}
