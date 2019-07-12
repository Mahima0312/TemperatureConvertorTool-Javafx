package com.mahima.fx;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class MyController implements Initializable {

	@FXML
	public Label welcomeLabel;
	@FXML
	public ChoiceBox<String> choiceBox;
	@FXML
	public TextField userInputField;
	@FXML
	public Button convertButton;

	private static final String C_to_F_text= "Celsius to Fahrenheit";
	private  static  final String F_to_C_text= "Fahrenheit to Celsius";



	//just like start method in main
	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {


		choiceBox.getItems().add(C_to_F_text);
		choiceBox.getItems().add(F_to_C_text);
		//choicebox elements should belong to same class

		choiceBox.setValue(C_to_F_text);

		choiceBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
				System.out.println(t1);
			}
		});




		convertButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent actionEvent) {
				System.out.println("Button Clicked");
			}
		});

	}
}
