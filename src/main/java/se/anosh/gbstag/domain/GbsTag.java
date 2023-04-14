package se.anosh.gbstag.domain;

import java.util.Comparator;

public final class GbsTag implements Comparable<GbsTag> {
	
	// Thanks to Lukasz Wiktor @ stack overflow (2014)
    private static final Comparator<String> nullSafeStringComparator = Comparator.nullsFirst(String::compareToIgnoreCase);
    private static final Comparator<GbsTag> gbsComparator = Comparator
            .comparing(GbsTag::getTitle, nullSafeStringComparator)
            .thenComparing(GbsTag::getAuthor, nullSafeStringComparator)
            .thenComparing(GbsTag::getCopyright, nullSafeStringComparator);
	
	private String header;
	private String author;
	private String title;
	private String copyright;
	
	private byte numberOfSongs; //1-255 (1 unsigned byte)
	private byte firstSong; //1-255 (1 unsigned byte)
	private byte versionNumber;  // doesn't matter
	
	public byte getVersionNumber() {
		return versionNumber;
	}
	public void setVersionNumber(byte versionNumber) {
		this.versionNumber = versionNumber;
	}
	public int getNumberOfSongs() {
		return Byte.toUnsignedInt(numberOfSongs);
	}
	public void setNumberOfSongs(int numberOfSongs) {
		this.numberOfSongs = (byte) numberOfSongs; // leaves only the least significant byte
	}
	public int getFirstSong() {
		return Byte.toUnsignedInt(firstSong);
	}
	public void setFirstSong(int firstSong) {
		this.firstSong = (byte) firstSong;
	}
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((copyright == null) ? 0 : copyright.hashCode());
		result = prime * result + firstSong;
		result = prime * result + numberOfSongs;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GbsTag other = (GbsTag) obj;
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
		if (firstSong != other.firstSong)
			return false;
		if (numberOfSongs != other.numberOfSongs)
			return false;
		if (title == null) {
			return other.title == null;
		} else {
			return title.equals(other.title);
		}
	}
	@Override
	public String toString() {
		return "GbsTag [identifier=" + header + ", versionNumber=" + versionNumber + ", numberOfSongs=" + Byte.toUnsignedInt(numberOfSongs)
				+ ", firstSong=" + Byte.toUnsignedInt(firstSong) + ", title=" + title + ", author=" + author + ", copyright=" + copyright
				+ "]";
	}
	
	@Override
	public int compareTo(GbsTag arg) {
		return gbsComparator.compare(this, arg);
	}
	
}
