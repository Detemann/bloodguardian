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
	
	public void  onBtnLoginAction(ActionEvent event) {
		System.out.println("Login");
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Main-page.fxml"));
			Parent pane = loader.load();
			Stage mainStage = new Stage();
			Scene mainScene = new Scene(pane,550,350);
			mainStage.setScene(mainScene);
			mainStage.setTitle("SGBS");
			mainStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Utils.currentStage(event).close();
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	
}
