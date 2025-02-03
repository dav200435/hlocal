package aplicacion;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Crear un Label con un mensaje
        Label label = new Label("¡Hola, JavaFX!");

        // Crear una escena con el Label
        Scene scene = new Scene(label, 300, 200); // Ancho: 300, Alto: 200

        // Configurar el título de la ventana
        primaryStage.setTitle("Ventana Simple");

        // Asignar la escena a la ventana
        primaryStage.setScene(scene);

        // Mostrar la ventana
        primaryStage.show();
    }

    public static void main(String[] args) {
        // Lanzar la aplicación
        launch(args);
    }
}
