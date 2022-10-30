package se.anosh.gbstag.service;

import java.io.IOException;
import java.util.Objects;

import se.anosh.gbstag.dao.GbsDao;
import se.anosh.gbstag.domain.GbsTag;

public final class GbsManager implements GbsService {
	
	private final GbsDao dao;
	
	// dependency injection
	public GbsManager(GbsDao dao) {
		this.dao = Objects.requireNonNull(dao);
	}

	@Override
	public GbsTag read() throws IOException {
		return dao.read();
	}

}
