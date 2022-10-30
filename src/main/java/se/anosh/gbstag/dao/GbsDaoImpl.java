package se.anosh.gbstag.dao;

import java.io.IOException;

import se.anosh.gbstag.domain.GbsTag;

public final class GbsDaoImpl implements GbsDao {
	
	private final GbsFileReader gbsFile;

	public GbsDaoImpl(String filename) throws IOException {
		gbsFile = new GbsFileReader(filename);
	}

	public GbsTag read() throws IOException {
		return gbsFile.getTags();
	}

}
