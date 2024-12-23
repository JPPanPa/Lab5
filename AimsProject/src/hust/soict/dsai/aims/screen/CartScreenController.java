package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class CartScreenController {
    private Cart cart;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private Label lbTotalCost;

    public CartScreenController(Cart cart) {
        this.cart = cart;
    }

    @FXML
    private void initialize() {
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));

        updateCartTable();

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        tblMedia.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                updateButtonBar(newValue);
            }
        });
    }

    private void updateButtonBar(Media media) {
        btnRemove.setVisible(true);
        btnPlay.setVisible(media instanceof Playable);
    }

    private void updateCartTable() {
        tblMedia.setItems(FXCollections.observableArrayList(cart.getItemsOrdered()));
        lbTotalCost.setText(String.format("%.2f $", cart.totalCost()));
    }

    @FXML
    private void btnRemovePressed(ActionEvent event) {
        Media selectedMedia = tblMedia.getSelectionModel().getSelectedItem();
        if (selectedMedia != null) {
            cart.removeMedia(selectedMedia.getTitle());
            updateCartTable();
            btnRemove.setVisible(false);
            btnPlay.setVisible(false);
        } else {
            showAlert("No Media Selected", "Please select a media item to remove.", Alert.AlertType.WARNING);
        }
    }

    @FXML
    private void btnPlaceOrderPressed(ActionEvent event) {
        if (cart.getItemsOrdered().isEmpty()) {
            showAlert("Empty Cart", "Your cart is empty. Add items before placing an order.", Alert.AlertType.WARNING);
            return;
        }

        showAlert("Order Confirmation", "Your order has been placed successfully!", Alert.AlertType.INFORMATION);

        cart.clear();
        updateCartTable();
        btnRemove.setVisible(false);
        btnPlay.setVisible(false);
    }

    @FXML
    private void btnPlayPressed(ActionEvent event) {
        Media selectedMedia = tblMedia.getSelectionModel().getSelectedItem();
        if (selectedMedia instanceof Playable) {
            Playable playableMedia = (Playable) selectedMedia;
            playableMedia.play();
            showAlert("Playing Media", "Now playing: " + selectedMedia.getTitle(), Alert.AlertType.INFORMATION);
        } else {
            showAlert("Not Playable", "This media cannot be played.", Alert.AlertType.WARNING);
        }
    }

    private void showAlert(String title, String content, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
