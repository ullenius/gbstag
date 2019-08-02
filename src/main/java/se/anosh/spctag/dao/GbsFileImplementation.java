package se.anosh.spctag.dao;

import java.io.FileNotFoundException;
import java.io.IOException;

public class GbsFileImplementation implements SpcDao {
	
	private GbsFileReader gbsFile;

	
	public GbsFileImplementation(String filename) throws FileNotFoundException, IOException {
		gbsFile = new GbsFileReader(filename);
	}
	
	
	@Override
	public Id666 read() throws FileNotFoundException, IOException {
		
		return gbsFile.getId666();
		
	}

	@Override
	public void update(String song) {
		throw new UnsupportedOperationException("not yet implemented");

	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException("not yet implemented");

	}

}
