package se.anosh.gbstag.service;

import se.anosh.gbstag.domain.GbsTag;

import java.io.IOException;
public interface GbsService {
    GbsTag read() throws IOException;

}
