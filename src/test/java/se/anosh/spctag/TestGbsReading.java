package se.anosh.spctag;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import se.anosh.spctag.dao.GameBoySoundFile;
import se.anosh.spctag.dao.GbsFileImplementation;
import se.anosh.spctag.dao.Id666;
import se.anosh.spctag.dao.SpcFileImplementation;

public class TestGbsReading {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	    public TestGbsReading() {
			super();
		}

		private GbsFileImplementation gbsFile;
	    private GameBoySoundFile tags;
	    
	    
	    @Before
	    public void setup() throws IOException {
	        
	        gbsFile = new GbsFileImplementation("spc/text.spc");
	        tags = gbsFile.read();
	    }
		

}
