package dao;

import java.util.List;

public interface Mapper<T> {
	public T select(int id); 
	public void insert(T model);
	public void delete(int id);
	public void update(int id, T model); 
	public List<T> liste(); 
}
