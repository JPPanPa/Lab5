package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

import javax.swing.*;
import java.awt.*;

public class StoreScreen extends JFrame {
    private Store store;
    // Tạo thanh menu
    private JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");

        JMenu smUpdateStore = new JMenu("Update Store");
        smUpdateStore.add(new JMenuItem("Add Book"));
        smUpdateStore.add(new JMenuItem("Add CD"));
        smUpdateStore.add(new JMenuItem("Add DVD"));

        menu.add(smUpdateStore);
        menu.add(new JMenuItem("View store"));
        menu.add(new JMenuItem("View cart"));

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
    }

    // Constructor
    public StoreScreen(Store store) {
        super("Store");
        this.store = store;

        // Thiết lập giao diện
        setLayout(new BorderLayout());

        // NORTH: Thanh tiêu đề
        JPanel northPanel = new JPanel();
        northPanel.setLayout(new BorderLayout());
        JLabel title = new JLabel("AIMS Store", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        JButton viewCartButton = new JButton("View Cart");
        northPanel.add(title, BorderLayout.CENTER);
        northPanel.add(viewCartButton, BorderLayout.EAST);

        add(northPanel, BorderLayout.NORTH);

        // CENTER: Hiển thị danh sách sản phẩm
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(0, 3, 10, 10)); // Lưới động với 3 cột

        // Thêm các mục từ Store vào giao diện
        for (int i = 0; i < store.MAX_NUMBERS_IN_STORE; i++) {
            DigitalVideoDisc dvd = store.itemsInStore[i];
            if (dvd != null) {
                centerPanel.add(createItemPanel(dvd));
            }
        }

        add(centerPanel, BorderLayout.CENTER);

        // THÊM MENU BAR VÀO JFrame
        setJMenuBar(createMenuBar()); // Dòng này thêm menu vào JFrame

        // Thiết lập JFrame
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // Tạo giao diện cho từng sản phẩm
    private JPanel createItemPanel(DigitalVideoDisc dvd) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JLabel itemTitle = new JLabel(dvd.getTitle(), JLabel.CENTER);
        JLabel itemPrice = new JLabel(dvd.getCost() + " $", JLabel.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2, 5, 5));
        JButton addToCartButton = new JButton("Add to cart");
        JButton playButton = new JButton("Play");
        buttonPanel.add(addToCartButton);
        buttonPanel.add(playButton);

        panel.add(itemTitle, BorderLayout.NORTH);
        panel.add(itemPrice, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        return panel;
    }

    public static void main(String[] args) {
        // Tạo Store mẫu
        Store store = new Store();
        store.addDVD(new DigitalVideoDisc(1, "Hay Trao Cho Anh", "Romantic", 100f, 100, "Son Tung MTP"));
        store.addDVD(new DigitalVideoDisc(2, "One Piece", "Action", 200f, 122, "Thanh Tuu"));
        store.addDVD(new DigitalVideoDisc(3, "Naruto", "Animation", 12f, 11, "Thanh Tai"));
        store.addDVD(new DigitalVideoDisc(4, "Attack on Titan", "Action", 150f, 150, "Isayama Hajime"));
        store.addDVD(new DigitalVideoDisc(5, "Demon Slayer", "Action", 180f, 130, "Gotouge Koyoharu"));
        store.addDVD(new DigitalVideoDisc(6, "Spirited Away", "Fantasy", 250f, 120, "Studio Ghibli"));
        store.addDVD(new DigitalVideoDisc(7, "Your Name", "Romantic", 220f, 100, "Makoto Shinkai"));
        store.addDVD(new DigitalVideoDisc(8, "Jujutsu Kaisen", "Action", 210f, 140, "Gege Akutami"));
        store.addDVD(new DigitalVideoDisc(9, "Dragon Ball Z", "Action", 170f, 160, "Akira Toriyama"));
        store.addDVD(new DigitalVideoDisc(10, "Bleach", "Action", 140f, 110, "Tite Kubo"));
        store.addDVD(new DigitalVideoDisc(11, "Sword Art Online", "Sci-Fi", 190f, 125, "Reki Kawahara"));
        // Chạy giao diện
        new StoreScreen(store);
    }
}
