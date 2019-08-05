package se.anosh.spctag.dao;

/* Domain class for GBS-files 
 * 
 */

public class GameBoySoundFile extends Id666 {
	
	// Includes identifier string and version number
	public static final int HEADER_OFFSET = 0;
	public static final int HEADER_LENGTH = 0x4;

	public static final int SONG_TITLE_OFFSET = 0x10;
	public static final int SONG_TITLE_LENGTH = 32;

	public static final int AUTHOR_OF_SONG_OFFSET = 0x30;
	public static final int AUTHOR_OF_SONG_LENGTH = 32;
	
	public static final int COPYRIGHT_OFFSET = 0x50;
	public static final int COPYRIGHT_LENGTH = 32;
	
	private String header;
	private String author;
	private String songTitle;
	private String copyright;
	
	public String getHeader() {
		return header;
	}
	public void setHeader(String header) {
		this.header = header;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getSongTitle() {
		return songTitle;
	}
	public void setSongTitle(String songTitle) {
		this.songTitle = songTitle;
	}
	public String getCopyright() {
		return copyright;
	}
	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((copyright == null) ? 0 : copyright.hashCode());
		result = prime * result + ((header == null) ? 0 : header.hashCode());
		result = prime * result + ((songTitle == null) ? 0 : songTitle.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		GameBoySoundFile other = (GameBoySoundFile) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (copyright == null) {
			if (other.copyright != null)
				return false;
		} else if (!copyright.equals(other.copyright))
			return false;
		if (header == null) {
			if (other.header != null)
				return false;
		} else if (!header.equals(other.header))
			return false;
		if (songTitle == null) {
			if (other.songTitle != null)
				return false;
		} else if (!songTitle.equals(other.songTitle))
			return false;
		return true;
	}
	
	

}
