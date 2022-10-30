package se.anosh.gbstag.dao;

import java.io.IOException;

import se.anosh.gbstag.domain.GbsTag;

public class GbsFileImplementation implements GbsDao {
	
	private final GbsFileReader gbsFile;

	public GbsFileImplementation(String filename) throws IOException {
		gbsFile = new GbsFileReader(filename);
	}

	public GbsTag read() throws IOException {
		return gbsFile.getTags();
	}

}
