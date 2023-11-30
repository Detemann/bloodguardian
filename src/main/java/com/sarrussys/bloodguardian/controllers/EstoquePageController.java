package com.sarrussys.bloodguardian.controllers;

import com.sarrussys.bloodguardian.Main;
import com.sarrussys.bloodguardian.models.BolsaSangue;
import com.sarrussys.bloodguardian.repositores.BolsaSangueRepository;
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
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicInteger;

public class EstoquePageController implements Initializable {
    private BolsaSangueRepository service;
    @FXML
    private TableView<BolsaSangue> tableEstoque;
    @FXML
    private TableColumn<BolsaSangue, String> tableColumnTipo;
    @FXML
    private TableColumn<BolsaSangue, Integer> tableColumnQuantidade;
    @FXML
    private TableColumn<BolsaSangue, Integer> tableColumnDuracao;

    private ObservableList<BolsaSangue> obsList;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        service = new BolsaSangueRepository();
        inicializarTabela();
    }

    private void inicializarTabela() {
        // Configurar as colunas
        AtomicInteger quant = new AtomicInteger();
        tableColumnTipo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTipoSanguineo().getTipoSanguineo()));
        tableColumnQuantidade.setCellValueFactory(cellData -> {
            int tipoSanguineo = cellData.getValue().getTipoSanguineo().getIdTipoSanguineo();
            int quantidade = service.buscarPorTipoSanguineo(""+tipoSanguineo).size();
            quant.set(quantidade);
            return new SimpleObjectProperty<>(quantidade);
        });

        tableColumnDuracao.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().calcularDuracao(quant)));

        // Preencher a tabela com dados do repositório
        List<BolsaSangue> bolsas = service.buscarTodos();
        obsList = FXCollections.observableArrayList(bolsas);
        tableEstoque.setItems(obsList);
    }


    @FXML
    private void btnVoltar(ActionEvent event) {
        System.out.println("VoltarEstoque");
        MainMenuController main = new MainMenuController();
        main.loadMainMenu(event);
    }

}
