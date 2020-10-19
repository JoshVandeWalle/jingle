package com.jingle.data;

/**
 * @author Henry Harvey
 * The DataServiceInterface establishes the required methods for data services
 */

public interface DataServiceInterface<T> {

	/**
	 * Takes in an object
	 * Connects to the database
	 * Creates and executes a sql statement
	 * Returns an int indicating result
	 * 
	 * @param t		object to be added to the database
	 * @return int	int result
	 */
	public int create(T t);

	/**
	 * Takes in an object
	 * Connects to the database
	 * Creates and executes a sql statement
	 * Sets an object equal to the result set
	 * Returns the object
	 * 
	 * @param t		object to find
	 * @return t	object that is found
	 */
	public T read(T t);

	/**
	 * Takes in an object
	 * Connects to the database
	 * Creates and executes a sql statement
	 * Returns an int indicating result
	 * 
	 * @param t		object to be updated
	 * @return int	int result
	 */
	public int update(T t);

	/**
	 * Takes in an object
	 * Connects to the database
	 * Creates and executes a sql statement
	 * Returns an int indicating result
	 * 
	 * @param t		object to be deleted
	 * @return int	int result
	 */
	public int delete(T t);

}
