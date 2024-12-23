package hust.soict.dsai.test.Polymorphism;
import hust.soict.dsai.aims.media.*;
import java.util.ArrayList;
import java.util.List;
public class Polymorphism {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List <Media> mediae = new ArrayList<Media>();
	    DigitalVideoDisc dvd1 = new DigitalVideoDisc(5, "one piece", "action", 20f, 1000, "thanhtuu");
	    DigitalVideoDisc dvd2 = new DigitalVideoDisc(6, "naruto", "Action", 11f, 152, "thanhtuuu");
		Book book1 = new Book(1, "truyen hay", "thanh tuu", 10f);
        Book book2 = new Book(2, "lalala", "oda", 11f);
        CompactDisc cd1 = new CompactDisc(3, "hay trao cho anh", "romatic", 100f, 100, "sontungmtp");
        CompactDisc cd2 = new CompactDisc(4, "Thriller", "Pop", 18.00f, 100, "Michael Jackson");
        mediae.add(dvd1);
        mediae.add(dvd2);
        mediae.add(book1);
        mediae.add(book2);
        mediae.add(cd1);
        mediae.add(cd2);
        for (Media m : mediae)
        {
        	System.out.println(m.toString());
        }

	}

}
