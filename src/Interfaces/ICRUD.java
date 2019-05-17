package Interfaces;

import java.util.ArrayList;

public interface ICRUD {
	ArrayList<?> getAll();
	ArrayList<?> getById(int Id);
	void Add(int Id);
	void Delete(int Id);
	void Update(int Id);
}
