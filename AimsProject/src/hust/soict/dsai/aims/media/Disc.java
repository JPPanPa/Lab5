package hust.soict.dsai.aims.media;

public class Disc extends Media{
	 protected String director;
	 protected int length;
	public String getDirector() {
			return director;
		}
		public void setDirector(String director) {
			this.director = director;
		}
		public int getLength() {
			return length;
		}
		public void setLength(int length) {
			this.length = length;
		}
		public Disc(int id, String title, String category, float cost, int length, String director) {
			super(id, title, category, cost);
			this.length=length;
			this.director=director;
		}

}
