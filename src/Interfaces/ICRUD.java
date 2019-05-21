package Interfaces;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Map;

public interface ICRUD <T, U extends String>{
	Map<?,?> getAll(U sqlQuery);
	Map<?,?> getById(T objSelId, U sqlQuery);
	void Add(T objAdd, U sqlQuery);
	void Delete(T objDel, U sqlQuery);
	void Update(T objAdd, U sqlQuery);
}
