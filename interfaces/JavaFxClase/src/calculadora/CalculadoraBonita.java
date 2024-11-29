package calculadora;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CalculadoraBonita extends Application {
    
    private VBox layout;
    private TextField display;
    private String operator = "";
    private double firstOperand = 0;

    public GridPane createGrid() {
        GridPane grid = new GridPane();
        
        String[][] buttons = {
            {"1", "2", "3", "+"},
            {"4", "5", "6", "-"},
            {"7", "8", "9", "*"},
            {"/", "0", "="}
        };

        for (int row = 0; row < buttons.length; row++) {
            for (int col = 0; col < buttons[row].length; col++) {
                String buttonText = buttons[row][col];
                Button button = new Button(buttonText);
                button.setMinSize(40, 40);
                grid.add(button, col, row);

                button.setOnAction(e -> handleButtonPress(buttonText));
            }
        }

        return grid;
    }

    private void handleButtonPress(String buttonText) {
        switch (buttonText) {
            case "+":
            case "-":
            case "*":
            case "/":
                operator = buttonText;
                firstOperand = Double.parseDouble(display.getText());
                display.clear();
                break;
            case "=":
                double secondOperand = Double.parseDouble(display.getText());
                double result = calculateResult(firstOperand, secondOperand, operator);
                display.setText(String.valueOf(result));
                operator = "";
                break;
            default:
                display.appendText(buttonText);
                break;
        }
    }

    private double calculateResult(double operand1, double operand2, String operator) {
        switch (operator) {
            case "+": return operand1 + operand2;
            case "-": return operand1 - operand2;
            case "*": return operand1 * operand2;
            case "/": return operand2 != 0 ? operand1 / operand2 : 0;
            default: return 0;
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Calculadora Bonita");

        display = new TextField();
        display.setEditable(false);

        GridPane grid = createGrid();
        
        layout = new VBox(10);
        layout.getChildren().addAll(display, grid);

        Scene scene = new Scene(layout, 300, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
