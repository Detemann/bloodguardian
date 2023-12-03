package com.sarrussys.bloodguardian.controllers;

import com.dlsc.formsfx.view.controls.SimpleDateControl;
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
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class EstoquePageController implements Initializable {
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


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        service = new BolsaSangueRepository();
        inicializarTabela();
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


    @FXML
    private void btnVoltar(ActionEvent event) {
        System.out.println("VoltarEstoque");
        MainMenuController main = new MainMenuController();
        main.loadMainMenu(event);
    }

}
