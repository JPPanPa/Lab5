package hust.soict.dsai.aims.media;

public class Track {
	private String title;
	private int length;
	public String getTitle() {
		return title;
	}
	public int getLength() {
		return length;
	}
	public Track(String title, int length) {
		super();
		this.title = title;
		this.length = length;
	}
	public void play() {
		System.out.println("playing dvd"+ this.getTitle());
		System.out.println("dvd length:"+ this.getLength());
	}
	@Override
	public boolean equals(Object obj) {
	    if (this == obj) return true;
	    if (!(obj instanceof Track)) return false;
	    Track other = (Track) obj;
	    return this.getTitle() != null && this.getTitle().equals(other.getTitle())
	            && this.getLength() == other.getLength();
	}
}
