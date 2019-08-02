package se.anosh.gbstag.dao;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Objects;

public final class BinaryIO {
	
	/*
	 * Helper class for low-level binary I/O
	 */
	
	private BinaryIO() {
		throw new AssertionError("This should never happen");
	}
	
	public static String readStuff(RandomAccessFile raf, int offset, int length) throws IOException {
		raf.seek(offset);
		byte[] bytes = new byte[length];
		raf.read(bytes);
		return new String(bytes, "ISO-8859-1");
	}

	public static byte readByte(RandomAccessFile raf, int offset) throws IOException {
		raf.seek(offset);
		byte result = raf.readByte();
		return result;
	}

}
