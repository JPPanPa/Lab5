package hust.soict.globalict.JavaFX;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Painter extends Application {
	@Override
	public void start(Stage st) throws Exception{
		Parent root = FXMLLoader.load(getClass().getResource("/hust/soict/dsai/JavaFX/Painter.fxml"));
		Scene scene = new Scene(root);
		st.setTitle("Painter");
		st.setScene(scene);
		st.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}