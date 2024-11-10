package ejemplos;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        Label mensaje = new Label("Hola, JavaFX");
        
        Scene scene = new Scene(mensaje, 300, 200);
        
        stage.setTitle("Mi primera aplicación JavaFX");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
