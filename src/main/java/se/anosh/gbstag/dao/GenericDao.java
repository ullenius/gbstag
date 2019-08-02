package se.anosh.gbstag.dao;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 
 * Defines CRUD-operations on the DAO
 * 
 * @author Anosh D. Ullenius <anosh@anosh.se>
 *
 */
public interface GenericDao<T> {
	
	public T read() throws FileNotFoundException, IOException;
	public void update(String song); //TODO change parameter name
	public void remove(); // remove all fields

}
