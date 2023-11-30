package com.sarrussys.bloodguardian.controllers;

import java.net.URL;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;

import com.sarrussys.bloodguardian.models.BolsaSangue;
import com.sarrussys.bloodguardian.models.TipoSanguineo;
import com.sarrussys.bloodguardian.repositores.BolsaSangueRepository;
import com.sarrussys.bloodguardian.repositores.TipoSangueRepository;
import com.sarrussys.bloodguardian.util.Alerts;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CadastroBolsasController implements Initializable {
	@FXML
	private TextField txtCodBolsa;

	@FXML
	private DatePicker txtDtColeta;
	@FXML
	private DatePicker txtValidade;
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
		System.out.println("Salvar");

		String codBolsa = txtCodBolsa.getText();
		if (codBolsa.equalsIgnoreCase("")) {
			Alerts.showAlert("Aviso", "Insira um código da Bolsa válido", "", Alert.AlertType.ERROR);
			return;
		}

		String tipoSanguineoString = cmbTpSanguineo.getValue();
		if (tipoSanguineoString == null) {
			Alerts.showAlert("Aviso", "Selecione um tipo sanguíneo", "", Alert.AlertType.ERROR);
			return;
		}

		TipoSangueRepository tipoSangueRepository = new TipoSangueRepository();
		TipoSanguineo tipo = tipoSangueRepository.buscarPorNomeTipoSanguineo(tipoSanguineoString);
		if (tipo == null) {
			Alerts.showAlert("Aviso", "Tipo sanguíneo inválido", "", Alert.AlertType.ERROR);
			return;
		}

		LocalDate dtColeta = txtDtColeta.getValue();
		LocalDate dtValidade = txtValidade.getValue();
		if (dtColeta == null || dtValidade == null || dtColeta.isAfter(dtValidade)) {
			Alerts.showAlert("Aviso", "Datas de coleta e validade incorretas", "", Alert.AlertType.ERROR);
			return;
		}

		Date dataColetaSql = convertLocalDateToSqlDate(dtColeta);
		Date dataValidadeSql = convertLocalDateToSqlDate(dtValidade);

		BolsaSangue bolsa = new BolsaSangue(codBolsa, dataColetaSql, dataValidadeSql);
		bolsa.setTipoSanguineo(tipo);

		BolsaSangueRepository bolsaRepository = new BolsaSangueRepository();
		bolsaRepository.salvar(bolsa);

		// Limpa os campos após o salvamento bem-sucedido
		limparCampos();

		// Adiciona uma mensagem de sucesso se necessário
		Alerts.showAlert("Sucesso", "Bolsa cadastrada com sucesso", "", Alert.AlertType.INFORMATION);
	}

	// Método para limpar os campos
	private void limparCampos() {
		txtCodBolsa.clear();
		cmbTpSanguineo.setValue(null);
		txtDtColeta.setValue(null);
		txtValidade.setValue(null);
	}





	private Date convertLocalDateToSqlDate(LocalDate localDate) {
		// Converter LocalDate para java.util.Date com fuso horário correto
		Instant instant = localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
		java.util.Date utilDate = Date.from(instant);

		// Converter java.util.Date para java.sql.Date
		return new Date(utilDate.getTime());
	}



}
