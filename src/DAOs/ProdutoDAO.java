package DAOs;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;

import Interfaces.ICalculate;
import Models.Cliente;
import Models.DefaultModel;
import Models.Produto;

public class ProdutoDAO extends DefaultDAO {
    private String table = "produto";

	@Override
	public void Adiciona(DefaultModel model) {
		Map<Integer, Object> parameters = getParameters(model);
		crud.Add(parameters, getInsert());
		
	}

	@Override
	public void Altera(DefaultModel model) {
		Map<Integer, Object> parameters = getParameters(model);
		crud.Update(parameters, getInsert());
		
	}

	@Override
	public void Exclui(DefaultModel model) {
		Map<Integer, Object> parameters = getParameters(model);
		crud.Delete(parameters, getDelete());
		
	}

	@Override
	public ArrayList SelecionarTodos() {
		return null;
	}

	@Override
	public Map getParameters(DefaultModel model) {
		Map<Integer, Object> params = new HashMap<Integer, Object>();

        Produto produto = (Produto) model;

        params.put(1, produto.getNomeProduto());
        params.put(2, produto.getPrecoUnitario());
        params.put(3, produto.getQuantidade());

        return params;
	}

	@Override
	public String getInsert() {
		return String.format("insert into %s values (?,?,?,?)", table);
	}

	@Override
	public String getDelete() {
		return String.format("delete from %s where ID_PRODUTO = ?", table);
	}

	@Override
	public String getSelectAll() {
		return String.format("select * from %s", table);
	}

	@Override
	public String getSelectById() {
		return String.format("select * from %s where ID_PRODUTO = ?", table);
	}

	@Override
	public String getUpdate() {
		return String.format("update %s set NOME_PRODUTO = ?, PRECO_UNITARIO = ?, QUANTIDADE = ? " +
                "where ID_PRODUTO = ?", table);
	}
	
	

		
}
