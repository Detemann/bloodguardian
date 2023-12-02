package com.sarrussys.bloodguardian.controllers;

import com.sarrussys.bloodguardian.Main;
import com.sarrussys.bloodguardian.models.BolsaSangue;
import com.sarrussys.bloodguardian.models.ModeloDados;
import com.sarrussys.bloodguardian.repositores.BolsaSangueRepository;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicInteger;

public class EstoquePageController implements Initializable {
    private BolsaSangueRepository service;
    @FXML
    private TableView<ModeloDados> tableEstoque;
    @FXML
    private TableColumn<ModeloDados, String> tableColumnTipo;
    @FXML
    private TableColumn<ModeloDados, String> tableColumnQuantidade;
    @FXML
    private TableColumn<ModeloDados, String> tableColumnDuracao;

    private ObservableList<ModeloDados> obsList;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        service = new BolsaSangueRepository();
        inicializarTabela();
    }

    private void inicializarTabela() {
        // Configurar as colunas
        tableColumnTipo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTipoSanguineo()));
        tableColumnQuantidade.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getQuantidade()));
        tableColumnDuracao.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDuracao()));

        // Preencher a tabela com dados do repositório

        List<ModeloDados> modelos = new ArrayList<>();

        Map<String, Integer> tiposSanguineos = Map.of(
                "A+", 1,
                "A-", 2,
                "B+", 3,
                "B-", 4,
                "AB+", 5,
                "AB-", 6,
                "O+", 7,
                "O-", 8
        );

        for (Map.Entry<String, Integer> entry : tiposSanguineos.entrySet()) {
            String tipoSanguineo = entry.getKey();
            int idTipoSanguineo = entry.getValue();
            int quantidade = service.quantidadeDeTipo(idTipoSanguineo);
            modelos.add(new ModeloDados(tipoSanguineo, String.valueOf(quantidade)));
        }

        obsList = FXCollections.observableArrayList(modelos);
        tableEstoque.setItems(obsList);
    }


    @FXML
    private void btnVoltar(ActionEvent event) {
        System.out.println("VoltarEstoque");
        MainMenuController main = new MainMenuController();
        main.loadMainMenu(event);
    }

}
