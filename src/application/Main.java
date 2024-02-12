package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;


public class Main extends Application {
	
	private static Scene cenaPrincipal;
	
	@Override
	public void start(Stage stage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/VisualizacaoPrincipal.fxml"));
			ScrollPane scrollPane = loader.load();
			
			scrollPane.setFitToHeight(true);
			scrollPane.setFitToWidth(true);
			
			cenaPrincipal = new Scene(scrollPane);
			stage.setScene(cenaPrincipal);
			stage.setTitle("Exemplo de aplicativo javafx");
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Scene getCenaPrincipal() {
		return cenaPrincipal;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
