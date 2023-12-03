package com.sarrussys.bloodguardian.controllers;

import java.net.URL;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;

import com.sarrussys.bloodguardian.models.BolsaSangue;
import com.sarrussys.bloodguardian.models.Saidas;
import com.sarrussys.bloodguardian.repositores.BolsaSangueRepository;
import com.sarrussys.bloodguardian.repositores.SaidasRepository;
import com.sarrussys.bloodguardian.util.Alerts;
import com.sarrussys.bloodguardian.util.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class CadastroSaidasController implements Initializable{
	@FXML
	private TextField txtCodBolsa;
	@FXML
	private DatePicker dtSaida;
	@FXML
	private Button btnSalvar;

	private BolsaSangueRepository bolsaSangueRepository = new BolsaSangueRepository();

	private SaidasRepository saidasRepository = new SaidasRepository();
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	public void onBtnSalvarAction(ActionEvent event) {
		if(txtCodBolsa.getText().equalsIgnoreCase("")) {
			Alerts.showAlert("Aviso", "Insira um código da Bolsa válido", "", Alert.AlertType.ERROR);
			return;
		}

		if(dtSaida.getValue() == null) {
			Alerts.showAlert("Aviso", "Data de saída inválida", "", Alert.AlertType.ERROR);
			return;
		}

		BolsaSangue bolsaSaindo = bolsaSangueRepository.buscarPorId(txtCodBolsa.getText());

		Saidas saida = new Saidas(bolsaSaindo, Utils.convertLocalDateToSqlDate(dtSaida.getValue()));

		saidasRepository.salvar(saida);
	}

	@FXML
	private void btnVoltar(ActionEvent event) {
		System.out.println("VoltarEstoque");
		MainMenuController main = new MainMenuController();
		main.loadMainMenu(event);
	}
}
