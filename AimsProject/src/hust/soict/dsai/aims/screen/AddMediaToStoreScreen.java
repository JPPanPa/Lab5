package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store;

import javax.swing.*;
import java.awt.*;

public abstract class AddMediaToStoreScreen extends JFrame {
    protected Store store;
    protected Cart cart;

    // Các trường nhập dữ liệu cho Media
    private JTextField tfId = new JTextField(10);
    private JTextField tfTitle = new JTextField(10);
    private JTextField tfCategory = new JTextField(10);
    private JTextField tfCost = new JTextField(10);

    // Constructor
    public AddMediaToStoreScreen(Store store, Cart cart) {
        super("Add Media to Store");
        this.store = store;
        this.cart = cart;

        // Thiết lập giao diện chính
        setLayout(new BorderLayout());

        // NORTH: Tiêu đề và menu
        add(createNorthPanel(), BorderLayout.NORTH);

        // CENTER: Khu vực nhập liệu
        add(createInputPanel(), BorderLayout.CENTER);

        // SOUTH: Nút hành động
        add(createButtonPanel(), BorderLayout.SOUTH);

        // Cài đặt JFrame
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // Tạo tiêu đề và menu
    private JPanel createNorthPanel() {
        JPanel northPanel = new JPanel(new BorderLayout());

        // Tiêu đề
        JLabel titleLabel = new JLabel("Add Media to Store", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        northPanel.add(titleLabel, BorderLayout.CENTER);

        // Menu bar
        northPanel.add(createMenuBar(), BorderLayout.NORTH);

        return northPanel;
    }

    private JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");

        JMenu smUpdateStore = new JMenu("Update Store");
        JMenuItem addBook = new JMenuItem("Add Book");
        JMenuItem addCD = new JMenuItem("Add CD");
        JMenuItem addDVD = new JMenuItem("Add DVD");
        smUpdateStore.add(addBook);
        smUpdateStore.add(addCD);
        smUpdateStore.add(addDVD);

        menu.add(smUpdateStore);
        JMenuItem viewStore = new JMenuItem("View Store");
        JMenuItem viewCart = new JMenuItem("View Cart");
        menu.add(viewStore);
        menu.add(viewCart);

        JMenuBar menuBar = new JMenuBar();
        menuBar.add(menu);

        return menuBar;
    }

    // Tạo khu vực nhập liệu
    private JPanel createInputPanel() {
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(4, 2, 10, 10)); // 4 hàng, 2 cột, khoảng cách 10px

        // Thêm các trường nhập liệu
        inputPanel.add(new JLabel("ID: "));
        inputPanel.add(tfId);

        inputPanel.add(new JLabel("Title: "));
        inputPanel.add(tfTitle);

        inputPanel.add(new JLabel("Category: "));
        inputPanel.add(getTfCategory());

        inputPanel.add(new JLabel("Cost: "));
        inputPanel.add(tfCost);

        return inputPanel;
    }

    // Tạo khu vực nút hành động
    private JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));

        JButton addButton = new JButton("Add to Store");
        JButton cancelButton = new JButton("Cancel");

        // Hành động cho nút "Add to Store"
        addButton.addActionListener(e -> {
            Media media = createMedia();
            if (media != null) {
                try {
                    store.addMedia(media);
                    JOptionPane.showMessageDialog(this, "Media added successfully!");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Failed to add media: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Hành động cho nút "Cancel"
        cancelButton.addActionListener(e -> {
            this.dispose(); // Đóng cửa sổ
        });

        buttonPanel.add(addButton);
        buttonPanel.add(cancelButton);

        return buttonPanel;
    }

    // Trừu tượng: Lớp con sẽ định nghĩa cách tạo Media cụ thể
    public abstract Media createMedia();

    // Lấy dữ liệu từ các trường nhập liệu
    protected String getInputTitle() {
        return tfTitle.getText().trim();
    }

    protected String getInputCategory() {
        return getTfCategory().getText().trim();
    }

    protected float getInputCost() {
        try {
            return Float.parseFloat(tfCost.getText().trim());
        } catch (NumberFormatException e) {
            return 0f;
        }
    }

    protected int getInputId() {
        try {
            return Integer.parseInt(tfId.getText().trim());
        } catch (NumberFormatException e) {
            return -1; // Giá trị mặc định nếu lỗi
        }
    }

	public JTextField getTfCategory() {
		return tfCategory;
	}

	public void setTfCategory(JTextField tfCategory) {
		this.tfCategory = tfCategory;
	}
}
