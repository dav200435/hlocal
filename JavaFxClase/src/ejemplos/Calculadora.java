package ejemplos;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Calculadora extends Application{

	@Override
	public void start(Stage stage) {
		Label label1 = new Label("numero1: ");
		Label label2 = new Label("numero2: ");
		TextField resultado = new TextField();
		TextField num1 = new TextField();
		TextField num2 = new TextField();
		Button sumar = new Button("sumar");
		sumar.setMaxWidth(Double.MAX_VALUE);
		sumar.setOnAction(e -> {
			double number1 = Double.parseDouble(num1.getText());
            double number2 = Double.parseDouble(num2.getText());
            double sum = number1 + number2;
            resultado.setText("Resultado: "+String.valueOf(sum));
		});
		
		GridPane grid = new GridPane();
		grid.setVgap(10);
		grid.setHgap(10);
		grid.add(label1, 0, 0);
		grid.add(num1, 1, 0);
		grid.add(label2, 0, 1);
		grid.add(num2, 1, 1);
		grid.add(sumar, 0, 2,2,1);
		grid.add(resultado, 0, 3, 2, 1);
		
		
		Scene escena = new Scene(grid,400,400);
		stage.setScene(escena);
		stage.setTitle("calculator");
		stage.show();
		
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}

}
