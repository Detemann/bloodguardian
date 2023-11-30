package com.sarrussys.bloodguardian.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.sarrussys.bloodguardian.models.BolsaSangue;
import com.sarrussys.bloodguardian.models.TipoSanguineo;
import com.sarrussys.bloodguardian.repositores.TipoSangueRepository;
import com.sarrussys.bloodguardian.util.Alerts;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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
	@FXML
	private ComboBox<String> cmbTpSanguineo;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		cmbTpSanguineo.getItems().addAll(
				"A+",
				"A-",
				"B+",
				"B-",
				"AB+",
				"AB-",
				"O+",
				"O-"
		);

	}

	@FXML
	public void onBtnVoltarAction(ActionEvent event) {
		MainMenuController main = new MainMenuController();
	}
	
	public void onBtnSalvarAction(ActionEvent event) {
		String codBolsa = txtCodBolsa.getText();
		String tipoSanguineoString = cmbTpSanguineo.getItems().toString();
		TipoSanguineo tipoSanguineo = new TipoSanguineo();
		System.out.println(codBolsa);
		System.out.println(tipoSanguineoString);


		TipoSangueRepository repository = new TipoSangueRepository();

		String DtColeta = txtDtColeta.getText();
		String validade = txtValidade.getText();



	}
	
	
}
