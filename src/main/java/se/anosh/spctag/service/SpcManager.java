package se.anosh.spctag.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;

import se.anosh.spctag.dao.GbsTag;
import se.anosh.spctag.dao.Id666;
import se.anosh.spctag.dao.GbsDao;

public class SpcManager implements SpcService<GbsTag> {
	
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
