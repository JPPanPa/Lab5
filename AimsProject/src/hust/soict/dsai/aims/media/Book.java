package hust.soict.dsai.aims.media;
import java.util.ArrayList;
import java.util.List;
public class Book extends Media{
	private List<String> authors = new ArrayList<String>();
	public Book(int id, String title, String category, float cost) {
			super(id, title, category, cost);
		// TODO Auto-generated constructor stub
	}
	public List<String> getAuthors() {
		return authors;
	}
	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}
public void addAuthor(String authorName) {
	if(authors.contains(authorName)) {
		System.out.println("đã tồn tại tác giả");
	}else {System.out.println("tác giả"+ authorName +"đã được thêm");
	}
}
public void removeAuthor(String authorName) {
	if(authors.contains(authorName)) {
		authors.remove(authorName);
		System.out.println("Đã xóa tác giả"+ authorName + "trong List");
	}else {
		System.out.println("không tìm thấy tác giả"+ authorName +"trong List");
	}
}
}
