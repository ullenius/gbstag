package se.anosh.gbstag.util;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;

public final class BinaryIO {

    private BinaryIO() {
        throw new AssertionError("This class cannot be instantiated");
    }

    public static String readString(final RandomAccessFile raf, final int offset, final int length) throws IOException {
        raf.seek(offset);
        byte[] bytes = new byte[length];
        raf.read(bytes);
        return new String(bytes, StandardCharsets.UTF_8);
    }

    public static byte readByte(final RandomAccessFile raf, final int offset) throws IOException {
        raf.seek(offset);
        return raf.readByte();
    }

}