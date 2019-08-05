package se.anosh.gbstag;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import se.anosh.gbstag.dao.GbsFileImplementation;
import se.anosh.gbstag.domain.GbsTag;

@Deprecated
public class TestGbsReading {

	    public TestGbsReading() {
			super();
		}

		private GbsFileImplementation gbsFile;
	    private GbsTag tags;
	    
	    
	    @Before
	    public void setup() throws IOException {
	        
	        gbsFile = new GbsFileImplementation("gbs/sample.gbs");
	        tags = gbsFile.read();
	    }
		
	    @Test
	    public void TestOpenFile() {
	    	
	    	System.out.println(tags.toString());
	    	System.out.println(tags.equals(tags));
	    	System.out.println(tags.hashCode());
	    	
	    }
	    

}
