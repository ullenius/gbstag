package se.anosh.gbstag;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import se.anosh.gbstag.dao.GbsFileImplementation;
import se.anosh.gbstag.domain.GbsTag;

/**
 *
 * @author Anosh D. Ullenius <anosh@anosh.se>
 */
public class TestSPCWithTextFormatTags {
    
    public TestSPCWithTextFormatTags() {
    }
    
    private static String SAMPLE_FILE = "gbs/sample.gbs"; // Shantae
    
    GbsFileImplementation spcFile;
    GbsTag tag;
    
    
    @Before
    public void setup() throws IOException {
        
        spcFile = new GbsFileImplementation(SAMPLE_FILE);
        tag = spcFile.read();
        
    }
    
    @Test
    public void testFileWithValidHeader() {
        
        // first 3 bytes of string should equal "GBS"
        final String headerWithoutVersionNumber = tag.getHeader();
        assertEquals("GBS",headerWithoutVersionNumber); // case sensitive
    }
    
    @Test(expected=IOException.class)
    public void testFileWithInvalidHeader() throws IOException {
        // tests a file that is not SPC
        spcFile = new GbsFileImplementation("gbs/randomBytes.gbs"); // will throw exception
        
    }
    
    
    
    
}
