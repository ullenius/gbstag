package se.anosh.gbstag.dao;

import java.io.FileNotFoundException;
import java.io.IOException;

import se.anosh.gbstag.domain.GbsTag;

public class GbsFileImplementation implements GenericDao<GbsTag> {
	
	private GbsFileReader gbsFile;

	
	public GbsFileImplementation(String filename) throws FileNotFoundException, IOException {
		gbsFile = new GbsFileReader(filename);
	}
	
	
	public GbsTag read() throws FileNotFoundException, IOException {
		
		return gbsFile.getTags();
		
	}

	public void update(String song) {
		throw new UnsupportedOperationException("not yet implemented");

	}

	public void remove() {
		throw new UnsupportedOperationException("not yet implemented");

	}

}
