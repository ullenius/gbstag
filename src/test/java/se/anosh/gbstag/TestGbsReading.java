package se.anosh.gbstag;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import se.anosh.gbstag.dao.GbsFileImplementation;
import se.anosh.gbstag.dao.GbsTag;

public class TestGbsReading {

	@Test
	public void test() {
//		fail("Not yet implemented");
	}
	
	    public TestGbsReading() {
			super();
		}

		private GbsFileImplementation gbsFile;
	    private GbsTag tags;
	    
	    
	    @Before
	    public void setup() throws IOException {
	        
	        gbsFile = new GbsFileImplementation("/tmp/zelda.gbs");
	        tags = gbsFile.read();
	    }
		
	    @Test
	    public void TestOpenFile() {
	    	
	    	System.out.println(tags.toString());
	    	
	    }
	    

}
