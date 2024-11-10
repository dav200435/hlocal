package ejemplos;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MiPantalla extends Application {

	@Override
	public void start(Stage Stage) throws Exception {
		Label label = new Label("Ingrese su nombre");
		TextField text = new TextField();
		Button btn = new Button("enviar");
		Tooltip tlt = new Tooltip("pon el nombre");
		DropShadow shadow = new DropShadow();
		btn.setEffect(shadow);
		btn.setOnMouseEntered(e ->btn.setStyle("-fx-background-color:#ff0000;"));
		btn.setOnMouseExited(e ->btn.setStyle("-fx-background-color:#ffffff"));
		btn.setTooltip(tlt);
		btn.setOnAction(e -> {
			System.out.println(text.getText());
		});
		VBox layout = new VBox(10);
		layout.getChildren().addAll(label,text,btn);
		layout.setBackground(new Background(new BackgroundFill(Color.PINK, null, null)));
		Scene scena = new Scene(layout,300,200);
		Stage.setScene(scena);
		Stage.setTitle("pantalla");
		Stage.show();
		
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
