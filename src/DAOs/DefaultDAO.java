package DAOs;

import java.util.ArrayList;

public abstract class DefaultDAO {
	protected int Id;

	public abstract ArrayList<?> getAll();
	public abstract ArrayList<?> getById(int Id);
	public abstract void Add(int Id);
	public abstract void Delete(int Id);
	public abstract void Update(int Id);
	

}
