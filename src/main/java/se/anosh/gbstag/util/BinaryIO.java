package se.anosh.gbstag.util;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Objects;

public final class BinaryIO {
	
	/*
	 * Helper class for low-level binary I/O
	 * Only static methods
	 */
	
	private BinaryIO() {
		throw new AssertionError("This should never happen"); // prevents instantiation
	}
	
	public static String readStuff(final RandomAccessFile raf, final int offset, final int length) throws IOException {
		raf.seek(offset);
		byte[] bytes = new byte[length];
		raf.read(bytes);
		return new String(bytes, "ISO-8859-1");
	}

}
