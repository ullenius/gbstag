package se.anosh.gbstag.service;

import java.io.FileNotFoundException;
import java.io.IOException;

import se.anosh.gbstag.dao.Id666;

/**
 * 
 * Service layer
 * 
 * @author Anosh D. Ullenius <anosh@anosh.se>
 *
 */
public interface GenericService<T> {
	
	public T read() throws FileNotFoundException, IOException;
	public void deleteSpcTags();
	public void update(String song);
	

}
