package com.sarrussys.bloodguardian.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.sarrussys.bloodguardian.util.Utils;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class LoginPageController implements Initializable{
	
	@FXML
	private Button btnLogin;
	
	@FXML
	private Label lblEmail;
	
	@FXML
	private Label lblSenha;

	public void loadLoginPage(Stage primaryStage) {
		System.out.println("Login");
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

	public void  onBtnLoginAction(ActionEvent event) {
		MainMenuController main = new MainMenuController();
		main.loadMainMenu(event);
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	
}
