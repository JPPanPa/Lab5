package hust.soict.globalict.JavaFX;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class PainterController {
    @FXML
    private Pane drawingAreaPane;
    @FXML
    private RadioButton penRadioButton;
    @FXML
    private RadioButton eraserRadioButton;
    @FXML
    private ToggleGroup toggleGroup; 
    private boolean isEraserSelected = false;
    @FXML
    public void initialize() {
        penRadioButton.setSelected(true);
        toggleGroup = new ToggleGroup();
        penRadioButton.setToggleGroup(toggleGroup);
        eraserRadioButton.setToggleGroup(toggleGroup);
        
        toggleGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == eraserRadioButton) {
                isEraserSelected = true;
            } else {
                isEraserSelected = false;
            }
        }
        );
    }
    @FXML
    void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }
    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        Color colorToUse = isEraserSelected ? Color.WHITE : Color.BLACK; // Use white for eraser
        Circle newCircle = new Circle(event.getX(), event.getY(), 4, colorToUse);
        drawingAreaPane.getChildren().add(newCircle);
    }
}