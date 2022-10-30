package se.anosh.gbstag.dao;

import se.anosh.gbstag.domain.GbsTag;

import java.io.IOException;

public interface GbsDao {
	GbsTag read() throws IOException;
}
