package hust.soict.dsai.aims.cart;
import java.util.ArrayList;
import hust.soict.dsai.aims.media.*;

public class Cart {
    private ArrayList<Media> itemsOrdered = new ArrayList<>();

    //them media
    public void addMedia(Media media) {
        itemsOrdered.add(media);
        System.out.println(media.getTitle() + "da them");
    }
    //xoa media
    public void removeMedia(Media media) {
        if (itemsOrdered.remove(media)) {
            System.out.println(media.getTitle() + "da xoa");
        } else {
            System.out.println(media.getTitle() + "khong co trong gio hang");
        }
    }
    // totalcost
    public double totalCost() {
        double total = 0.0;
        for (Media media : itemsOrdered) {
            total += media.getCost();
        }
        return total;
    }
    //tim media bang title
    public Media findMediaByTitle(String title) {
        for (Media media : itemsOrdered) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                return media;
            }
        }
        return null;
    }

    // media theo id
    public Media findMediaById(int id) {
        for (Media media : itemsOrdered) {
            if (media.getId() == id) {
                return media;
            }
        }
        return null;
    }

    // sapxep media
    public void sortByTitle() {
        itemsOrdered.sort((media1, media2) -> media1.getTitle().compareTo(media2.getTitle()));
    }

    // sapxep media theo cost
    public void sortByCost() {
        itemsOrdered.sort((media1, media2) -> Double.compare(media1.getCost(), media2.getCost()));
    }

    //xoa trong gio hang
    public void clearCart() {
        itemsOrdered.clear();
        System.out.println("da xoa");
    }

    // in media trong gio
    public void printCart() {
        if (itemsOrdered.isEmpty()) {
            System.out.println("gio hang rong");
        } else {
            for (Media media : itemsOrdered) {
                System.out.println("Title: " + media.getTitle() + ", Category: " + media.getCategory() + ", Cost: " + media.getCost());
            }
        }
    }
}
