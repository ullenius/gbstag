package se.anosh.gbstag.service;

import java.io.FileNotFoundException;
import java.io.IOException;

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
