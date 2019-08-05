package se.anosh.gbstag.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;

import se.anosh.gbstag.dao.GenericDao;
import se.anosh.gbstag.domain.GbsTag;

public class GbsManager implements GenericService<GbsTag> {
	
	private GenericDao<GbsTag> dao;
	
	// dependency injection
	public GbsManager(GenericDao<GbsTag> dao) {
		this.dao = Objects.requireNonNull(dao);
	}

	@Override
	public GbsTag read() throws FileNotFoundException, IOException {
		
		return dao.read();
	}

	@Override
	public void delete() {
		dao.remove();
	}

	@Override
	public void update(String song) {
		dao.update(song);
		
	}

}
