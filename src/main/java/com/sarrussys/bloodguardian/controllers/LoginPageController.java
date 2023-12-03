package com.sarrussys.bloodguardian.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.sarrussys.bloodguardian.models.BolsaSangue;
import com.sarrussys.bloodguardian.repositores.BolsaSangueRepository;
import com.sarrussys.bloodguardian.util.Alerts;
import com.sarrussys.bloodguardian.util.Utils;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginPageController implements Initializable{
	
	private static Scene mainScene;
	
	@FXML
	private Button btnLogin;

	@FXML
	private TextField textEmail;
	@FXML
	private TextField textSenha;
	
	@FXML
	private Label lblEmail;
	
	@FXML
	private Label lblSenha;
	
	public void loadLoginPage(Stage primaryStage) {
		System.out.println("Login");
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Login-page.fxml"));
			Parent parent = loader.load();
			mainScene = new Scene(parent,380,368);
			primaryStage.setScene(mainScene);
			primaryStage.setTitle("SGBS");
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private String getEmail(){
		return textEmail.getText();
	}

	private String getSenha(){
		return textSenha.getText();
	}


	
	public static Scene getMainScene() {
		return mainScene;
	}
	public void  onBtnLoginAction(ActionEvent event) {
		MainMenuController main = new MainMenuController();

		String login = getEmail();
		String senha = getSenha();

		if(login.compareTo("admin") == 0 && senha.compareTo("senha") == 0){
			main.loadMainMenu(event);
		}else{
			Alerts.showAlert("Aviso", "Login ou Senha incorreta", "", Alert.AlertType.ERROR);
		}

	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	
}
