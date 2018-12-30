package dao;

import java.util.List;

public interface Mapper<T> {
<<<<<<< HEAD
	public T select(int id); 
	public void insert(T model);
	public void delete(int id);
	public void update(int id, T model); 
	public List<T> liste(); 
=======
	public T select(int id);

	public boolean insert(T model);

	public boolean delete(int id);

	public boolean update(int id, T model);

	public List<T> liste();
>>>>>>> 59e2b1d616b834a9a51e13644ef0736b6d96a8d7
}
