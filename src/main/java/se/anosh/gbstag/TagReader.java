package se.anosh.gbstag;
import java.io.IOException;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import se.anosh.gbstag.dao.GbsFileImplementation;
import se.anosh.gbstag.dao.GbsTag;
import se.anosh.gbstag.service.GbsManager;
import se.anosh.gbstag.service.GenericService;
/**
 *
 * SPC tag 0.1
 * 
 * Java command-line tool for reading the tags from Game Boy Sound (gbs) files.
 * 
 * GBS-files are sound files containing ripped chiptune music 
 * from Gameboy and Gameboy Colour
 * 
 * @author Anosh D. Ullenius <anosh@anosh.se>
 * code written in August 2019. Based on spctool
 */
public class TagReader {
    
    private static final String VERSION ="gbstag version 0.1";
    private static final String ABOUT = "code by A. Ullenius 2019";
    private static final String LICENCE = "Licence: Gnu General Public License - version 3.0 only";
    
    public static void main(String[] args) {
        
        Options options = new Options();
        options.addOption("v", "verbose", false, "verbose output");
        options.addOption("V", "version", false, "print version");
        
        CommandLineParser parser = new DefaultParser();
        HelpFormatter formatter = new HelpFormatter();

        try {
            CommandLine cmd = parser.parse(options, args);
            
            if (cmd.hasOption("V"))
                printVersionAndCreditsAndExit();
            
            if (cmd.getArgList().isEmpty())
                    throw new ParseException("No arguments");
            
            TagReader demo = new TagReader();
            demo.go(cmd);
        } catch (ParseException ex) {
            formatter.printHelp("gbs <filename>", options);
            System.exit(0);
        }
        
    }
    
    private static void printVersionAndCreditsAndExit() {
        
        System.out.println(VERSION);
        System.out.println(ABOUT);
        System.out.println(LICENCE);
        System.exit(0);
    }
    
    public void go(final CommandLine cmd)  {
        
        String[] fileNames = cmd.getArgs();
        
        for (String file : fileNames) {
            try {
            	
            	GenericService<GbsTag> service = new GbsManager(new GbsFileImplementation(file));
            	GbsTag myFile = service.read();
            	
            	if (cmd.hasOption("v")) { // verbose output
            		System.out.println("File header: " + myFile.getHeader());
            	}
                System.out.println("Artist(s): " + myFile.getAuthor()); // composers, named 'Author' in the GBS-spec
                System.out.println("Title: " + myFile.getTitle());
                System.out.println("Copyright: " + myFile.getCopyright());
                
                
            } catch (IOException ex) {
                System.out.println("I/O error");
                //ex.printStackTrace();
                System.exit(0);
            }
        } // end of for-each-loop
    }
    
}
