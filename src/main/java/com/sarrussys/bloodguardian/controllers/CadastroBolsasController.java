package com.sarrussys.bloodguardian.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.sarrussys.bloodguardian.util.Alerts;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CadastroBolsasController implements Initializable {
	@FXML
	private TextField txtCodBolsa;
	@FXML
	private TextField txtTpSanguineo;
	@FXML
	private TextField txtDtColeta;
	@FXML
	private TextField txtValidade;
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
