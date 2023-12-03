package com.sarrussys.bloodguardian.controllers;

import java.net.URL;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

import com.sarrussys.bloodguardian.models.BolsaSangue;
import com.sarrussys.bloodguardian.models.TipoSanguineo;
import com.sarrussys.bloodguardian.repositores.BolsaSangueRepository;
import com.sarrussys.bloodguardian.repositores.TipoSangueRepository;
import com.sarrussys.bloodguardian.util.Alerts;

import com.sarrussys.bloodguardian.util.Utils;
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
		//criarBolsasAleatorias(); //esse metodo cria 100 bolsas aleatorias para teste, usar somente com banco vazio
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

		Date dataColetaSql = Utils.convertLocalDateToSqlDate(dtColeta);
		Date dataValidadeSql = Utils.convertLocalDateToSqlDate(dtValidade);

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

	@FXML
	private void btnVoltar(ActionEvent event) {
		System.out.println("VoltarEstoque");
		MainMenuController main = new MainMenuController();
		main.loadMainMenu(event);
	}
	/*
		METODOS PARA CRIAR 100 BOLSAS ALEATORIAS
	 */
	public void criarBolsasAleatorias() {
		for (int i = 0; i < 100; i++) {
			criarBolsaAleatoria();
		}
	}

	private void criarBolsaAleatoria() {
		String codBolsa = generateRandomCodBolsa();
		TipoSanguineo tipo = generateRandomTipoSanguineo();
		LocalDate dtColeta = generateRandomLocalDate();
		LocalDate dtValidade = dtColeta.plusDays(generateRandomValidityDays());

		Date dataColetaSql = Utils.convertLocalDateToSqlDate(dtColeta);
		Date dataValidadeSql = Utils.convertLocalDateToSqlDate(dtValidade);

		BolsaSangue bolsa = new BolsaSangue(codBolsa, dataColetaSql, dataValidadeSql);
		bolsa.setTipoSanguineo(tipo);

		BolsaSangueRepository bolsaRepository = new BolsaSangueRepository();
		bolsaRepository.salvar(bolsa);
	}

	private Set<String> codBolsasGerados = new HashSet<>();
	private String generateRandomCodBolsa() {
		String codBolsa;
		do {
			codBolsa = String.format("%05d", new Random().nextInt(100000));
		} while (codBolsasGerados.contains(codBolsa));

		codBolsasGerados.add(codBolsa);
		return codBolsa;
	}

	private TipoSanguineo generateRandomTipoSanguineo() {
		String[] tiposSanguineos = {"A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-"};
		int randomIndex = new Random().nextInt(tiposSanguineos.length);
		String tipoSanguineoString = tiposSanguineos[randomIndex];

		TipoSangueRepository tipoSangueRepository = new TipoSangueRepository();
		return tipoSangueRepository.buscarPorNomeTipoSanguineo(tipoSanguineoString);
	}

	private LocalDate generateRandomLocalDate() {
		// Implemente a lógica para gerar uma data aleatória dentro de um intervalo desejado
		Random random = new Random();
		int minDay = (int) LocalDate.of(2020, 1, 1).toEpochDay();
		int maxDay = (int) LocalDate.of(2023, 12, 31).toEpochDay();
		long randomDay = minDay + random.nextInt(maxDay - minDay);

		return LocalDate.ofEpochDay(randomDay);
	}

	private int generateRandomValidityDays() {
		// Implemente a lógica para gerar um número de dias aleatório para a validade
		return new Random().nextInt(30) + 1; // Modifique conforme necessário
	}


}
