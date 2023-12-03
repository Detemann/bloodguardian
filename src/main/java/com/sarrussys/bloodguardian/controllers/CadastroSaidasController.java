package com.sarrussys.bloodguardian.controllers;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import com.sarrussys.bloodguardian.models.BolsaSangue;
import com.sarrussys.bloodguardian.models.Saidas;
import com.sarrussys.bloodguardian.repositores.BolsaSangueRepository;
import com.sarrussys.bloodguardian.repositores.SaidasRepository;
import com.sarrussys.bloodguardian.util.Alerts;
import com.sarrussys.bloodguardian.util.Utils;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

public class CadastroSaidasController implements Initializable{
	private BolsaSangueRepository service;
	@FXML
	private TableView<BolsaSangue> tableEstoque;
	@FXML
	private TableColumn<BolsaSangue, String> codigoColumn;
	@FXML
	private TableColumn<BolsaSangue, String> dataColetaColumn;
	@FXML
	private TableColumn<BolsaSangue, String> dataValidadeColumn;
	@FXML
	private TableColumn<BolsaSangue, String> tipoColumn;

	private ObservableList<BolsaSangue> obsList;

	@FXML
	private TextField txtCodBolsa;
	@FXML
	private DatePicker dtSaida;
	@FXML

	private BolsaSangueRepository bolsaSangueRepository = new BolsaSangueRepository();

	private SaidasRepository saidasRepository = new SaidasRepository();
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		service = new BolsaSangueRepository();
		// Adiciona um listener para o evento de clique duplo na tabela
		tableEstoque.setOnMouseClicked(event -> {
			if (event.getClickCount() == 2) { // Verifica se foi um clique duplo
				handleTableViewDoubleClick();
			}
		});
		inicializarTabela();
	}

	@FXML
	public void handleTableViewDoubleClick() {
		BolsaSangue selectedBolsa = tableEstoque.getSelectionModel().getSelectedItem();
		if (selectedBolsa != null) {
			txtCodBolsa.setText(selectedBolsa.getCodigoBolsa());
			dtSaida.setValue(LocalDate.now());
		}
	}

	private void inicializarTabela() {
		// Configurar as colunas
		codigoColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCodigoBolsa()));
		dataColetaColumn.setCellValueFactory(cellData -> new SimpleStringProperty(formatarData(cellData.getValue().getDtColeta())));
		dataValidadeColumn.setCellValueFactory(cellData -> new SimpleStringProperty(formatarData(cellData.getValue().getValidade())));
		tipoColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTipoSanguineo().getTipoSanguineo()));
		// Preencher a tabela com dados do repositório
		List<BolsaSangue> bolsas = service.buscarTodos();
		obsList = FXCollections.observableArrayList(bolsas);
		tableEstoque.setItems(obsList);
	}

	private String formatarData(Date data) {
		if (data == null) {
			return null;
		}

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return sdf.format(data);
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

		Alerts.showAlert("Sucesso", "Saída Cadastrada!", "", Alert.AlertType.CONFIRMATION);
		saidasRepository.salvar(saida);
		txtCodBolsa.clear();
		dtSaida.setValue(null);
	}

	@FXML
	private void btnVoltar(ActionEvent event) {
		System.out.println("VoltarEstoque");
		MainMenuController main = new MainMenuController();
		main.loadMainMenu(event);
	}
}
