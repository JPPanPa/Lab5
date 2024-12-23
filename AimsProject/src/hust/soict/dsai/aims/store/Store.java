package hust.soict.dsai.aims.store;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

public class Store {
    public static int MAX_NUMBERS_IN_STORE = 100;
    public DigitalVideoDisc[] itemsInStore = new DigitalVideoDisc[MAX_NUMBERS_IN_STORE];
    private int qtyInStore = 0;

    // Thêm DVD vào kho
    public void addDVD(DigitalVideoDisc dvd) {
        if (qtyInStore < MAX_NUMBERS_IN_STORE) {
            itemsInStore[qtyInStore] = dvd;
            qtyInStore++;
            System.out.println("Đĩa " + dvd.getTitle() + " đã được thêm vào kho.");
        } else {
            System.out.println("Kho đã đầy, không thể thêm đĩa.");
        }
    }

    // Xem kho
    public void printStore() {
        if (qtyInStore == 0) {
            System.out.println("Kho hiện tại không có sản phẩm nào.");
        } else {
            for (int i = 0; i < qtyInStore; i++) {
                System.out.println(itemsInStore[i].getTitle());
            }
        }
    }

    public DigitalVideoDisc[] getItemsInStore() {
		return itemsInStore;
	}

	public void setItemsInStore(DigitalVideoDisc[] itemsInStore) {
		this.itemsInStore = itemsInStore;
	}

	//  media theo title trong kho
    public Media findMediaByTitle(String title) {
        for (int i = 0; i < qtyInStore; i++) {
            if (itemsInStore[i].getTitle().equalsIgnoreCase(title)) {
                return itemsInStore[i];
            }
        }
        return null;
    }

	public void addMedia(Media media) {
		// TODO Auto-generated method stub
		
	}
}
