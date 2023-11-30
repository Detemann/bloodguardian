package com.sarrussys.bloodguardian.controllers;

import com.sarrussys.bloodguardian.services.SaidaService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class SaidaPageController implements Initializable {
    @FXML
    private PieChart pieChart;

    private SaidaService saidaService = new SaidaService();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<Integer> resultado = saidaService.getPorcentageEntradasSaidas();


        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data("Entradas", resultado.get(0)),
                        new PieChart.Data("Saídas", resultado.get(1)));

        pieChart.setData(pieChartData);
        pieChart.setTitle("Entrada e Saídas de Sangue");
    }
}
