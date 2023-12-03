package com.sarrussys.bloodguardian.controllers;

import com.sarrussys.bloodguardian.services.SaidaService;
import com.sarrussys.bloodguardian.util.Utils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.MenuItem;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class SaidaPageController implements Initializable {
    @FXML
    private PieChart pieChart;
    @FXML
    private MenuItem menuBtn;
    @FXML
    private MenuItem estoqueBtn;

    private MainMenuController mainMenuController = new MainMenuController();

    private SaidaService saidaService = new SaidaService();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<Integer> resultado = saidaService.getPorcentageEntradasSaidas();

        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data("Entradas", resultado.get(0)),
                        new PieChart.Data("Saídas", resultado.get(1)));



        pieChart.setData(pieChartData);
        pieChartData.get(0).getNode().setStyle("-fx-pie-color: #4BA777");
        pieChartData.get(1).getNode().setStyle("-fx-pie-color: #C90000");
        pieChart.setLegendVisible(false);
    }
    @FXML
    private void btnVoltar(ActionEvent event) {
        System.out.println("VoltarEstoque");
        MainMenuController main = new MainMenuController();
        main.loadMainMenu(event);
    }
}
