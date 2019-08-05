package se.anosh.gbstag;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import se.anosh.gbstag.dao.GbsFileImplementation;
import se.anosh.gbstag.dao.GenericDao;
import se.anosh.gbstag.domain.GbsTag;

public class TestModelWithData {
	
    public TestModelWithData() {
		super();
	}

	private GbsFileImplementation gbsFile;
    private GbsTag tag;
    private static String SAMPLE_FILE = "gbs/sample.gbs"; // Shantae
    private static String SECOND_SAMPLE = "gbs/sample2.gbs"; // DK Land2
    
    
    @Before
    public void setup() throws IOException {
        
        gbsFile = new GbsFileImplementation(SAMPLE_FILE);
        tag = gbsFile.read();
    }
	
    @Test
    public void testIdenticalHashCodes() throws IOException {
        GbsFileImplementation cloneFile = new GbsFileImplementation(SAMPLE_FILE);
        GbsTag clone = cloneFile.read();
        
        System.out.println("tag = " + tag);
        System.out.println("clone = " + clone);
        
        
        assertNotSame(clone,tag); // don't cheat
        assertEquals(tag.hashCode(),clone.hashCode());
    }
    
    @Test
    public void testNotIdenticalHashCodes() throws IOException {
        
        GbsFileImplementation different = new GbsFileImplementation(SECOND_SAMPLE);
        GbsTag differentGbsTag = different.read();
        
        assertNotSame(differentGbsTag,tag); // object references
        assertNotEquals(differentGbsTag,tag); // while we're at it
        assertNotEquals(differentGbsTag.hashCode(),tag.hashCode());
    }
//    
//    @Test
//    public void testEqualObjects() throws IOException {
//        
//        GbsFileImplementation cloneFile = new GbsFileImplementation(SAMPLE_FILE);
//        GbsTag clone = cloneFile.read();
//        
//        assertNotSame(clone,header); // no cheating
//        assertEquals(clone.hashCode(),header.hashCode()); // equal objects *MUST* have equals hashcodes
//        assertEquals(clone,header);
//    }
//    
//    @Test
//    public void testNonEqualObjects() throws IOException {
//        
//         GbsFileImplementation cloneFile = new GbsFileImplementation(SAMPLE_FILE);
//         GbsTag clone = cloneFile.read();
//         
//         assertNotEquals(clone,spcFile);
//    }
//    
//    @Test
//    public void testComparableSorting() throws IOException {
//        
//        GbsFileImplementation otherFile = new GbsFileImplementation(SAMPLE_FILE);
//        GbsTag other = otherFile.read();
//        
//        List<GbsTag> myList = new ArrayList<>();
//        myList.add(other);
//        myList.add(header);
//        myList.add(other);
//        myList.add(header);
//        
//        myList.sort(null);
//        myList.forEach(System.out::println);
//        assertEquals(header,myList.get(0));
//        assertEquals(header,myList.get(1));
//        assertEquals(other,myList.get(2));
//        assertEquals(other,myList.get(3));
//        
//    }
//    
//    @Test
//    public void testComparableWithNullValues() throws IOException {
//        
//        GenericDao otherFile = new GbsFileImplementation("spc/binary.spc"); //accessing using the interface this time
//        GbsTag other = otherFile.read();
//        
//        other.setGameTitle(null);
//        other.setSongTitle(null);
//        other.setArtist(null);
//        
//        header.setGameTitle(null);
//        
//        List<GbsTag> myList = new ArrayList<>();
//        myList.add(header);
//        myList.add(other);
//        
//        myList.sort(null);
//        
//        assertNull(myList.get(0).getSongTitle());
//        assertNull(myList.get(0).getGameTitle());
//        assertNull(myList.get(0).getArtist());
//        assertNull(myList.get(1).getGameTitle());
//        assertNotNull(myList.get(1).getArtist());
//        assertNotNull(myList.get(1).getSongTitle());
//    }
    
	

}
