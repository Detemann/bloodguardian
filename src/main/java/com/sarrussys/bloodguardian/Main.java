package com.sarrussys.bloodguardian;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Login-page.fxml"));
			Parent parent = loader.load();
			Scene mainScene = new Scene(parent,550,350);
			primaryStage.setScene(mainScene);
			primaryStage.setTitle("SGBS");
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

    public static void main(String[] args) {
        launch(args);
    }
}