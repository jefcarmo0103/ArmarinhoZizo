package DAOs;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.*;

import Interfaces.ICalculate;
import Models.Cliente;
import Models.DefaultModel;
import Models.Produto;
import Util.ValidateDouble;
import Util.ValidateInteger;

public class ProdutoDAO extends DefaultDAO {
    private String table = "PRODUTO";

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
	public ArrayList SelecionarTodos() throws NoSuchFieldException, IllegalAccessException {
		Map<String,Object> result = (Map<String,Object>)crud.getAll(getSelectAll());
		Class<? extends Produto> clazz = new Produto().getClass();
		ArrayList<Produto> resposta = new ArrayList<>();
		Field[] campos = clazz.getFields();

		if(result.size() == 0)
			return resposta;

		int x = 0,i = 0;
		Produto produto = new Produto();
		int count = 0;

		while (x < result.size()){

			String campo = campos[i].getName().toUpperCase().concat("_" + table + count);
			count++;
			Object o = result.get(campo);
			Field field = clazz.getDeclaredField(campos[i].getName());

			if(ValidateInteger.isIntegerValid((String)o))
				field.set(produto,ValidateInteger.returnIntegerValid((String)o));
			else if(ValidateDouble.isDoubleValid((String)o))
				field.set(produto,ValidateDouble.returnDoubleValid((String)o));
			else
				field.set(produto,o);

			i++;
			x++;

			if(i >= 3){
				resposta.add(produto);
				produto = new Produto();
				i = 0;
			}
		}

		return resposta;
	}

	@Override
	public Map getParameters(DefaultModel model) {
		Map<Integer, Object> params = new HashMap<Integer, Object>();

        Produto produto = (Produto) model;

        params.put(1, produto.getNomeProduto());
        params.put(2, produto.getPrecoUnitario());

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
