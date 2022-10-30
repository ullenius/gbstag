package se.anosh.gbstag.dao;

import se.anosh.gbstag.domain.GbsTag;

import java.io.IOException;

@FunctionalInterface
public interface GbsDao {
	GbsTag read() throws IOException;
}
