package Interfaces;

import java.sql.PreparedStatement;
import java.util.ArrayList;

public interface ICRUD <T, U extends String>{
	ArrayList<?> getAll(U sqlQuery);
	ArrayList<?> getById(T objSelId, U sqlQuery);
	void Add(T objAdd, U sqlQuery);
	void Delete(T objDel, U sqlQuery);
	void Update(T objAdd, U sqlQuery);
}
