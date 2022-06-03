package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class MainController {
	@FXML private Button btnCalc;
	@FXML private TextField txtExpense;
	@FXML private TextField lblAmount;



	@FXML private void initialize(){

		btnCalc.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent e) {
				onStartClicked();    // Always call a method in the outer class
			}
		});
	}

	private void onStartClicked(){

		String valueText = txtExpense.getText();

		if (!txtExpense.getText().matches("[0-9]*")){
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Error");
			alert.setHeaderText("Error");
			alert.setContentText("Invalid Input");
			alert.showAndWait();
		}else if(valueText == null){
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Error");
			alert.setHeaderText("Error");
			alert.setContentText("Invalid Input");
			alert.showAndWait();
		}
		else{

			double claimAmount = Double.parseDouble(txtExpense.getText());

			double finalValue = 0.0;

			if (claimAmount <= 100){
				finalValue = .57 * claimAmount;
			}else{
				finalValue =  (.57 * 100) + (.28 * (claimAmount - 100));
			}

			double roundedDouble = Math.round(finalValue * 100.0) / 100.0;

			String stringFinal = String.valueOf(roundedDouble);


			lblAmount.setText(stringFinal);

		}

	}
}


