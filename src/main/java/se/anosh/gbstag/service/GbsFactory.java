package se.anosh.gbstag.service;

import se.anosh.gbstag.dao.GbsDao;
import se.anosh.gbstag.dao.GbsDaoImpl;

import java.io.IOException;

public final class GbsFactory {

    private GbsFactory() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static GbsService of(String file) throws IOException {
        GbsDao dao = new GbsDaoImpl(file);
        return new GbsManager(dao);
    }

}
