package paquetes;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Crear un botón
        Button btn = new Button("Haz clic para ver el mensaje");

        // Acción cuando el botón es presionado
        btn.setOnAction(e -> System.out.println("¡Hola desde JavaFX!"));

        // Crear un contenedor y agregar el botón
        StackPane root = new StackPane();
        root.getChildren().add(btn);

        // Crear la escena
        Scene scene = new Scene(root, 300, 250);

        // Establecer el título de la ventana y la escena
        primaryStage.setTitle("Aplicación JavaFX");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

