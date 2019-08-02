package se.anosh.gbstag.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

import se.anosh.gbstag.domain.GbsTag;
import se.anosh.gbstag.util.BinaryIO;

public class GbsFileReader {
	
	// Includes identifier string and version number
	public static final int HEADER_OFFSET = 0;
	public static final int HEADER_LENGTH = 0x4;

	public static final int TITLE_OFFSET = 0x10;
	public static final int TITLE_LENGTH = 32;

	public static final int AUTHOR_OF_SONG_OFFSET = 0x30;
	public static final int AUTHOR_OF_SONG_LENGTH = 32;
	
	public static final int COPYRIGHT_OFFSET = 0x50;
	public static final int COPYRIGHT_LENGTH = 32;
	
	private GbsTag tags;
	private Path file;
	private RandomAccessFile raf;


	public GbsTag getTags() {
		Objects.requireNonNull(tags, "tags cannot be null!");
		return this.tags;
	}

	// Constructor
	public GbsFileReader(String filename) throws FileNotFoundException, IOException {

		file = Paths.get(filename);
		raf = new RandomAccessFile(file.toString(),"r");
		tags = new GbsTag();
		
		readAndSetAllFields();

		raf.close();
	}

	private void readAndSetAllFields() throws FileNotFoundException, IOException {

		readHeader();
		readTitle();
		readAuthor();
		readCopyright();
		
	}
	
	private void readHeader() throws IOException {
		tags.setHeader(readStuff(HEADER_OFFSET, HEADER_LENGTH).trim()); // removes NULL character
	}
	
	private void readTitle() throws IOException {
		tags.setTitle(readStuff(TITLE_OFFSET, TITLE_LENGTH).trim());
	}
	
	private void readAuthor() throws IOException {
		tags.setAuthor(readStuff(AUTHOR_OF_SONG_OFFSET, AUTHOR_OF_SONG_LENGTH).trim());
	}
	
	private void readCopyright() throws IOException {
		tags.setCopyright(readStuff(COPYRIGHT_OFFSET, COPYRIGHT_LENGTH).trim());
	}
	
	
	private String readStuff(int offset, int length) throws IOException {
		
		return BinaryIO.readStuff(raf,offset,length);
	}

}
