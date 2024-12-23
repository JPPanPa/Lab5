package hust.soict.dsai.aims.media;
public class DigitalVideoDisc extends Disc implements Playable{
    public DigitalVideoDisc(int id, String title, String category, float cost, int length, String director) {
		super(id, title, category, cost, length, director);
	}
	public boolean isEmpty() {
        return (this.title == null || this.title.isEmpty()) ||
               (this.category == null || this.category.isEmpty()) ||
               this.cost <= 0;
    }
public void play() {
	System.out.println("playing dvd"+ this.getTitle());
	System.out.println("dvd length:"+ this.getLength());
}
}