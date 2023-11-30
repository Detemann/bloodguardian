package com.sarrussys.bloodguardian;

import com.sarrussys.bloodguardian.controllers.LoginPageController;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	public void start(Stage primaryStage) {
		LoginPageController login = new LoginPageController();
		login.loadLoginPage(primaryStage);
	}

    public static void main(String[] args) {
        launch(args);
    }
}