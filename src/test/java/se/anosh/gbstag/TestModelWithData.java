package se.anosh.gbstag;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import se.anosh.gbstag.dao.GbsFileImplementation;
import se.anosh.gbstag.dao.GbsDao;
import se.anosh.gbstag.domain.GbsTag;

public class TestModelWithData {

    public TestModelWithData() {
        super();
    }

    private GbsFileImplementation gbsFile;
    private GbsTag tag;
    private static final String FIRST_SAMPLE_FILE = "gbs/sample.gbs"; // Shantae
    private static final String SECOND_SAMPLE_FILE = "gbs/sample2.gbs"; // DK Land2

    private static final String GBS_HEADER = "GBS";

    @Before
    public void setup() throws IOException {
        gbsFile = new GbsFileImplementation(FIRST_SAMPLE_FILE);
        tag = gbsFile.read();
    }

    @Test
    public void testIdenticalHashCodes() throws IOException {
        GbsFileImplementation cloneFile = new GbsFileImplementation(FIRST_SAMPLE_FILE);
        GbsTag clone = cloneFile.read();

        assertNotSame(clone, tag);
        assertEquals(tag.hashCode(), clone.hashCode());
    }

    @Test
    public void testNotIdenticalHashCodes() throws IOException {
        GbsFileImplementation different = new GbsFileImplementation(SECOND_SAMPLE_FILE);
        GbsTag differentGbsTag = different.read();

        assertNotSame(differentGbsTag, tag);
        assertNotEquals(differentGbsTag, tag);
        assertNotEquals(differentGbsTag.hashCode(), tag.hashCode());
    }

    @Test
    public void testEqualObjects() throws IOException {
        GbsFileImplementation cloneFile = new GbsFileImplementation(FIRST_SAMPLE_FILE);
        GbsTag clone = cloneFile.read();

        assertNotSame(clone, tag);
        assertEquals(clone.hashCode(), tag.hashCode());
        assertEquals(clone, tag);
    }

    @Test
    public void testNonEqualObjects() throws IOException {
        GbsFileImplementation other = new GbsFileImplementation(SECOND_SAMPLE_FILE);
        GbsTag dkland = other.read();
        assertNotEquals(dkland, tag);
    }

    @Test
    public void testComparableSorting() throws IOException {
        final GbsFileImplementation otherFile = new GbsFileImplementation(SECOND_SAMPLE_FILE);
        final GbsTag other = otherFile.read();

        final List<GbsTag> expected = List.of(other, other, tag, tag);
        final List<GbsTag> actual = new LinkedList<>();
        actual.add(other);
        actual.add(tag);
        actual.add(other);
        actual.add(tag);
        actual.sort(null);

        assertEquals(expected, actual);
    }

    @Test
    public void testComparableWithNullValues() throws IOException {
        final GbsDao otherFile = new GbsFileImplementation(SECOND_SAMPLE_FILE); //accessing using the interface this time
        final GbsTag other = otherFile.read();

        other.setTitle(null);
        other.setAuthor(null);
        other.setCopyright(null);
        tag.setTitle(null);

        List<GbsTag> myList = new LinkedList<>();
        myList.add(tag);
        myList.add(other);

        myList.sort(null);

        assertNull(myList.get(0).getTitle());
        assertNull(myList.get(0).getAuthor());
        assertNull(myList.get(0).getCopyright());
        assertNull(myList.get(1).getTitle());
        assertNotNull(myList.get(1).getAuthor());
        assertNotNull(myList.get(1).getCopyright());
    }

    @Test
    public void testFileWithValidHeader() {
        // first 3 bytes of string should equal "GBS"
        final String headerWithoutVersionNumber = tag.getHeader();
        assertEquals(GBS_HEADER, headerWithoutVersionNumber); // case sensitive
    }

    @Test(expected = IOException.class)
    public void testFileWithInvalidHeader() throws IOException {
        gbsFile = new GbsFileImplementation("gbs/randomBytes.gbs");
    }

}
