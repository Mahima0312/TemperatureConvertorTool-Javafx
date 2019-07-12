package com.mahima.fx;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

public class MyMain extends Application {


	// first method to be created- not part of lifecycle of javafx

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	// creates application
	public void init() throws Exception {
		super.init();
		System.out.println("in init");
	}

	// optional main method
	@Override
	// shows or visibile to user
	// maindatory to override
	public void start(Stage primaryStage) throws Exception {
		// part of application class

		System.out.println("in start");
		FXMLLoader loader = new FXMLLoader(getClass().getResource("app_layout.fxml"));
		VBox rootNode = loader.load(); // loads the root node-pane
		//loader is to connect main.java & fxml file

		MenuBar menuBar= createMenu();
		rootNode.getChildren().add(0, menuBar);

		Scene scene = new Scene(rootNode);

		primaryStage.setScene(scene);
		primaryStage.setTitle("Hello JavaFx, Mahima here");

		primaryStage.show(); // imp for visibility


	}
	public MenuBar createMenu(){
		Menu fileMenu= new Menu("File");
		MenuItem newMenuItem= new MenuItem("New");
		newMenuItem.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent actionEvent) {
				System.out.println("New Menu clicked");
			}
		});
		SeparatorMenuItem separatorMenuItem= new SeparatorMenuItem();
		MenuItem quitMenuItem= new MenuItem("Quit");
		quitMenuItem.setOnAction(actionEvent -> {
			Platform.exit();
			System.exit(0);
		});
		fileMenu.getItems().addAll(newMenuItem,separatorMenuItem, quitMenuItem);



		Menu helpMenu= new Menu("Help");
		MenuItem aboutApp= new MenuItem("About");
		aboutApp.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent actionEvent) {
				aboutApp();
			}
		});
		helpMenu.getItems().add(aboutApp);
		MenuBar menuBar= new MenuBar();
		menuBar.getMenus().addAll(fileMenu, helpMenu);
		return menuBar;

	}

	private void aboutApp() {

		Alert alertDialog= new Alert(Alert.AlertType.INFORMATION);
		alertDialog.setTitle("My First Desktop App");
		alertDialog.setHeaderText("Learning JavaFX");
		alertDialog.setContentText("Beginner!");

		ButtonType yesBtn= new ButtonType("Yes");
		ButtonType nobtn= new ButtonType("No");
		alertDialog.getButtonTypes().setAll(yesBtn, nobtn);
		Optional<ButtonType> clickedButton= alertDialog.showAndWait();
		if(clickedButton.isPresent() && clickedButton.get()==yesBtn) {
			System.out.println("Yes clicked!");
		}else{
			System.out.println("No Clicked");
		}
	}

	@Override
	// called when app is stopped/ unfunctional
	public void stop() throws Exception {
		System.out.println("in stop");
		super.stop();
	}
}
