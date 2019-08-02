package se.anosh.spctag;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import se.anosh.spctag.dao.GbsTag;
import se.anosh.spctag.dao.GbsFileImplementation;
import se.anosh.spctag.dao.Id666;
import se.anosh.spctag.dao.SpcFileImplementation;

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
