package hust.soict.dsai.aims.media;
import java.util.ArrayList;
public class CompactDisc extends Disc implements Playable {
	private String artist;
	private ArrayList<Track> tracks;
	
	public CompactDisc(int id, String title, String category, float cost, int length, String director) {
		super(id, title, category, cost, length, director);
		this.tracks = new ArrayList<>();
	}

	public String getArtist() {
		return artist;
	}
	// add track
	public void addTrack(Track track) {
        if (tracks.contains(track)) {
            System.out.println("Track \"" + track.getTitle() + "đã có");
        } else {
            tracks.add(track);
            System.out.println("Track \"" + track.getTitle() + "đã thêm thành công");
        }
    }
    //remove Track
    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
            System.out.println("Track \"" + track.getTitle() + "xoa thanh cong");
        } else {
            System.out.println("Track \"" + track.getTitle() + "khong co trong List");
        }
    }

	public int getLength()
	{  int lengg=0;
		for (Track track : tracks)
		{
			lengg+=track.getLength();
		}
		return lengg;
	}
	 public void play() {
	 System.out.println("playing dvd:" + this.getTitle());
	 System.out.println("dvd length" + this.getLength() + " phút");
	 for (Track track : tracks) {
	 track.play();
	 }
	 }

	public Track[] getTracks() {
		// TODO Auto-generated method stub
		return null;
	}
}
