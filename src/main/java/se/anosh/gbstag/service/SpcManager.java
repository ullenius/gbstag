package se.anosh.gbstag.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;

import se.anosh.gbstag.dao.GbsDao;
import se.anosh.gbstag.dao.GbsTag;
import se.anosh.gbstag.dao.Id666;

public class SpcManager implements GenericService<GbsTag> {
	
	private GbsDao dao;
	
	// dependency injection
	public SpcManager(GbsDao dao) {
		this.dao = Objects.requireNonNull(dao);
	}

	@Override
	public GbsTag read() throws FileNotFoundException, IOException {
		
		return dao.read();
	}

	@Override
	public void deleteSpcTags() {
		dao.remove();
	}

	@Override
	public void update(String song) {
		dao.update(song);
		
	}

}
