package dao;

import java.util.List;

public interface Mapper<T> {
	public T select(int id);

	public boolean insert(T model);

	public boolean delete(int id);

	public boolean update(int id, T model);

	public List<T> liste();
}
