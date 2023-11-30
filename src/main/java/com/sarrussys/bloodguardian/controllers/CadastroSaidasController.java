package com.sarrussys.bloodguardian.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CadastroSaidasController implements Initializable{
	@FXML
	private TextField txtCodBolsa;
	@FXML
	private TextField txtDtSaida;
	@FXML
	private Button btnSalvar;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	public void onBtnVoltarAction(ActionEvent event) {
		MainMenuController main = new MainMenuController();
	}
	
	public void onBtnSalvarAction(ActionEvent event) {
	}

}
