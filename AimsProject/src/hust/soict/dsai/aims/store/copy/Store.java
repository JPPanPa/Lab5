package hust.soict.dsai.aims.store.copy;
import hust.soict.dsai.aims.media.Media;
import java.util.ArrayList;
public class Store {
	private ArrayList<Media> itemsInStore = new ArrayList<>();
    //them media
   public void addMedia(Media media) {
        itemsInStore.add(media);
        System.out.println(media.getTitle() + "đã được thêm");
    }
    //xoa media
    public void removeMedia(Media media) {
        if (itemsInStore.remove(media)) {
            System.out.println(media.getTitle() + " đã bị xóa ");
        } else {
            System.out.println(media.getTitle() + " không tồn tại trong cửa hàng");
        }
    }

    //hien thi danh sach media
    public void displayStore() {
        System.out.println("Các sản phẩm trong cửa hàng:");
        for (Media media : itemsInStore) {
            System.out.println("- " + media.getTitle());
        }
    }
}
