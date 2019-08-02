package se.anosh.spctag.dao;

import java.io.FileNotFoundException;
import java.io.IOException;

public class GbsFileImplementation {
	
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
