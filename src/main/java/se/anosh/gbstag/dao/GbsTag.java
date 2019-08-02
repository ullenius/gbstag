package se.anosh.gbstag.dao;

import java.util.Comparator;

/* Domain class for GBS-files 
 * 
 */

public class GbsTag implements Comparable<GbsTag> {
	
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
		int result = super.hashCode();
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((copyright == null) ? 0 : copyright.hashCode());
		result = prime * result + ((header == null) ? 0 : header.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		if (header == null) {
			if (other.header != null)
				return false;
		} else if (!header.equals(other.header))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "GameBoySoundFile [header=" + header + ", author=" + author + ", title=" + title + ", copyright="
				+ copyright + "]";
	}
	
	@Override
	public int compareTo(GbsTag arg0) {
		
		return gbsComparator.compare(this, arg0);
	}
	
}
