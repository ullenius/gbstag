package se.anosh.gbstag;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;

import org.junit.Test;

import se.anosh.gbstag.util.BinaryIO;

public class TestUtf8Reading {

	private static final String HEART_EMOJI;
	private static final byte[] heart;
	
	static {
		HEART_EMOJI = "❤️";
		heart = HEART_EMOJI.getBytes(StandardCharsets.UTF_8);
	}
	
	@Test
	public void testReadingOfUtf8EncodedStringsFromBinary() {
		try {
			// Stubbing RandomAccessFile to mock return value
			String result = BinaryIO.readString(new RandomAccessFile("gbs/sample.gbs","r") {
				@Override
				public void seek(long pos) {
					// do nothing
				}
				@Override
				public int read(byte[] b) throws IOException {
					System.arraycopy(heart, 0, b, 0, heart.length);
					return heart.length;
			}},1234,56); // dummy numbers, doesn't affect anything
			result = result.trim(); // this is done by GbsFileReader. BinaryIO returns the raw byte values (with null-characters)
			System.out.println("String heart = " + HEART_EMOJI);
			System.out.println("byte heart = " + result);
			assertEquals(HEART_EMOJI,result);
			
		} catch (IOException e) {
			fail();
		}
	}
	

}
