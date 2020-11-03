package com.jingle.data;

import java.util.List;

/**
 * @author Henry Harvey
 * The DataServiceInterface establishes the required methods for data services
 */

public interface DataAccessInterface<T> {

	public int create(T t);

	public T read(T t);

	public List<T> readAll();

	public int update(T t);

	public int delete(T t);

}
